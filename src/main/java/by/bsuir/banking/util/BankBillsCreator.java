package by.bsuir.banking.util;

import by.bsuir.banking.entity.Bill;
import by.bsuir.banking.entity.Deposit;

public class BankBillsCreator {
    public static Bill dollarsBankBill =
            new Bill("dollarsBankBill","0000000000001","0001","active", 10000L);
    public static Bill rubelsBankBill =
            new Bill("rubelsBankBill","0000000000002","0002","passive", 10000L);


}
