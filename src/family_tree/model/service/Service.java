package family_tree.model.service;

import family_tree.model.human.Human;
import family_tree.model.writer.Writable;
import family_tree.model.human.Gender;
import family_tree.model.family_tree.FamilyTree;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Service {

    private FamilyTree<Human> tree;
    private Writable<?> fileHandler;

    public Service(Writable<?> fileHandler) {
        this.tree = new FamilyTree<>();
        this.fileHandler = fileHandler;
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

    @SuppressWarnings("unchecked")
    public boolean saveFamilyTreeToFile() {
        return ((Writable<FamilyTree<Human>>)fileHandler).save(tree);
    }
    
    @SuppressWarnings("unchecked")
    public void readFamilyTreeFromFile() {
        Object object = fileHandler.read();
        if (object instanceof FamilyTree) {
            tree = (FamilyTree<Human>) object;
        }
    }
    
    public void setFamilyTree(FamilyTree<Human> tree) {
        this.tree=tree;
    }

    public void createRelationships(String husbandName, String wifeName, List<String> childrenNames) {
        Human husband = findHumanByName(husbandName);
        Human wife = findHumanByName(wifeName);
        if (husband == null || wife == null) {
            return;
        }
    
        List<Human> children = childrenNames.stream()
                                            .map(this::findHumanByName)
                                            .filter(Objects::nonNull)
                                            .collect(Collectors.toList());
    
        if (children.size() != childrenNames.size()) {
            return;
        }
    
        createRelationships(husband, wife, children.toArray(new Human[0]));
    }

    public void createRelationships(Human husband, Human wife, Human... children) {
        setWedding(husband, wife);
        for (Human child : children) {
            addChildToParents(child, wife, husband);
        }
    }

    public Human findHumanByName(String name) {
        for (Human human : tree) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    public String getFamilyTreeInfo() {
        return tree.getInfo();
    }

}