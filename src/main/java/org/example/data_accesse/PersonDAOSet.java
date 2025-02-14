package org.example.data_accesse;

import org.example.model.Person;

import java.util.HashSet;
import java.util.Objects;

public class PersonDAOSet implements PersonDAO{

   private HashSet<Person> persons = new HashSet<>();

    @Override
    public Person savePerson(Person person) {
        Objects.requireNonNull(person);
        persons.add(person);
        return person;
    }

    @Override
    public Person findByEmail(String email) {
        Objects.requireNonNull(email);
        Person personToReturn = null;
        for (Person person : persons){
            if (email.equals(person.getEmail())) {
                personToReturn = person;
            }
        }
        return personToReturn;
    }

    @Override
    public HashSet<Person> findByName(String name) {
        Objects.requireNonNull(name);
        HashSet<Person> personsWithName = new HashSet<>();
        for (Person person: persons) {
            if (person.getName().equals(name)){
                personsWithName.add(person);
            }
        }
        return personsWithName;
    }

    @Override
    public Person findById(int idNumber) {
        Person personToReturn = null;
        for (Person person : persons){
            if (person.getId() == idNumber) {
                personToReturn = person;
            }
        }
        return personToReturn;
    }

    @Override
    public HashSet<Person> findAll() {
        return persons;
    }

    @Override
    public boolean deletePerson(Person person) {
        Objects.requireNonNull(person);
        for (Person personElement : persons) {
            if (personElement.equals(person)){
                persons.remove(person);
                return true;
            }
        }
        return false;
    }
}
