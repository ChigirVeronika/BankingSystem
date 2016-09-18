package by.bsuir.banking.controller;

import by.bsuir.banking.entity.Bill;
import by.bsuir.banking.service.BillService;
import by.bsuir.banking.service.DepositService;
import by.bsuir.banking.service.UserService;
import by.bsuir.banking.util.BankBillsCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class BankController {
    @Autowired
    DepositService depositService;

    @Autowired
    BillService billService;

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    private final static Double EMPTY_CASH = 0.0000;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = {"/end-bank-day"}, method = RequestMethod.GET)
    public String endBankDay(ModelMap model) {
        BankBillsCreator.dollarsBankBill.setMoneySum(
                BankBillsCreator.dollarsBankBill.getMoneySum() + BankBillsCreator.dollarsCashBox.getMoneySum());
        BankBillsCreator.dollarsCashBox.setMoneySum(EMPTY_CASH);
        BankBillsCreator.rubelsBankBill.setMoneySum(
                BankBillsCreator.rubelsBankBill.getMoneySum() + BankBillsCreator.rubelsCashBox.getMoneySum());
        BankBillsCreator.rubelsCashBox.setMoneySum(EMPTY_CASH);
        List<Bill> userBills = billService.findAllBills();
        for (Bill bill : userBills) {
            Integer p = bill.getDeposit().getPercent();
            Double m = bill.getMoneySum();
            Double percentToAdd = (double)p / (double) 100 * m / (double) 365;
            bill.setMoneySum(bill.getMoneySum() + percentToAdd);
            billService.updateBill(bill);
        }
        // TODO: 9/18/2016 for credits also 
        return "home";
    }

    @RequestMapping(value = {"/bank"}, method = RequestMethod.GET)
    public String showBank(ModelMap model) {
        List<Bill> bills = new ArrayList<>();
        bills.add(BankBillsCreator.dollarsBankBill);
        bills.add(BankBillsCreator.dollarsCashBox);
        bills.add(BankBillsCreator.rubelsBankBill);
        bills.add(BankBillsCreator.rubelsCashBox);
        model.addAttribute("bills", bills);
        return "bank";
    }
}
