package by.bsuir.banking.dao.impl;

import by.bsuir.banking.dao.AbstractDao;
import by.bsuir.banking.dao.BillDao;
import by.bsuir.banking.entity.Bill;
import by.bsuir.banking.entity.Deposit;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("billDao")
public class BillDaoImpl  extends AbstractDao<Long, Bill> implements BillDao {
    @Override
    public Bill findById(Long id) {
        Bill bill = getByKey(id);
        return bill;
    }

    @Override
    public Bill findByCode(String code) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("code", code));
        Bill bill = (Bill) criteria.uniqueResult();
        return bill;
    }

    @Override
    public void save(Bill bill) {
        persist(bill);
    }

    @Override
    public void update(Bill bill) {
        updateEntity(bill);
    }

    @Override
    public void deleteById(Long id)    {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Bill bill = (Bill)criteria.uniqueResult();
        delete(bill);
    }

    @Override
    public List<Bill> findAllDepositBills(Long depositId) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("user_id", depositId));
        List<Bill> bills = (List<Bill>)criteria.list();
        return bills;
    }

    @Override
    public List<Bill> findAllBills() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Bill> bills = (List<Bill>)criteria.list();
        return bills;
    }
}
