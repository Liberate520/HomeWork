package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.HumanService;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private HumanService service;

    public Presenter(View view) {
        this.view = view;
        service = new HumanService();
    }

    public void addHuman(String name, LocalDate birthdate) {
        service.addHuman(name, birthdate);
        getHumanListInfo();
    }

    public void createDefaultFamilyTree() {
        service.createDefaultFamilyTree();
        getHumanListInfo();
    }

    public void save(){
        service.save();
    }

    public void read(){
        service.read();
        getHumanListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String answer = service.getHumanListInfo();
        view.printAnswer(answer);
    }
}
