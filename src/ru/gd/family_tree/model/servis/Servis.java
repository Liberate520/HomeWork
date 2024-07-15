package ru.gd.family_tree.model.servis;

import ru.gd.family_tree.model.handler.FileHandler;
import ru.gd.family_tree.model.handler.Writable;
import ru.gd.family_tree.model.human.HumanBuilder;
import ru.gd.family_tree.model.family_tree.FamilyTree;
import ru.gd.family_tree.model.gender.Gender;
import ru.gd.family_tree.model.human.Human;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Servis {
    private Human human;
    private FamilyTree<Human> familyTree;
    private HumanBuilder humanBuilder;
    private Writable writable;

    public Servis() {
        human=new Human();
        familyTree=new FamilyTree<Human>();
        humanBuilder=new HumanBuilder();
        writable=new FileHandler();
    }

    public void addHuman(String name, LocalDate birghDate, LocalDate deathDate, Gender gender){
        Human human1=humanBuilder.build(name,birghDate,deathDate,gender);
        familyTree.addHuman(human1);
    }
    public void addHuman(String name, LocalDate birghDate, Gender gender) {
        Human human1 = humanBuilder.build(name, birghDate, gender);
        familyTree.addHuman(human1);
    }
    public void addChild(Human human,Human child) {  //добавить ребёнка

        human.addChild(child);

    }
    public void addMother(Human human,Human mother) {  //добавить мать
        human.addMother(mother);
    }
    public void addFather(Human human,Human father) {   //добавить отца
        human.addFather(father);
    }
    public void addSpouse(Human human,Human spouse) {   //добавить супруга,супругу
        human.addSpouse(spouse);
    }
    public int getAge(Human human) {   //возвращает возраст либо годы жизни
       return human.getAge();
    }
    public Human getById(int id){   // вернуть по id
        return familyTree.getById(id);
    }
    public List<Human> getByName(String name){   //вернуть по имени
        return familyTree.getByName(name);
    }
    public  List<Human> getSiblings(int id) {   //найти братьев и сестёр
        return familyTree.getSiblings(id);
    }
    public FamilyTree<Human> getFamilyTree(){
        return familyTree;
    }
    public void printNameFamiliTree(){
        for (Human h:familyTree){
            System.out.println(h.getName());
        }
    }
    public void sortByName(){
        familyTree.sortByName();
    }
    public void sortByData(){
        familyTree.sortByData();
    }
    public void saveFamilyTree(String file) throws IOException {  // Сохранить в файл
        writable.save(getFamilyTree(),file);
    }
    public void readFamilyTree(String file) throws IOException, ClassNotFoundException {  //  Считать из файла
        Object familyTreeSave=writable.read(file);
        System.out.println(familyTreeSave);
    }
}
