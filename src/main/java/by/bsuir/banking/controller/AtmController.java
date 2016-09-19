package by.bsuir.banking.controller;

import by.bsuir.banking.entity.Bill;
import by.bsuir.banking.service.BillService;
import by.bsuir.banking.service.DepositService;
import by.bsuir.banking.service.UserService;
import by.bsuir.banking.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/")
public class AtmController {
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

    @RequestMapping(value = {"/atm"}, method = RequestMethod.GET)
    public String goToAmt() {
        return "atm";
    }

    @RequestMapping(value = {"/atm-identify-card-{userId}"}, method = RequestMethod.POST)
    public String saveUserChoice(@RequestBody String deposit,
                                 @RequestParam Integer code,
                                 ModelMap model, BindingResult result,
                                 @PathVariable Long userId) throws ServiceException {
        model.addAttribute("userId", userId);
        model.addAttribute("code", code);
        if (result.hasErrors()) {
            return "choose-credit";
        }
        Bill bill = billService.findByCode(String.valueOf(code));
        model.addAttribute("bill", bill);
        model.addAttribute("gotmoney", 0.0);
        return "atm-inside";
    }

    @RequestMapping(value = {"/atm-get-money-{id}"}, method = RequestMethod.POST)
    public String getMoney(@RequestBody String deposit,
                           @RequestParam Integer money,
                           ModelMap model, BindingResult result,
                           @PathVariable Long id) throws ServiceException {
        model.addAttribute("id", id);
        if (result.hasErrors()) {
            return "choose-credit";
        }
        Bill bill = billService.findById(id);
        bill.setMoneySum(bill.getMoneySum() - (double)money);
        billService.updateBill(bill);
        model.addAttribute("bill", bill);
        model.addAttribute("gotmoney", (double)money);

        return "atm-inside";
    }

}
