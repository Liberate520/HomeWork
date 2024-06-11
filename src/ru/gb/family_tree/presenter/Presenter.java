package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.humans.Human;
import ru.gb.family_tree.view.View;

public class Presenter {
    private View view;
    private Human human;
    //private Service service;
    public Presenter(View view) {
        this.view = view;
        //TODO редактировать Human
        human = new Human();
    }

    public void addHuman(String name, int age) {
        human.addHuman(name, age);
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String answer = human.getInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        human.
    }
}
