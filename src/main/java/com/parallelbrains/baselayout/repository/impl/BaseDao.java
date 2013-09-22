package com.parallelbrains.baselayout.repository.impl;

import com.parallelbrains.baselayout.model.BaseModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDao<T extends BaseModel> {

    private Class<T> clazz
            = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @PersistenceContext
    private EntityManager entityManager;

    public T get(final Long id) {
        if (id != null) {
            return entityManager.find(clazz, id);
        } else {
            return null;
        }
    }

    public List<T> getAll() {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(clazz);

        Root<T> tRoot = criteria.from(clazz);

        List<Predicate> wherePredicates = new ArrayList<Predicate>();
        wherePredicates.add(builder.equal(tRoot.get("deleted"), false));

        buildWhereClause(criteria, wherePredicates);

        return getEntityManager().createQuery(criteria).getResultList();
    }

    public List<T> getAllIncludingDeleted() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    public void save(final T entity) {
        entity.setUpdated(new Date());

        if (entity.getId() == null || entity.getId() == 0) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
    }

    public void delete(final T entity) {
        entity.setDeleted(true);

        save(entity);
    }

    public void delete(final Long entityId) {
        final T entity = get(entityId);

        delete(entity);
    }

    protected <T> void buildWhereClause(CriteriaQuery<T> criteria, List<Predicate> wherePredicates) {
        if (!wherePredicates.isEmpty()) {
            Predicate[] predicates = new Predicate[wherePredicates.size()];

            for (int x = 0; x < wherePredicates.size(); x++) {
                predicates[x] = wherePredicates.get(x);
            }

            criteria.where(entityManager.getCriteriaBuilder().and(predicates));
        }
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
