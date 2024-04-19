package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.service.Service;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;


public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }


    public boolean addMember(String name, Gender gender, String date) {
        service.addMember(name, gender, date);
        return true;
    }


    public boolean setDeathDate(int personId, LocalDate dod) {
        if (service.checkById(personId)) {
            service.setDeathDate(personId, dod);
            return true;
        }
        return false;
    }


    public boolean setMother(int personId, int motherId) {
        if (service.checkById(personId) & service.checkById(motherId)) {
            service.setMother(personId, motherId);
            return true;
        }
        return false;
    }


    public boolean setFather(int personId, int fatherId) {
        if (service.checkById(personId) & service.checkById(fatherId)) {
            service.setMother(personId, fatherId);
            return true;
        }
        return false;
    }


    public void getAboutFamily() {
        view.printAnswer(service.getAboutFamily());
    }


    public void sortTreeByAge() {
        view.printAnswer(service.sortTreeByAge());
    }


    public void sortTreeByName() {
        view.printAnswer(service.sortTreeByName());
    }


    public boolean read(String path) {
        return service.read(path);
    }


    public boolean write(String path) {
        return service.write(path);
    }
}


//----------------------------------------------------------
