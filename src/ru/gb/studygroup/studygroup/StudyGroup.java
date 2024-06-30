package ru.gb.studygroup.studygroup;

import ru.gb.studygroup.student.StudentComparatorByAge;
import ru.gb.studygroup.student.StudentComparatorByName;
import ru.gb.studygroup.student.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudyGroup implements Iterable<Student> {

    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }

    public StudyGroup() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void sortByName() {
        //Collections.sort(studentList, new StudentComparatorByName());
        studentList.sort(new StudentComparatorByName());
    }

    public void sortByAge() {
        //Collections.sort(studentList, new StudentComparatorByAge());
        studentList.sort(new StudentComparatorByAge());
    }

    @Override
    public Iterator<Student> iterator() {
        //return studentList.iterator(); //простой вариант
        return new StudentIterator(studentList);
    }
}
