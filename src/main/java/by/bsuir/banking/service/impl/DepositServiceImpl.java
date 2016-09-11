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
        return null;
    }

    @Override
    public void saveDeposit(Deposit deposit) {

    }

    @Override
    public void updateDeposit(Deposit deposit) {

    }

    @Override
    public void deleteDeposit(Long agreementNumber) {

    }

    @Override
    public List<Deposit> findAllDepositsOfUser(Long userId) {
        return null;
    }
}
