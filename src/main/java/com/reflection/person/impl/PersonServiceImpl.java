package com.reflection.person.impl;

import com.reflection.global.GenericServiceImpl;
import com.reflection.model.Person;
import com.reflection.person.PersonDAO;
import com.reflection.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mesut on 27.07.2016.
 */
@Service
@Transactional
public class PersonServiceImpl extends GenericServiceImpl<Person> implements PersonService{

    @Autowired
    private PersonDAO personDAO;

    @Override
    public List<Person> findAll(Person person) {
        if (person == null) {
            throw new RuntimeException("Person findAll failed. Person can not be null");
        }

        return personDAO.findAll(person);
    }
}
