package ru.gb.studygroup.model.student;

import ru.gb.studygroup.model.studygroup.StudyGroupItem;

import java.util.Comparator;

public class StudentComparatorByName<T extends StudyGroupItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
