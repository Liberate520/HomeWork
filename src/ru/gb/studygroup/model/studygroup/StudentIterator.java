package ru.gb.studygroup.model.studygroup;

import java.util.Iterator;
import java.util.List;

public class StudentIterator<T extends StudyGroupItem<T>> implements Iterator<T> {

    private int index;
    private List<T> studentList;

    public StudentIterator(List<T> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean hasNext() {
        return studentList.size() > index;
    }

    @Override
    public T next() {
        return studentList.get(index++);
    }
}
