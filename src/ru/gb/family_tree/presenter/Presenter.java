package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender genderStr, LocalDate birthDate) {
        service.addHuman(name, genderStr, birthDate);
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String answer = service.getHumanListInfo();
        view.printAnswer(answer);
    }
    public void sortByName() {
        service.sortByName();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
    }

    public void saveTree() throws IOException {
        service.saveTree();
    }

//    public void readTree() throws IOException, ClassNotFoundException {
//        service.readTree();
//    }

    public String findByName(String name) {
        return service.findByName(name);
    }

    public List<Long> foundHumansId(String name) {
        return service.foundHumansId(name);
    }

    public void removeHuman(int id) {
        service.removeHuman(id);
    }


}
