package PresenterF;

import Model.Human.Gender;
import Model.Human.Human;
import Model.Service.Service;
import View.IView;

import java.time.LocalDate;

public class Presenter {
    private IView view;
    private Service service;

    public Presenter(IView view){
        this.view = view;
        service = new Service();
    }

    public void addCreature(String name, LocalDate birthDate, LocalDate deathDate ,Gender gender){
        service.addHuman(name, birthDate, deathDate, gender);

    }
    public void addCreature(String name, LocalDate birthDate ,Gender gender){
        service.addHuman(name, birthDate, gender);

    }

    public void printFamilyTree(){
        System.out.println(service.printFamilyTree());
    }

    public void printMother(Human human){
        service.printMother(human);
    }

    public void printFather(Human human){
        service.printFather(human);
    }

    public void getInfo(Human human){
        service.getInfo(human);
    }

    public void printChildren(Human human){
        service.printChildren(human);
    }

    public void getSisters(Human human){
        service.printSisters(human);
    }

    public void getBrothers(Human human){
        service.printBrothers(human);
    }

    public void sortByName(){
        service.sortByName();
    }

    public void sortByAge(){
        service.sortByAge();
    }

    public void sortByCountOfChildren(){
        service.sortByCountOfChildren();
    }
}