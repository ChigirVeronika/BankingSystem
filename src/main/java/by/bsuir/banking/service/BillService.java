package by.bsuir.banking.service;


import by.bsuir.banking.entity.Bill;

import java.util.List;

public interface BillService {
    Bill findById(Long id);
    void saveBill(Bill bill);
    void updateBill(Bill bill);
    void deleteBill(Long depositId);
    List<Bill> findAllBillsOfDeposit(Long depositId);
    List<Bill> findAllBills();
}
