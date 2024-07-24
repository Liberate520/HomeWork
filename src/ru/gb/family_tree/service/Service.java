package ru.gb.family_tree.service;

import ru.gb.family_tree.human.builder.HumanBuilder;
import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.enums.Gender;
import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Service implements Serializable {
    private HumanBuilder humanBuilder;
    private FamilyTree<Human> famTree;

    public Service() {
        famTree = new FamilyTree();
        humanBuilder = new HumanBuilder();
    }

    public void addHuman(String name, String patronymic, String surname,
                         Gender gender, Human father, Human mother,
                         List<Human> children, String profession,
                         String nationality, LocalDate dateOfBirth, LocalDate dateOfDeath,
                         String birthPlace, String notes){
        Human human = humanBuilder.build(name, patronymic, surname,
                gender, father, mother,
                children, profession,
                nationality, dateOfBirth, dateOfDeath,
                birthPlace, notes);
        famTree.addHuman(human);
    }

    public void addHuman(String name, String patronymic, String surname,
                         Gender gender){
        Human human = humanBuilder.build(name, patronymic, surname, gender);
        famTree.addHuman(human);
    }

    public void setFamilyTies(){
        famTree.setParentsByChildren();
        famTree.setChildrenByParents();
    }

    public String getfamilyTreeInfo(){
        return famTree.toString();
    }

    public Human getHumanById(int id){
        return (Human)famTree.getHumanById(id);
    }

    public List<Human> searchHuman(String request){
        return (List<Human>) famTree.searchHuman(request);
    }

    public void sortByName(){
        famTree.sortByName();
    }

    public void sortByAge(){
        famTree.sortByAge();
    }

    public void sortByBirthday(){
        famTree.sortByBirthday();
    }

    public void sortById(){
        famTree.sortById();
    }


}
