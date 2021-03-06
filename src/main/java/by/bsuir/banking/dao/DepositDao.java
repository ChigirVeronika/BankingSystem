package by.bsuir.banking.dao;

import by.bsuir.banking.entity.Deposit;

import java.util.List;

public interface DepositDao {
    Deposit findById(Long id);
    Deposit findByName(String name);
    Deposit findByUserId(Long userId);
    void save(Deposit deposit);
    void deleteByAgreementNumber(Long agreementNumber);
    List<Deposit> findAllDeposits();
}
