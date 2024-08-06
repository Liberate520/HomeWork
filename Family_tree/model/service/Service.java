package Family_tree.model.service;

import java.io.IOException;
import java.time.LocalDate;

import javax.print.DocFlavor.STRING;
import javax.sound.midi.Soundbank;

import Family_tree.model.builder.HumanBuilder;
import Family_tree.model.family_tree.FamilyTree;
import Family_tree.model.human.Gender;
import Family_tree.model.human.Human;
import Family_tree.writer.FileHandler;

public class Service {
    public FamilyTree<Human> tree;
    private HumanBuilder builder;
    private FileHandler fh;

    public Service() {
        tree = new FamilyTree<>();
        builder = new HumanBuilder();
    }

    public Human addToTree(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human spouse, Human father, Human mother){
        Human human = builder.build(name, gender, dateOfBirth, dateOfDeath, spouse, father, mother);
        tree.addHuman(human);
        return human;
    }

    public Human addToTree(String name, Gender gender, LocalDate dateOfBirth){
        Human human = builder.build(name, gender, dateOfBirth);
        tree.addHuman(human);
        return human;
    }

    public Human getById(int id){
        return tree.getById(id);
    }

    public int size(){
        return tree.size();
    }

    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family members list:\n");

        for (Human human: tree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void setFather(int chilId, int fatherId){
        tree.getById(chilId).addFather(getById(fatherId));;
    }

    public void setMother(int chilId, int motherId){
        tree.getById(chilId).addMother(getById(motherId));;
    }

    public void setChild(int parentId, int childId){
        tree.getById(parentId).addChild(getById(childId));;
    }

    @Override
    public String toString() {
        return getHumanListInfo();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    public void setSpouse(int husbandId, int wifeId) {
        // tree.getById(husbandId).setSpouse(getById(wifeId));
        // tree.getById(wifeId).setSpouse(getById(husbandId));
        tree.getById(husbandId).getMarried(getById(wifeId));;
    }

    // FILEHANDLER

    private String filePath = "src/Family_tree/writer/result.txt";
    
    public void save(String path) {
        fh.save(tree);
    }

    public Object read() {
        return fh.read();
    }

    public void setPath(String filePath){
        this.filePath = filePath;
    }
}


