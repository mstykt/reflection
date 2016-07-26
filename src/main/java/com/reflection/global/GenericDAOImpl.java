package com.reflection.global;

import com.reflection.model.BaseModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by mesut on 27.07.2016.
 */
public abstract class GenericDAOImpl<T extends BaseModel> implements Serializable, GenericDAO<T> {

    @Autowired
    protected SessionFactory sessionFactory;
    final protected Class<T> classType;

    public GenericDAOImpl() {
        this.classType = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public Long save(final T t) {
        final Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(t);
    }

    @Override
    public T findById(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return session.get(classType, id);
    }

    @Override
    public T update(final T t) {
        final Session session = sessionFactory.getCurrentSession();
        return (T) session.merge(t);
    }

    @Override
    public T delete(final T t) {
        final Session session = sessionFactory.getCurrentSession();
        t.setActive(false);
        t.setDeleted(true);
        return (T) session.merge(t);
    }

}
