package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.builder.HumanBuilder;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.writer.FileHendler;

import java.time.LocalDate;

//функционал приложения
public class Service {
    private FamilyTree<Human> familyTree;
    private FileHendler fileHendler;
    private HumanBuilder humanBuilder;


    public Service() {
        familyTree = new FamilyTree();
        humanBuilder = new HumanBuilder();
        fileHendler = new FileHendler();
    }

    public void addHuman(String lastName, String firstName, LocalDate dateOfBirth, Gender gender){
Human human = humanBuilder.build(lastName,firstName, dateOfBirth,gender);
        familyTree.addHuman(human);
    }

    public void addHuman(String lastName, String firstName, LocalDate dateOfBirth, Gender gender,Human mother, Human father){
        Human human = humanBuilder.build(lastName,firstName, dateOfBirth,gender, mother, father);
        familyTree.addHuman(human);
    }

    public void sortByFirstName() {
        familyTree.sortByFirstName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByLastName() {
        familyTree.sortByLastName();
    }

    public String getFamilyTreeInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей в семейном древе: \n");
        for (Human human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }


}
