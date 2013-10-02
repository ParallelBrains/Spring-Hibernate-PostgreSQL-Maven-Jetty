package com.parallelbrains.baselayout.repository;

import com.parallelbrains.baselayout.utils.DaoHelper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public abstract class BaseDaoTest {

    @Autowired
    protected DaoHelper daoHelper;

}
