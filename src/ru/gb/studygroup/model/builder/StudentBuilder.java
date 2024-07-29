package ru.gb.studygroup.model.builder;

import ru.gb.studygroup.model.student.Student;

public class StudentBuilder {

    private long genId;

    public Student build(String name, int age) {
        return new Student(genId++, name, age);
    }
}
