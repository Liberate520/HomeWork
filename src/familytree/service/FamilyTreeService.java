package familytree.service;

import familytree.model.human.Human;
import familytree.model.human.Gender;
import familytree.model.family_tree.FamilyTree;
import familytree.model.util.FileHandler;
import familytree.model.human.HumanAgeComparator;
import familytree.model.human.HumanNameComparator;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class FamilyTreeService {
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;

    public FamilyTreeService() {
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FileHandler();
    }

    public void createFamilyTree() {
        Human grandparent = new Human("Prohor", Gender.Male, LocalDate.of(1949, 5, 21));
        Human parent1 = new Human("Alice", Gender.Female, LocalDate.of(1973, 8, 15));
        Human parent2 = new Human("Ignat", Gender.Male, LocalDate.of(1975, 1, 22));
        Human child1 = new Human("Alla", Gender.Female, LocalDate.of(2003, 11, 10));
        Human child2 = new Human("Diana", Gender.Female, LocalDate.of(2005, 6, 4));

        grandparent.addChild(parent1);
        grandparent.addChild(parent2);
        parent1.addChild(child1);
        parent2.addChild(child2);

        parent1.addParent(grandparent);
        parent2.addParent(grandparent);
        child1.addParent(parent1);
        child2.addParent(parent2);

        familyTree.addHuman(grandparent);
        familyTree.addHuman(parent1);
        familyTree.addHuman(parent2);
        familyTree.addHuman(child1);
        familyTree.addHuman(child2);
    }

    public void addHuman(String name, String gender, String birthDateStr, String deathDateStr) {
        LocalDate birthDate = LocalDate.parse(birthDateStr);
        LocalDate deathDate; 
        if (deathDateStr.isEmpty()){
            deathDate = null; 
        } else {
            deathDate = LocalDate.parse(deathDateStr);
        }
                   
        Gender gen = Gender.valueOf(gender);  
                              
        Human newHuman = new Human(name, gen, birthDate, deathDate);
        familyTree.addHuman(newHuman);
    }

    public String displayFamilyTree() {
        return familyTree.toString();
    }

    public void sortByName() {
        List<Human> humans = familyTree.getAllHumans();
        humans.sort(new HumanNameComparator<>());
    }

    public void sortByAge() {
        List<Human> humans = familyTree.getAllHumans();
        humans.sort(new HumanAgeComparator<>());
    }

    public void saveFamilyTree() {
        //fileHandler.setPath(filePath);
        fileHandler.writeToFile(familyTree);
    }
  @SuppressWarnings("unchecked")
    public void loadFamilyTree() {
       // fileHandler.setPath(filePath);
        FamilyTree<Human> loadedTree = (FamilyTree<Human>) fileHandler.readFromFile();
        if (loadedTree != null) {
            this.familyTree = loadedTree;
        }
    }

    public List<Human> getChildrenOf(String name) {
        return familyTree.getChildrenOf(name);
    }

    public List<Human> getParentsOf(String name) {
        return familyTree.getParentsOf(name);
    }

    public void addParentToChild(String childName, String parentName) {
        Human child = familyTree.findHuman(childName);
        Human parent = familyTree.findHuman(parentName);

        if (child != null && parent != null) {
            child.addParent(parent);
            parent.addChild(child);
        } else {
            throw new IllegalArgumentException("Child or Parent not found.");
        }
    }

    public void addChildToParent(String parentName, String childName) {
        addParentToChild(childName, parentName);
    }
}
