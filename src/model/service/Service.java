package model.service;

import model.builder.HumanBuilder;
import model.family.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writer.DataHandler;
import model.writer.Writer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Service implements Serializable {
    private FamilyTree<Human> tree;
    private HumanBuilder builder;
    private Writer<FamilyTree<Human>> dataHandler;

    public Service() {
        tree = new FamilyTree<>();
        builder = new HumanBuilder();
        dataHandler = new DataHandler<>();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate){
        Human human = builder.build(name, gender, birthDate);
        tree.addHuman(human);
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, String motherName, String fatherName){
        Human father = tree.getByName(fatherName);
        Human mother = tree.getByName(motherName);
        Human human = builder.build(name, gender, birthDate, mother, father);
        tree.addHuman(human);
    }

    public List<Human> getPeople(){
        return tree.getPeople();
    }

    public String getPeopleInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");

        for (Human human : tree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    public void setWedding(String human1, String human2){
        tree.setWedding(tree.getByName(human1), tree.getByName(human2));
    }

    public void setFilePath(String filePath) {
        dataHandler.setPath(filePath);
    }

    public void save(){
        dataHandler.save(tree);
    }

    public FamilyTree<Human> load() {
        tree = dataHandler.read();
        return tree;
    }

    @Override
    public String toString() {
        return getPeopleInfo();
    }
}
