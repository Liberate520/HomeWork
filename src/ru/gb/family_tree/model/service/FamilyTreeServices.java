package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.builder.HumanBuilder;
import ru.gb.family_tree.model.familyTree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.save.FileHandler;
import ru.gb.family_tree.model.save.Writer;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreeServices {
    private Writer writer;
    private FamilyTree<Human> activeTree;
    private HumanBuilder humanBuilder;


    public FamilyTreeServices(Writer writer){
        activeTree = new FamilyTree<>();
        this.writer = writer;
        humanBuilder = new HumanBuilder();
    }

    public boolean save(){
        if (writer == null){
            return false;
        }
        return writer.save(activeTree);
    }

    public boolean load(){
        if (writer == null){
            return false;
        }
        activeTree = (FamilyTree<Human>) writer.read();
        return true;
    }

    public Human addHuman(String name, Gender gender, LocalDate birthDate,
                          long idFather, long idMother){
        Human human = addHuman(name, gender, birthDate);
        setParentToChild(idFather, human.getId());
        setParentToChild(idMother, human.getId());
        return human;
    }

    public Human addHuman(String name, Gender gender, LocalDate birthDate){
        Human human = humanBuilder
                .build(name, gender, birthDate);
        activeTree.add(human);
        return human;
    }

    public boolean setParentToChild(long idParent, long idChild){
        Human child = activeTree.getById(idChild);
        Human parent = activeTree.getById(idParent);
        if (child != null && parent != null){
            child.setParent(parent);
            parent.addChild(child);
            return true;
        } else {
            return false;
        }
    }

    public List<Human> sortByName(){
        return activeTree.sortByName();
    }

    public List<Human> sortByBirthDate(){
        return activeTree.sortByBirthDate();
    }

    public String getHumanList() {
        return activeTree.getInfo();
    }

    public boolean setDeathDate(int idHuman, LocalDate deathDate) {
        Human human = activeTree.getById(idHuman);
        if (human != null){
            human.setDeathDate(deathDate);
            return true;
        }
        return false;
    }
}
