package Presenter;

import Model.Рerson.Рerson;
import Model.Рerson.Gender;
import Model.Service;
import View.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }


    public void addРerson(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate) {
        service.addPerson(firstName, lastName, birthDate, deathDate);
    }

    public void getРersonList() {
        String answer = service.getInfo();
        view.print(answer);
    }

    public void sortByName(){
        service.sortByName();
    }

    public void sortByBirthday(){
        service.sortByBirthday();
    }
}