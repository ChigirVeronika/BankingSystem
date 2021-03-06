package by.bsuir.banking.service.impl;

import by.bsuir.banking.dao.BillDao;
import by.bsuir.banking.dao.DepositDao;
import by.bsuir.banking.entity.Bill;
import by.bsuir.banking.entity.Deposit;
import by.bsuir.banking.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service("billService")
@Transactional
public class BillServiceImpl implements BillService {

    @Autowired
    private BillDao billDao;

    @Autowired
    private DepositDao depositDao;

    @Override
    public Bill findById(Long id) {
        Bill bill = billDao.findById(id);
        return bill;
    }

    @Override
    public Bill findByCode(String code) {
        return billDao.findByCode(code);
    }

    @Override
    public void saveBill(Bill bill) {
        billDao.save(bill);
    }

    @Override
    public void updateBill(Bill bill) {
        billDao.update(bill);
    }

    @Override
    public void deleteBill(Long id) {
        billDao.deleteById(id);

    }

    @Override
    public List<Bill> findAllBillsOfDeposit(Long depositId) {
        return billDao.findAllDepositBills(depositId);
    }

    @Override
    public List<Bill> findAllBills() {
        return billDao.findAllBills();
    }
}
