package ru.gb.studygroup.presenter;

import ru.gb.studygroup.model.service.Service;
import ru.gb.studygroup.view.View;

public class Presenter {

    private Service service;
    private View view;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addStudent(String name, int age) {
        service.addStudent(name, age);
        getStudentListInfo();
    }

    public void getStudentListInfo() {
        String answer = service.getListOfStudents();
        view.printAnswers(answer);
    }

    public void sortByName() {
        service.sortByName();
        getStudentListInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getStudentListInfo();
    }
}
