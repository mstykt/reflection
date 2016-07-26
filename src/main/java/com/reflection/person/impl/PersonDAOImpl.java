package com.reflection.person.impl;

import com.reflection.global.GenericDAO;
import com.reflection.model.Person;
import com.reflection.person.PersonDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mesut on 27.07.2016.
 */
@Repository
public class PersonDAOImpl extends GenericDAO<Person> implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Person> findAll(Person person) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Person.class);
        return criteria.list();
    }
}
