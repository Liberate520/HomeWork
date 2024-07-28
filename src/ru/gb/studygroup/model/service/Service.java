package ru.gb.studygroup.model.service;

import ru.gb.studygroup.model.builder.StudentBuilder;
import ru.gb.studygroup.model.student.Student;
import ru.gb.studygroup.model.studygroup.StudyGroup;

public class Service {

    private StudyGroup<Student> studyGroup;
    private StudentBuilder studentBuilder;

    public Service() {
        studyGroup = new StudyGroup<>();
        studentBuilder = new StudentBuilder();
    }

    public void addStudent(String name, int age) {
        Student student = studentBuilder.build(name, age);
        studyGroup.add(student);
    }

    public String getListOfStudents() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список студентов:\n");

//        Iterator<Student> iterator = studyGroup.iterator(); //так работает цикл for
//        while (iterator.hasNext()){
//            Student student = iterator.next();
//            stringBuilder.append(student);
//            stringBuilder.append("\n");
//        }

        for (Student student : studyGroup) {
            stringBuilder.append(student);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        studyGroup.sortByName();
    }

    public void sortByAge() {
        studyGroup.sortByAge();
    }
}
