package ru.gb.studygroup.model.studygroup;

public interface StudyGroupItem<T> extends Comparable<T> {
    String getName();
    int getAge();
}
