package ru.gb.studygroup.studygroup;

public interface StudyGroupItem<T> extends Comparable<T> {
    String getName();
    int getAge();
}
