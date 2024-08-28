package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.human.HumanBuilder;
import family_tree.model.writer.FileHandler;

import java.time.LocalDate;

public class Service {
    private int idHuman;
    private FamilyTree<Human> tree;
    private HumanBuilder humanBuilder;
    FileHandler fileHandler;

    public Service(){
        tree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
        fileHandler = new FileHandler();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate){
        Human human = humanBuilder.setName(name).setGender(gender).setBirthDate(birthDate).build();
        tree.add(human);
    }

    public boolean addChild(int idHuman, int idChild){
        tree.getById(idChild).addParent(tree.getById(idHuman));
        return tree.getById(idHuman).addChild(tree.getById(idChild));
    }

    public boolean addParent(int child, int parent){
        tree.getById(parent).addChild(tree.getById(child));
        return tree.getById(child).addParent(tree.getById(parent));
    }

    public FamilyTree<Human> getFamilyTree(){
        return tree;
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    public boolean saveToFile(String filename){
        fileHandler.setFile(filename);
        return fileHandler.save(tree);
    }

    public boolean loadFromFile(String filePath){
        fileHandler.setFile(filePath);
        tree = (FamilyTree<Human>) fileHandler.read();
        if (tree.equals(null))
            return false;
        else
            return true;
    }
}
