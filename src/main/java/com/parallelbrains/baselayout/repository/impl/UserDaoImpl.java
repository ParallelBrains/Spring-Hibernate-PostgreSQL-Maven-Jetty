package com.parallelbrains.baselayout.repository.impl;

import com.parallelbrains.baselayout.model.User;
import com.parallelbrains.baselayout.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "userDao")
@Transactional(propagation = Propagation.MANDATORY)
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    public User get(String username) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userRoot = criteria.from(User.class);

        List<Predicate> wherePredicates = new ArrayList<Predicate>();
        wherePredicates.add(builder.equal(userRoot.get("username"), username));
        wherePredicates.add(builder.equal(userRoot.get("deleted"), false));

        buildWhereClause(criteria, wherePredicates);

        try {
            return getEntityManager().createQuery(criteria).getSingleResult();
        } catch (NoResultException no) {
            LOGGER.debug("No result found for username {}", username);
        } catch (Exception e) {
            LOGGER.error("Exception: ", e);
        }

        return null;
    }
}
