package org.example.data_accesse;

import org.example.model.Person;

import java.util.HashSet;

public interface PersonDAO {

    Person savePerson(Person person);

    Person findByEmail(String email);

    HashSet<Person> findByName(String name);

    Person findById(int idNumber);

    HashSet<Person> findAll();

    boolean deletePerson(Person person);
}
