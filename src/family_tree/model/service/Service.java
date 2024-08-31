package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.human.HumanBuilder;
import family_tree.model.writer.FileHandler;
import family_tree.model.writer.FileManager;

import java.time.LocalDate;

public class Service {
    private int idHuman;
    private FamilyTree<Human> tree;
    private HumanBuilder humanBuilder;
    private FileManager fileManager;


    public Service(){
        tree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
        fileManager = new FileManager(new FileHandler());
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

    public boolean saveToFile(String file){
        return fileManager.saveToFile(file,getFamilyTree());
    }

    public boolean loadFromFile(String filePath){
       tree = fileManager.loadFromFile(filePath);
        if (tree.equals(null))
            return false;
        else
            return true;
    }
}
