package by.bsuir.banking.controller;

import by.bsuir.banking.entity.User;
import by.bsuir.banking.service.UserService;
import by.bsuir.banking.service.exception.ServiceException;
import org.apache.log4j.Logger;
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

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;


    @Autowired
    MessageSource messageSource;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users;
        try {
            users = userService.findAllSortedUsers();
        } catch (ServiceException e) {
            return "error";
        }
        model.addAttribute("users", users);
        return "userslist";
    }

    @RequestMapping(value = {"/create-user"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
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
        try {
            if(!validateUser(user,result,userService)){
                return "create-user";
            }

            userService.saveUser(user);
        } catch (ServiceException e) {
            return "error";
        }
        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
        return "home";
    }

    @RequestMapping(value = {"/edit-user-{passportSeriesAndNumber}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String passportSeriesAndNumber, ModelMap model) {
        User user = null;
        try {
            user = userService.findByPassport(passportSeriesAndNumber);
        } catch (ServiceException e) {
            return "error";
        }
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
        try {
            if(!validateUser(user,result,userService)){
                return "create-user";
            }
            userService.updateUser(user);
        } catch (ServiceException e) {
            return "error";
        }
        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " updated successfully");
        return "home";
    }

    @RequestMapping(value = {"/delete-user-{passportSeriesAndNumber}"}, method = RequestMethod.GET)
    public String deleteUsers(@PathVariable String passportSeriesAndNumber) {
        try {
            userService.deleteByPassport(passportSeriesAndNumber);
        } catch (ServiceException e) {
            return "error";
        }
        return "redirect:/list";
    }

    private boolean validateUser(User user,BindingResult result, UserService userService) throws ServiceException {
        if (!userService.isUserUnique(user.getId(), user.getPassportSeriesAndNumber())) {
            FieldError ssoError = new FieldError("user", "passportSeriesAndNumber", messageSource.getMessage("non.unique.PassportSeriesAndNumber", new String[]{user.getPassportSeriesAndNumber()}, Locale.getDefault()));
            result.addError(ssoError);
            return false;
        }
        if (!userService.isUserIdNumberUnique(user.getId(), user.getIdNumber())) {
            FieldError ssoError = new FieldError("user", "idNumber", messageSource.getMessage("non.unique.PassportSeriesAndNumber", new String[]{user.getPassportSeriesAndNumber()}, Locale.getDefault()));
            result.addError(ssoError);
            return false;
        }
        if (!userService.isUserEmailUnique(user.getId(), user.getIdNumber())) {
            FieldError ssoError = new FieldError("user", "email", messageSource.getMessage("non.unique.PassportSeriesAndNumber", new String[]{user.getPassportSeriesAndNumber()}, Locale.getDefault()));
            result.addError(ssoError);
            return false;
        }

        ////
        if (!user.getFirstName().matches("[a-zA-Z]+")){
            FieldError error = new FieldError("user", "firstName", messageSource.getMessage("Letters.user.text", new String[]{user.getPassportSeriesAndNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }
        if (!user.getLastName().matches("[a-zA-Z]+")){
            FieldError error = new FieldError("user", "lastName", messageSource.getMessage("Letters.user.text", new String[]{user.getPassportSeriesAndNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }
        if (!user.getMiddleName().matches("[a-zA-Z]+")){
            FieldError error = new FieldError("user", "middleName", messageSource.getMessage("Letters.user.text", new String[]{user.getPassportSeriesAndNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }

        // TODO: 9/7/2016 birthday
        if (user.getGender()==null){
            FieldError error = new FieldError("user", "gender", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getPassportSeriesAndNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }
        if(user.getPassportSeriesAndNumber()==null){
            FieldError error = new FieldError("user", "passportSeriesAndNumber", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getPassportSeriesAndNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }
        if(user.getWhomGranted()==null){
            FieldError error = new FieldError("user", "whomGranted", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getPassportSeriesAndNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }
        // TODO: 9/7/2016 granted date
        if(user.getIdNumber()==null){
            FieldError error = new FieldError("user", "idNumber", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getPassportSeriesAndNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }
        if(user.getBirthPlace()==null){
            FieldError error = new FieldError("user", "birthPlace", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getPassportSeriesAndNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }
        if(user.getAccommodationAddress()==null){
            FieldError error = new FieldError("user", "accommodationAddress", messageSource.getMessage("NotEmpty.user.text", new String[]{user.getPassportSeriesAndNumber()}, Locale.getDefault()));
            result.addError(error);
            return false;
        }

        return true;
    }
}
