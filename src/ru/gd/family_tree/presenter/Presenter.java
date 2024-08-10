package ru.gd.family_tree.presenter;

import ru.gd.family_tree.model.service.Service;
import ru.gd.family_tree.model.family_tree.FamilyTree;
import ru.gd.family_tree.model.gender.Gender;
import ru.gd.family_tree.model.human.Human;
import ru.gd.family_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service=new Service();
    }
    public void addHuman(String name, LocalDate birghDate, LocalDate deathDate, Gender gender){
        service.addHuman(name,birghDate,deathDate,gender);
    }
    public void addHuman(String name, LocalDate birghDate, Gender gender) {
        service.addHuman(name,birghDate,gender);
    }
    public FamilyTree<Human> getFamilyTree(){
        return service.getFamilyTree();
    }

    public List<Human> getByName(String name){   //вернуть по имени
        return service.getByName(name);
    }
    public Human getById(int id){   // вернуть по id
        return service.getById(id);
    }
    public void addChild(Human human,Human child) {  //добавить ребёнка

        service.addChild(human, child);
    }
    public void addMother(Human human,Human mother) {  //добавить мать
        service.addMother(human,mother);
    }
    public void addFather(Human human,Human father) {   //добавить отца
        service.addFather(human,father);
    }
    public void addSpouse(Human human,Human spouse) {   //добавить супруга,супругу
        service.addSpouse(human,spouse);
    }
    public  List<Human> getSiblings(int id) {   //найти братьев и сестёр
        return service.getSiblings(id);
    }
    public void getAge(Human human) {   //возвращает возраст либо годы жизни
        view.printAnswer(service.getAge(human));
    }
    public void printNameFamiliTree(){
        service.printNameFamiliTree();
    }
    public void sortByName(){
        service.sortByName();
    }
    public void sortByData(){
        service.sortByData();
    }
    public void saveFamilyTree(String file) throws IOException {service.saveFamilyTree(file);}
    public void readFamilyTree(String file) throws IOException, ClassNotFoundException {service.readFamilyTree(file);}
}
