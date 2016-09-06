package by.bsuir.banking.controller;

import by.bsuir.banking.entity.User;
import by.bsuir.banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;


    @Autowired
    MessageSource messageSource;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users = userService.findAllSortedUsers();
        model.addAttribute("users", users);
        return "userslist";
    }

    @RequestMapping(value = {"/create-user"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
//        List<AccommodationCity> ac = new ArrayList<>();
//        ac.add(new AccommodationCity(1L,"Minsk"));
//        ac.add(new AccommodationCity(2L,"Grodno"));
//        model.addAttribute("aclist", ac);

        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "create-user";
    }

    @RequestMapping(value = {"/create-user"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
                           ModelMap model) {
        if (result.hasErrors()) {
            return "create-user";
        }
        if (!userService.isUserUnique(user.getId(), user.getPassportSeriesAndNumber())) {
            FieldError ssoError = new FieldError("user", "passportSeriesAndNumber", messageSource.getMessage("non.unique.PassportSeriesAndNumber", new String[]{user.getPassportSeriesAndNumber()}, Locale.getDefault()));
            result.addError(ssoError);
            return "create-user";
        }
        userService.saveUser(user);
        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
        return "userslist";
    }

    @RequestMapping(value = {"/edit-user-{passportSeriesAndNumber}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String passportSeriesAndNumber, ModelMap model) {
        User user = userService.findByPassport(passportSeriesAndNumber);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "create-user";
    }

    @RequestMapping(value = {"/edit-user-{passportSeriesAndNumber}"}, method = RequestMethod.POST)
    public String updateUsers(@Valid User user, BindingResult result,
                              ModelMap model, @PathVariable String passportSeriesAndNumber) {
        if (result.hasErrors()) {
            return "create-user";
        }
        userService.updateUser(user);
        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " updated successfully");
        return "userslist";
    }

    @RequestMapping(value = {"/delete-user-{passportSeriesAndNumber}"}, method = RequestMethod.GET)
    public String deleteUsers(@PathVariable String passportSeriesAndNumber) {
        userService.deleteByPassport(passportSeriesAndNumber);
        return "redirect:/list";
    }
}
