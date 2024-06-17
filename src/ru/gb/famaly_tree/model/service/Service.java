package ru.gb.famaly_tree.model.service;

import ru.gb.famaly_tree.model.filehandler.FileHandler;
import ru.gb.famaly_tree.model.filehandler.Writable;
import ru.gb.famaly_tree.model.ft.Famaly_tree;
import ru.gb.famaly_tree.model.human.Gender;
import ru.gb.famaly_tree.model.human.Human;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Service {
    private Famaly_tree famalyTree;
    private Writable writable;
    private boolean isFirstHumanInFamalyTree = true;

    public Service(){
        famalyTree = new Famaly_tree<>();
        writable = new FileHandler();
    }

    public Human createHuman(String name,Gender gender, LocalDate birthDate, LocalDate deathDate){
        return new Human(name, gender, birthDate, deathDate);
    }

    public Human createHuman(String name,Gender gender, LocalDate birthDate, LocalDate deathDate,Human mother, Human father, List<Human> children){
        return new Human(name, gender, birthDate, deathDate, mother, father, children);
    }


    public boolean addPersonInFamalyTree(Human h1){
        if(isFirstHumanInFamalyTree) {
            famalyTree.addFounder(h1);
            isFirstHumanInFamalyTree = false;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFirstHumanInFamalyTreeM(){
        return isFirstHumanInFamalyTree;
    }

    public void addPersonInFamalyTree(Human h1, Human h2){
        famalyTree.addThisInThis(h1,h2);
    }

    public String outputHumanInfo(Human human){
        return human.ToString();
    }

    public void addCoupl(Human h1, Human h2){
        famalyTree.coupl(h1,h2);
    }

    public String outputFamalyTree(Human human){
        return famalyTree.printFamalyTree(human);
    }

    public String outputFamalyTree(){
        return famalyTree.printFamalyTree(famalyTree.GetFounder());
    }

    public String outputHumanList(){
        return famalyTree.humanListToString();
    }

    public String outputHumanListSortByAge(boolean b){
        return famalyTree.humanListToString(famalyTree.sortByAge(b));
    }

    public String outputHumanListSortByChildrenCount(boolean b){
        return famalyTree.humanListToString(famalyTree.sortByChildrenCount(b));
    }

    public String outputHumanListSortByName(boolean b){
        return famalyTree.humanListToString(famalyTree.sortByName(b));
    }

    public Human searchByName(String name){
        return famalyTree.searchByName(name);
    }
    public void save() throws IOException {
        writable.saved(famalyTree);
    }

    public void download() throws IOException, ClassNotFoundException {
        famalyTree = writable.download();
    }
}