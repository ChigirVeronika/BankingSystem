package by.bsuir.banking.entity.util;

import by.bsuir.banking.entity.Bill;
import by.bsuir.banking.entity.Deposit;

public class BankBillsCreator {
    public static Bill activeBankBill =
            new Bill("activeBankBill","0000000000001","0001","active", new Deposit(10000L));
    public static Bill passiveBankBill =
            new Bill("passiveBankBill","0000000000002","0002","passive", new Deposit(10000L));


}
