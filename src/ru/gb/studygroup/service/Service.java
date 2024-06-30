package ru.gb.studygroup.service;

import ru.gb.studygroup.builder.StudentBuilder;
import ru.gb.studygroup.student.Student;
import ru.gb.studygroup.studygroup.StudyGroup;

public class Service {

    private StudyGroup studyGroup;
    private StudentBuilder studentBuilder;

    public Service() {
        studyGroup = new StudyGroup();
        studentBuilder = new StudentBuilder();
    }

    public void addStudent(String name, int age) {
        Student student = studentBuilder.build(name, age);
        studyGroup.addStudent(student);
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
