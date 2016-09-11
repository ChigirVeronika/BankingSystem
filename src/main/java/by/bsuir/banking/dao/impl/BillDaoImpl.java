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
    public void save(Bill bill) {
        persist(bill);
    }

    @Override
    public void deleteByName(String name)    {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        Bill bill = (Bill)criteria.uniqueResult();
        delete(bill);
    }

    @Override
    public List<Bill> findAllDepositBills(Long depositId) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("deposit_id", depositId));
        List<Bill> bills = (List<Bill>)criteria.list();
        return bills;
    }
}
