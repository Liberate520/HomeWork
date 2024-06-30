package ru.gb.studygroup.builder;

import ru.gb.studygroup.student.Student;

public class StudentBuilder {

    private long genId;

    public Student build(String name, int age) {
        return new Student(genId++, name, age);
    }
}
