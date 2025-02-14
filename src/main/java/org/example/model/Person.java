package org.example.model;

import org.example.sequenser.PersonSequencer;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private String email;
    private String address;
    private Role role;

    public Person(String name, String email, String address, Role role) {
        setName(name);
        setEmail(email);
        setAddress(address);
        setRole(role);
        setId();
    }


    public int getId() {
        return id;
    }

    public void setId() {
        this.id = PersonSequencer.nextId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Objects.requireNonNull(email);
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        Objects.requireNonNull(address);
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        Objects.requireNonNull(role);
        this.role = role;
    }
}
