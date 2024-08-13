package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String firstName, String lastName, LocalDate dateOfBirth, Gender gender, int idMom, int idDad) {


        service.addHuman(lastName, firstName,  dateOfBirth, gender, idMom, idDad);
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        String answer = service.getFamilyTreeInfo();
        view.printAnswer(answer);
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void sortByFirstName() {
        service.sortByFirstName();
        getFamilyTreeInfo();
    }


    public void setWedding(int idHuman1, int idHuman2){
        service.setWedding(idHuman1, idHuman2);
        getFamilyTreeInfo();
    }


}
