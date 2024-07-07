package ru.gb.studygroup.student;

import ru.gb.studygroup.student.Student;
import ru.gb.studygroup.studygroup.StudyGroupItem;

import java.util.Comparator;

public class StudentComparatorByAge<T extends StudyGroupItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
        //return o1.getAge() - o2.getAge();
     }
}
