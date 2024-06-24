package PresenterF;

import Model.Human.Gender;
import Model.Human.Human;
import Model.Service.Service;
import View.IView;

import java.io.IOException;
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

    public String printFamilyTree(){
        return service.printFamilyTree();
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

    public int getFamilyTreeSize(){
        return service.getFamilyTreeSize();
    }

    public Human getCreatureById(String id){
        return service.getCreatureById(id);
    }

    public void addMother(Human child, Human mother){
        service.addMother(child, mother);
    }

    public void addFather(Human child, Human father){
        service.addFather(child, father);
    }

    public void removeMother(Human child) {
        service.removeMother(child);
    }

    public void removeFather(Human child) {
        service.removeFather(child);
    }

    public void addChild(Human parent, Human child) {
        service.addChild(parent, child);
    }

    public void removeChild(Human parent, Human child) {
        service.removeChild(parent,child);
    }

    public void setSpouse(Human human1, Human human2) {
        service.setSpouse(human1, human2);
    }

    public void setDivorce(Human human) {
        service.setDivorce(human);
    }

    public void writeObjectToFile() throws IOException {
        service.writeObjectToFile();
    }

    public void recoverObjectFromFile() throws IOException, ClassNotFoundException{
        service.recoverObjectFromFile();
    }


}