package org.example.model;

import org.example.sequenser.CourseSequencer;

import java.util.Objects;

public class Student {

    private int id;
    private String name;
    private String email;
    private String address;


    // Constructors
    public Student(String name, String email, String address) {
        setName(name);
        setEmail(email);
        setAddress(address);
        setId();
    }


    // Setters

    private void setId() {
        this.id = CourseSequencer.nextId();
    }

    public void setName(String name) {
        Objects.requireNonNull(name);
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Empty Name");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        Objects.requireNonNull(email);
        if (email.trim().isEmpty()) {
            throw new IllegalArgumentException("Empty email");
        }
        this.email = email;
    }

    public void setAddress(String address) {
        Objects.requireNonNull(address);
        if (address.trim().isEmpty()) {
            throw new IllegalArgumentException("Empty adress");
        }
        this.address = address;
    }


    // Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
