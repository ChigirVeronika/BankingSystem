package by.bsuir.banking.controller;

import by.bsuir.banking.entity.Bill;
import by.bsuir.banking.entity.Deposit;
import by.bsuir.banking.entity.User;
import by.bsuir.banking.service.BillService;
import by.bsuir.banking.service.DepositService;
import by.bsuir.banking.service.UserService;
import by.bsuir.banking.service.exception.ServiceException;
import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

@Controller
@RequestMapping("/")
public class DepositController {
    @Autowired
    DepositService depositService;

    @Autowired
    BillService billService;

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

    @RequestMapping(value = {"/create-deposit-{userId}"}, method = RequestMethod.GET)
    public String newDeposit(ModelMap model, @PathVariable Long userId) {
        Deposit deposit = new Deposit();
        model.addAttribute("userId", userId);
        model.addAttribute("deposit", deposit);
        model.addAttribute("edit", false);
        return "create-deposit";
    }

    @RequestMapping(value = {"/create-deposit-{userId}"}, method = RequestMethod.POST)
    public String saveDeposit(@Valid Deposit deposit, ModelMap model, BindingResult result,
                              @PathVariable Long userId) {
        if (result.hasErrors()) {
            return "create-deposit-{userId}";
        }
//        Date date = new Date();
//        Timestamp time = new Timestamp(date.getTime());


        User user = userService.findById(userId);
        deposit.setCreator(user);
        depositService.saveDeposit(deposit);

//        Bill moneyBill = new Bill(
//                "moneyBill " + user.getIdNumber(),
//                String.valueOf(111111111111L) + user.getId().toString(),
//                "code",
//                "passive",
//                deposit);
//        Bill percentBill = new Bill(
//                "percentBill " + user.getIdNumber(),
//                String.valueOf(222222222222L) + user.getId().toString(),
//                "code",
//                "passive",
//                deposit);
//        billService.saveBill(moneyBill);
//        billService.saveBill(percentBill);

        //Future<ClassLoaderServiceImpl.Work> future = asyncWorker.work();
        // TODO: 9/11/2016  
        //return "redirect:/depositlist";// TODO: 9/11/2016
        return "redirect:/home";
    }

    @RequestMapping(value = {"/delete-deposit-{agreementNumber}"}, method = RequestMethod.GET)
    public String deleteDeposit(@PathVariable Long agreementNumber) {
        depositService.deleteDeposit(agreementNumber);
        return "redirect:/home";
    }

}
