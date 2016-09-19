package by.bsuir.banking.dao;

import by.bsuir.banking.entity.Bill;
import by.bsuir.banking.entity.Deposit;

import java.util.List;

public interface BillDao {
    Bill findById(Long id);
    Bill findByCode(String code);
    void save(Bill bill);
    void update(Bill bill);
    void deleteById(Long id);
    List<Bill> findAllDepositBills(Long depositId);
    List<Bill> findAllBills();

}
