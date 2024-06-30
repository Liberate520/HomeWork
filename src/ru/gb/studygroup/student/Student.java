package ru.gb.studygroup.student;

public class Student implements Comparable<Student> {

    private long id;
    private String name;
    private int age;

    public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Student: id: %s , имя: %s, возраст: %s", id, name, age);
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }
}
