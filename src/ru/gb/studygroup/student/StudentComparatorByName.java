package ru.gb.studygroup.student;

import ru.gb.studygroup.student.Student;

import java.util.Comparator;

public class StudentComparatorByName implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
