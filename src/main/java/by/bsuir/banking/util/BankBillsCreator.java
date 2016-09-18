package by.bsuir.banking.util;

import by.bsuir.banking.entity.Bill;
import by.bsuir.banking.entity.Deposit;

public class BankBillsCreator {
    public static Bill dollarsBankBill =
            new Bill("BILL",
                    "0000000000001",
                    "USD",
                    "active",
                    1000.0000);
    public static Bill dollarsCashBox =
            new Bill("CASH-BOX",
                    "0000000000001",
                    "USD",
                    "active",
                    0.0000);
    /////////////////////
    public static Bill rubelsBankBill =
            new Bill("BILL",
                    "0000000000002",
                    "RUB",
                    "active",
                    1000.0000);
    public static Bill rubelsCashBox =
            new Bill("CASH-BOX",
                    "0000000000001",
                    "RUB",
                    "active",
                    0.0000);


}
