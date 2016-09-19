package by.bsuir.banking.controller;

import by.bsuir.banking.entity.Deposit;

public class MoneyUtil {
    public static Double countFullMoneyToPayByCredit(Deposit mainCredit, Double moneySum) {
        Double i = (double) mainCredit.getPercent() / (double) 12 / (double) 100;
        Integer n = 12;
        switch (mainCredit.getType()) {
            case "First": {
                n = 12;
            }
            break;
            case "Second": {
                n = 24;
            }
            break;
        }
        Double k = (i * Math.pow((i + 1.0), (double) n)) / (Math.pow((1.0 + i), (double) n) - 1.0);
//        Double aPerMonth = k * moneySum;
//        Double aPerDay = k * moneySum / 30.0;
        Double aFull = k * moneySum * (double) n;
        //moneySum = aFull;
        return aFull;
    }

    public static Double countDayMoneyToPayByCredit(Deposit mainCredit, Double moneySum) {
        Double i = (double) mainCredit.getPercent() / (double) 12 / (double) 100;
        Integer n = 12;
        Double aPerDay = 0.0;
        switch (mainCredit.getType()) {
            case "First": {
                n = 12;
                Double k = (i * Math.pow((i + 1.0), (double) n)) / (Math.pow((1.0 + i), (double) n) - 1.0);
                aPerDay = k * moneySum / 30.0;
            }
            break;
            case "Second": {
                n = 24;
                aPerDay = (moneySum / (double) n) +
                        (moneySum * (double) mainCredit.getPercent() / (double) 100 / (double) 365 * 30.5);
            }
            break;
        }

        return aPerDay;
    }
}
