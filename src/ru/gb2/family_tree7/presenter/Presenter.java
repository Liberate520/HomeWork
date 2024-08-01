package ru.gb2.family_tree7.presenter;

import ru.gb2.family_tree7.model.service.Service;
import ru.gb2.family_tree7.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, int age) {
        service.addHuman(name, age);
        //какой-то ответ
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }
}