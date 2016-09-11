package by.bsuir.banking.service;

import by.bsuir.banking.entity.Deposit;

import java.util.List;


public interface DepositService {
    Deposit findById(Long id);
    void saveDeposit(Deposit deposit);
    void updateDeposit(Deposit deposit);
    void deleteDeposit(Long agreementNumber);
    List<Deposit> findAllDepositsOfUser(Long userId);
}
