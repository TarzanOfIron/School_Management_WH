package org.example.data_accesse;

import org.example.model.Lecture;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class LectureDAOSet implements LectureDAO {

    private HashSet<Lecture> lectures = new HashSet<>();

    @Override
    public Lecture saveLecture(Lecture lecture) {
        Objects.requireNonNull(lecture);
        lectures.add(lecture);
        return lecture;
    }

    @Override
    public Lecture findById(int id) {
        Lecture lectureToReturn = null;
        for (Lecture lecture : lectures) {
            if (lecture.getLectureId() == id) {
                lectureToReturn = lecture;
                break;
            }
        }
        return lectureToReturn;
    }

    @Override
    public HashSet<Lecture> findByName(String name) {
        HashSet<Lecture> lecturesToReturn = new HashSet<>();
        for (Lecture lecture : lectures) {
            if (lecture.getLectureName().equals(name)) {
                lecturesToReturn.add(lecture);
            }
        }
        return lecturesToReturn;
    }

    @Override
    public HashSet<Lecture> findByDate(LocalDate localDate) {
        HashSet<Lecture> lecturesToReturn = new HashSet<>();
        for (Lecture lecture : lectures) {
            if (lecture.getDate().equals(localDate)) {
                lecturesToReturn.add(lecture);
            }
        }
        return lecturesToReturn;
    }

    @Override
    public HashSet<Lecture> findAll() {
        return lectures;
    }

    @Override
    public boolean removeLecture(Lecture lecture) {
        for (Lecture lectureElement : lectures) {
            if (lectureElement.equals(lecture)) {
                lectures.remove(lecture);
                return true;
            }
        }
        return false;
    }
}
