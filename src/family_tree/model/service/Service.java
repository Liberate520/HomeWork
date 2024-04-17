package family_tree.model.service;

import family_tree.model.human.Human;
import family_tree.model.writer.FileHandler;
import family_tree.model.human.Gender;
import family_tree.model.family_tree.FamilyTree;

import java.time.LocalDate;

public class Service {

    private FamilyTree<Human> tree;
    private FileHandler fileHandler;

    public Service(FamilyTree<Human> tree) {
        this.tree = tree;
        this.fileHandler = new FileHandler();
    }

    public void createAndAddHuman(String name, Gender gender, LocalDate dob) {
        Human human = new Human(name, gender, dob);
        tree.add(human);
    }

    public void createAndAddHuman(String name, Gender gender, LocalDate dob, Human mother, Human father) {
        Human human = new Human(name, gender, dob, mother, father);
        tree.add(human);
    }

    public void setWedding(Human partner1, Human partner2) {
        tree.setWedding(partner1, partner2);
    }

    public void setDivorce(Human partner1, Human partner2) {
        tree.setDivorce(partner1, partner2);
    }

    public void addChildToParents(Human child, Human mother, Human father) {
        child.setMother(mother);
        child.setFather(father);
        
        mother.addChild(child);
        father.addChild(child);
    }

    public void addParentToChild(Human parent, Human child) {
        child.addParent(parent);
    }

    public FamilyTree<Human> getFamilyTree() {
        return tree;
    }

    public void sortByName() {
        tree.sortName();
    }

    public void sortByAge() {
        tree.sortBirthday();
    }

    public boolean saveFamilyTreeToFile(String filePath) {
        return fileHandler.save(tree, filePath);
    }
    
    public FamilyTree<Human> readFamilyTreeFromFile(String filePath) {
        return fileHandler.read(filePath);
    }
    
    public void setFamilyTree(FamilyTree<Human> tree) {
        this.tree=tree;
    }

    public void createRelationships(Human husband, Human wife, Human... children) {
        setWedding(husband, wife);
        for (Human child : children) {
            addChildToParents(child, wife, husband);
        }
    }

}