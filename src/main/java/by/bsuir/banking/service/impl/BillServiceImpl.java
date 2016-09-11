package by.bsuir.banking.service.impl;

import by.bsuir.banking.dao.BillDao;
import by.bsuir.banking.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("billService")
@Transactional
public class BillServiceImpl implements BillService {

    @Autowired
    private BillDao billDao;
}
