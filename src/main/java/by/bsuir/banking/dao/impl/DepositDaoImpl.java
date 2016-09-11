package by.bsuir.banking.dao.impl;

import by.bsuir.banking.dao.AbstractDao;
import by.bsuir.banking.dao.DepositDao;
import by.bsuir.banking.entity.Bill;
import by.bsuir.banking.entity.Deposit;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("depositDao")
public class DepositDaoImpl  extends AbstractDao<Long, Deposit> implements DepositDao {
    @Override
    public Deposit findById(Long id) {
        Deposit deposit = findById(id);
        return deposit;
    }

    @Override
    public Deposit findByUserId(Long userId) {
        // TODO: 9/11/2016 возможно придется переделать в поиск конктетного депозита по имени
        return null;
    }

    @Override
    public void save(Deposit deposit) {
        persist(deposit);
    }

    @Override
    public void deleteByAgreementNumber(Long agreementNumber) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("agreementnumber", agreementNumber));
        Deposit deposit = (Deposit) criteria.uniqueResult();
        delete(deposit);

    }

    @Override
    public List<Deposit> findAllUserDeposits(Long userId) {

        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("user_id", userId));
        List<Deposit> deposits = (List<Deposit>)criteria.list();
        return deposits;
    }
}
