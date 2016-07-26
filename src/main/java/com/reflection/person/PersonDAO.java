package com.reflection.person;

import com.reflection.global.GenericDAO;
import com.reflection.model.Person;

import java.util.List;

/**
 * Created by mesut on 27.07.2016.
 */
public interface PersonDAO extends GenericDAO<Person> {
    List<Person> findAll(Person person);
}
