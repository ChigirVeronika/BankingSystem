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
        Deposit deposit = getByKey(id);
        return deposit;
    }

    @Override
    public Deposit findByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        Deposit deposit = (Deposit) criteria.uniqueResult();
        return deposit;
    }

    @Override
    public Deposit findByUserId(Long userId) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
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
    public List<Deposit> findAllDeposits() {

//        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Deposit> deposits = (List<Deposit>)criteria.list();
        return deposits;
    }
}
