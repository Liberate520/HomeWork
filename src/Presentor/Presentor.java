package Presentor;

import Model.Organisms.Mammals.Persons.Enums.Gender;
import Model.Service;
import View.View;

import java.time.LocalDate;

public class Presentor {
    private Service service;
    private View view;

    public Presentor(View view) {
        this.view = view;
        service = new Service();
    }

    public void addPerson(String  name, Gender gender) {
        service.addPerson(name, gender);
    }

    public void addParent(int index, int indexParent) {
        service.addParent(index, indexParent);
    }

    public void addChield(int index, int indexChield) {
        service.addChield(index, indexChield);
    }

    public void addBirthday(LocalDate birthday, int index) {
        service.addBirthday(birthday, index);
    }

    public void addDeathDate(LocalDate deathDate, int index) {
        service.addDeathDate(deathDate, index);
    }

    public void sortByBirthday() {
        service.sortByBirthday();
    }
    public void sortedByName() {
        service.sortedByName();
    }

    public void getPersonOnSurname(String name) {
        service.getPersonOnSurname(name);
    }

    public void getFullPerson(int index) {
        service.getFullPerson(index);
    }
    public void getAllFamily() {
        service.getAllFamily();
    }
    public void getAllIndices() {
        service.getAllIndices();
    }
    public void save() {
        service.save();
    }
    public void load() {
        service.load();
    }
}
