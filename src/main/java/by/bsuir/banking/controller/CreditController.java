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
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class CreditController {
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

    @RequestMapping(value = {"/choose-credit-{userId}"}, method = RequestMethod.GET)
    public String showChooseCreditPage(ModelMap model, @PathVariable Long userId) {
        model.addAttribute("userId", userId);
        model.addAttribute("edit", false);
        List<Deposit> deposits = depositService.findAllDeposits();
        model.addAttribute("deposits", deposits);
        return "choose-credit";
    }

    @RequestMapping(value = {"/credit-list"}, method = RequestMethod.GET)
    public String showFullList(ModelMap model) {
        List<Deposit> deposits = depositService.findAllDeposits();
        model.addAttribute("deposits", deposits);
        return "creditlist";
    }

    @RequestMapping(value = {"/bill-list2"}, method = RequestMethod.GET)
    public String showUserDepositList2(ModelMap model) {
        List<Bill> bills = billService.findAllBills();
        model.addAttribute("bills", bills);
        return "billlist2";
    }

    @RequestMapping(value = {"/choose-credit-{userId}"}, method = RequestMethod.POST)
    public String saveUserChoice(@RequestBody String deposit,
                                 @RequestParam Double moneySum,
                                 ModelMap model, BindingResult result,
                                 @PathVariable Long userId) throws ServiceException {
        model.addAttribute("userId", userId);
        if (result.hasErrors()) {
            return "choose-credit";
        }
        int last = deposit.indexOf("&");
        String depositName = deposit.substring(8, last).replace("+", " ").replace("25", "");
        Deposit mainCredit = depositService.findByName(depositName);
        User user = userService.findById(userId);
        final String DEPOSIT_MONEY_TYPE = mainCredit.getMoney();
        switch (DEPOSIT_MONEY_TYPE) {
            case "USD": {
                BankBillsCreator.dollarsBankBill.setMoneySum(BankBillsCreator.dollarsBankBill.getMoneySum() - moneySum);
            }
            break;
            case "RUB": {
                BankBillsCreator.rubelsBankBill.setMoneySum(BankBillsCreator.rubelsBankBill.getMoneySum() - moneySum);
            }
            break;
        }
        //for any credit type
        moneySum = MoneyUtil.countFullMoneyToPayByCredit(mainCredit, moneySum);

        Bill bill = new Bill("name " + user.getPassportSeries() + user.getPassportNumber(),
                "number",
                "code",
                "active",
                moneySum,
                mainCredit,
                user);
        billService.saveBill(bill);

        return "redirect:/home";
    }

    @RequestMapping(value = {"/close-credit-{billId}"}, method = RequestMethod.GET)
    public String closeUserCredit(@PathVariable Long billId) {
        Bill bill = billService.findById(billId);
        String moneyType = bill.getDeposit().getMoney();
        switch (moneyType) {
            case "USD": {
                BankBillsCreator.dollarsCashBox.setMoneySum(
                        BankBillsCreator.dollarsCashBox.getMoneySum() + bill.getMoneySum());
            }
            break;
            case "RUB": {
                BankBillsCreator.rubelsCashBox.setMoneySum(
                        BankBillsCreator.rubelsCashBox.getMoneySum() + bill.getMoneySum());
            }
            break;
        }
        billService.deleteBill(billId);
        return "home";
    }
}
