package Model.Service;

import Model.FamilyTree.FamilyTree;
import Model.Human.Gender;
import Model.Human.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private int idCreature;
    private FamilyTree<Human> tree;

    public Service(){
        tree = new FamilyTree<Human>();
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender){
        Human human = new Human(name, birthDate, gender);
        tree.addCreatureToFamilyTree(human);
    }

    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender){
        Human human = new Human(name, birthDate, deathDate, gender);
        tree.addCreatureToFamilyTree(human);
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    public void sortByCountOfChildren(){
        tree.sortByCountOfChildren();
    }

    public String printFamilyTree(){
        StringBuilder info = new StringBuilder();
        for (Human human : tree.getFamilyTree()){
            info.append(human.getInfo());
        }
        return info.toString();
    }

    public void printMother(Human human){
        System.out.println(human.getMother().getInfo());
    }

    public void printFather(Human human){
        System.out.println(human.getFather().getInfo());
    }

    public void getInfo(Human human){
        System.out.println(human.getInfo());
    }

    public void printChildren(Human human){
        for(Human child : human.getChildren()){
            child.getInfo();
        }
    }

    public void printSisters(Human human){
        for(Human sister: human.getSisters()){
            sister.getInfo();
        }
    }

    public void printBrothers(Human human){
        for(Human brother: human.getBrothers()){
            brother.getInfo();
        }
    }
}