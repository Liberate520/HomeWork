package ru.gb.studygroup.model.studygroup;

import ru.gb.studygroup.model.student.StudentComparatorByAge;
import ru.gb.studygroup.model.student.StudentComparatorByName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudyGroup<T extends StudyGroupItem<T>> implements Iterable<T> {

    private List<T> studentList;

    public List<T> getStudentList() {
        return studentList;
    }

    public StudyGroup() {
        studentList = new ArrayList<>();
    }

    public void add(T student) {
        studentList.add(student);
    }

    public void sortByName() {
        //Collections.sort(studentList, new StudentComparatorByName());
        studentList.sort(new StudentComparatorByName<>());
    }

    public void sortByAge() {
        //Collections.sort(studentList, new StudentComparatorByAge());
        studentList.sort(new StudentComparatorByAge<>());
    }

    @Override
    public Iterator<T> iterator() {
        //return studentList.iterator(); //простой вариант
        return new StudentIterator<>(studentList);
    }
}
