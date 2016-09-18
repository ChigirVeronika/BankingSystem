package by.bsuir.banking.controller;

import by.bsuir.banking.entity.Bill;
import by.bsuir.banking.entity.Deposit;
import by.bsuir.banking.entity.User;
import by.bsuir.banking.service.BillService;
import by.bsuir.banking.service.DepositService;
import by.bsuir.banking.service.UserService;
import by.bsuir.banking.service.exception.ServiceException;
import by.bsuir.banking.util.BankBillsCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private final static Double EMPTY_CASH = 0.0000;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = {"/choose-deposit-{userId}"}, method = RequestMethod.GET)
    public String showChooseDepositPage(ModelMap model, @PathVariable Long userId) {
        model.addAttribute("userId", userId);
        model.addAttribute("edit", false);
        List<Deposit> deposits = depositService.findAllDeposits();
        model.addAttribute("deposits", deposits);
        return "choose-deposit";
    }

    @RequestMapping(value = {"/choose-deposit-{userId}"}, method = RequestMethod.POST)
    public String saveUserChoice(@RequestBody String deposit,
                                 @RequestParam Double moneySum,
                                 ModelMap model, BindingResult result,
                                 @PathVariable Long userId) throws ServiceException {
        model.addAttribute("userId", userId);
        if (result.hasErrors()) {
            return "choose-deposit";
        }
        int last = deposit.indexOf("&");
        String depositName = deposit.substring(8, last).replace("+", " ").replace("25", "");
        Deposit mainDeposit = depositService.findByName(depositName);
        User user = userService.findById(userId);

        Bill bill = new Bill("name " + user.getPassportSeries() + user.getPassportNumber(),
                "number",
                "code",
                "active",
                moneySum,
                mainDeposit,
                user);
        billService.saveBill(bill);

        final String DEPOSIT_MONEY_TYPE = mainDeposit.getMoney();
        switch (DEPOSIT_MONEY_TYPE) {
            case "USD": {
                BankBillsCreator.dollarsCashBox.setMoneySum(BankBillsCreator.dollarsCashBox.getMoneySum() + moneySum);
            }
            break;
            case "RUB": {
                BankBillsCreator.rubelsCashBox.setMoneySum(BankBillsCreator.rubelsCashBox.getMoneySum() + moneySum);
            }
            break;
        }
        return "redirect:/home";
    }

    @RequestMapping(value = {"/revoke-deposit-{billId}"}, method = RequestMethod.GET)
    public String revokeUserDeposit(@PathVariable Long billId) {
        Bill bill = billService.findById(billId);
        Double allBillMoney = bill.getMoneySum();
        switch (bill.getDeposit().getMoney()) {
            case "USD": {
                BankBillsCreator.dollarsBankBill.setMoneySum(BankBillsCreator.dollarsBankBill.getMoneySum()-(double)allBillMoney);
            }
            break;
            case "RUB": {
                BankBillsCreator.rubelsBankBill.setMoneySum(BankBillsCreator.rubelsBankBill.getMoneySum()-(double)allBillMoney);
            }
            break;
        }
        billService.deleteBill(bill.getId());
        return "home";
    }

    @RequestMapping(value = {"/deposit-list"}, method = RequestMethod.GET)
    public String showFullList(ModelMap model) {
        List<Deposit> deposits = depositService.findAllDeposits();
        model.addAttribute("deposits", deposits);
        return "depositlist";
    }

    @RequestMapping(value = {"/bill-list"}, method = RequestMethod.GET)
    public String showUserDepositList(ModelMap model) {
        List<Bill> bills = billService.findAllBills();
        model.addAttribute("bills", bills);
        return "billlist";
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
        return "home";
    }
}
