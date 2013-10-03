package com.parallelbrains.baselayout.repository.impl;

import com.parallelbrains.baselayout.model.User;
import com.parallelbrains.baselayout.repository.UserDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository(value = "userDao")
@Transactional(propagation = Propagation.MANDATORY)
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    public User get(String username) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userRoot = criteria.from(User.class);

        criteria.where(builder.equal(userRoot.get("username"), username));
        criteria.where(builder.equal(userRoot.get("deleted"), false));

        try {
            return getEntityManager().createQuery(criteria).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
