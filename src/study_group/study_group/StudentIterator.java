package study_group.study_group;

import study_group.student.Student;

import java.util.Iterator;
import java.util.List;

class StudentIterator<E extends ItemStudyGroup> implements Iterator<E> {
    private int currentId;
    private List<E> students;

    public StudentIterator( List<E> students) {
        this.students = students;
    }

    @Override
    public boolean hasNext() {
        return students.size() > currentId;
    }

    @Override
    public E next() {
        return students.get(currentId++);
    }
}
