package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.builder.HumanBuilder;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.writer.FileHendler;
import ru.gb.family_tree.writer.Writer;

import java.io.IOException;
import java.time.LocalDate;

//функционал приложения
public class Service {
    private FamilyTree<Human> familyTree;
    private Writer fileHendler;
    private HumanBuilder humanBuilder;


    public Service() {
        familyTree = new FamilyTree();
        humanBuilder = new HumanBuilder();
        fileHendler = new FileHendler("human.out");
    }

    public void addHuman(String lastName, String firstName, LocalDate dateOfBirth, Gender gender){
Human human = humanBuilder.build(lastName,firstName, dateOfBirth,gender);
        familyTree.addHuman(human);
    }

    public void addHuman(String lastName, String firstName, LocalDate dateOfBirth, Gender gender,int idMother, int idFather){


        Human mother = familyTree.getById(idMother);
        Human father = familyTree.getById(idFather);
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

    public void setWedding(int idHuman1, int idHuman2){
        familyTree.setWedding(idHuman1,idHuman2);
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

    public void saveToFile() throws IOException {
       fileHendler.serializationToFile(familyTree);
    }

    public FamilyTree loadFromFile() throws IOException {
        return fileHendler.restoringFromFile();
    }


}
