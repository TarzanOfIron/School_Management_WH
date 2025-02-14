package org.example.data_accesse;

import org.example.model.Lecture;
import java.time.LocalDate;
import java.util.HashSet;

public interface LectureDAO {

    Lecture saveLecture(Lecture lecture);

    Lecture findById(int id);

    HashSet<Lecture> findByName(String name);

    HashSet<Lecture> findByDate(LocalDate localDate);

    HashSet<Lecture> findAll();

    boolean removeLecture(Lecture lecture);
}
