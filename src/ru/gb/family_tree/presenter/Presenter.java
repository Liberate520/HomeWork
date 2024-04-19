package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.SpouseStatus;
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


    public boolean setParent(int memberId, int parentId){
        if (service.checkById(memberId) & service.checkById(parentId)){
            service.setParent(memberId,parentId);
            return true;
        }
        return false;
    }


    public boolean setSpouse(int firstMemberId, int secondMemberId, SpouseStatus spouseStatus) {
        if (service.checkById(firstMemberId) & service.checkById(secondMemberId)) {
            service.setSpouse(firstMemberId, secondMemberId, spouseStatus);
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
