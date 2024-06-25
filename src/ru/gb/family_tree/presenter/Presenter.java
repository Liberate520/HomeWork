package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view=view;
        service = new Service();
    }


    public Human findHuman(String firstName){
        return service.findHuman(firstName);
    }

    public Human findEveryHuman(String firstName){
        return service.findEveryHuman(firstName);
    }

    public void addHumansInEveryHuman(Human... humans) {

        service.addHumansInEveryHuman(humans);
    }


    public void removeHumansFromEveryHuman (Human... humans) {
        service.removeHumansFromEveryHuman(humans);
    }

    public Human createHuman(String firstName, String lastName, LocalDate dob, LocalDate dod, Gender gender, Human father, Human mother, Human... children){
        return service.createElement(firstName, lastName, dob, dod, gender, father, mother, children);
    }
    public Human createHuman(String firstName, String lastName, LocalDate dob, LocalDate dod, Gender gender, Human father, Human mother){
        return service.createElement(firstName, lastName, dob, dod, gender, father, mother);
    }
    public Human createHuman(String firstName, String lastName, LocalDate dob, LocalDate dod, Gender gender){
        return service.createElement(firstName, lastName, dob, dod, gender);
    }
}
