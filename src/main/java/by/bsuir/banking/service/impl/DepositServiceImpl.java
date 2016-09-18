package by.bsuir.banking.service.impl;

import by.bsuir.banking.dao.DepositDao;
import by.bsuir.banking.entity.Deposit;
import by.bsuir.banking.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("depositService")
@Transactional
public class DepositServiceImpl implements DepositService{

    @Autowired
    private DepositDao depositDao;

    @Override
    public Deposit findById(Long id) {
        return depositDao.findById(id);

    }

    @Override
    public Deposit findByName(String name) {
        return  depositDao.findByName(name);
    }

    @Override
    public void saveDeposit(Deposit deposit) {
        depositDao.save(deposit);
    }

    @Override
    public void updateDeposit(Deposit deposit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteDeposit(Long agreementNumber) {
        depositDao.deleteByAgreementNumber(agreementNumber);
    }

    @Override
    public List<Deposit> findAllDeposits() {
        return depositDao.findAllDeposits();
    }
}
