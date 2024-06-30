package ru.gb.studygroup.studygroup;

import ru.gb.studygroup.student.Student;

import java.util.Iterator;
import java.util.List;

public class StudentIterator implements Iterator<Student> {

    private int index;
    private List<Student> studentList;

    public StudentIterator(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean hasNext() {
        return studentList.size() > index;
    }

    @Override
    public Student next() {
        return studentList.get(index++);
    }
}
