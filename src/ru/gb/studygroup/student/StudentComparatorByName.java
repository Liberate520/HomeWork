package ru.gb.studygroup.student;

import ru.gb.studygroup.student.Student;
import ru.gb.studygroup.studygroup.StudyGroupItem;

import java.util.Comparator;

public class StudentComparatorByName<T extends StudyGroupItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
