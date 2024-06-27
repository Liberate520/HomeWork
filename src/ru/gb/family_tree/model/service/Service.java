package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.FT.*;
import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.model.Human.Human;
import ru.gb.family_tree.model.builder.HumanBuilder;

import java.time.LocalDate;

public class Service<T extends Human> {
    private FamilyTree<Human> familyTree;
    private HumanBuilder humanBuilder;

    public Service() {
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
    }

    public void addHuman(String lastName, String name, Gender gender, LocalDate birthDate){
        Human human = humanBuilder.build(lastName, name, gender, birthDate);
        familyTree.addHuman(human);
    }


    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByBirthDate(){
        familyTree.sortByBirthDate();
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }


}
