package by.bsuir.banking.dao;

import by.bsuir.banking.entity.Bill;
import by.bsuir.banking.entity.Deposit;

import java.util.List;

public interface BillDao {
    Bill findById(Long id);
    void save(Bill bill);
    void deleteByName(String name);
    List<Bill> findAllDepositBills(Long depositId);

}
