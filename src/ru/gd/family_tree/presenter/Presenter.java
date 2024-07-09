package ru.gd.family_tree.presenter;

import ru.gd.family_tree.model.servis.Servis;
import ru.gd.family_tree.model.family_tree.FamilyTree;
import ru.gd.family_tree.model.gender.Gender;
import ru.gd.family_tree.model.human.Human;
import ru.gd.family_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Servis servis;

    public Presenter(View view) {
        this.view = view;
        servis=new Servis();
    }
    public void addHuman(String name, LocalDate birghDate, LocalDate deathDate, Gender gender){
        servis.addHuman(name,birghDate,deathDate,gender);
    }
    public void addHuman(String name, LocalDate birghDate, Gender gender) {
        servis.addHuman(name,birghDate,gender);
    }
    public FamilyTree<Human> getFamilyTree(){
        return servis.getFamilyTree();
    }

    public List<Human> getByName(String name){   //вернуть по имени
        return servis.getByName(name);
    }
    public Human getById(int id){   // вернуть по id
        return servis.getById(id);
    }
    public void addChild(Human human,Human child) {  //добавить ребёнка

        servis.addChild(human, child);
    }
    public void addMother(Human human,Human mother) {  //добавить мать
        servis.addMother(human,mother);
    }
    public void addFather(Human human,Human father) {   //добавить отца
        servis.addFather(human,father);
    }
    public void addSpouse(Human human,Human spouse) {   //добавить супруга,супругу
        servis.addSpouse(human,spouse);
    }
    public  List<Human> getSiblings(int id) {   //найти братьев и сестёр
        return servis.getSiblings(id);
    }
    public void getAge(Human human) {   //возвращает возраст либо годы жизни
        view.printAnswer(servis.getAge(human));
    }
    public void printNameFamiliTree(){
        servis.printNameFamiliTree();
    }
    public void sortByName(){
        servis.sortByName();
    }
    public void sortByData(){
        servis.sortByData();
    }
    public void saveFamilyTree(String file) throws IOException {servis.saveFamilyTree(file);}
    public void readFamilyTree(String file) throws IOException, ClassNotFoundException {servis.readFamilyTree(file);}
}
