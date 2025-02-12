package org.example.data_accesse;

import org.example.model.Student;

import java.util.HashSet;

public interface StudentDAO {

    Student saveStudent(Student student);

    Student findByEmail(String email);

    HashSet<Student> findByName(String name);

    Student findById(int id);

    HashSet<Student> findAll();

    boolean deleteStudent(Student student);
}
