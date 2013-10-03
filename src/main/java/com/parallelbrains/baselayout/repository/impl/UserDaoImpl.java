package com.parallelbrains.baselayout.repository.impl;

import com.parallelbrains.baselayout.model.User;
import com.parallelbrains.baselayout.repository.UserDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "userDao")
@Transactional(propagation = Propagation.MANDATORY)
public class UserDaoImpl extends BaseDao<User> implements UserDao {



}
