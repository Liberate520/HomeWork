package my_fam_tree.service;

import my_fam_tree.model.Human;
import my_fam_tree.model.FamTreeOper;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FamTreeSer {
    private FamTreeOper<Human> familyTree;
    private HumanFact humanFact;

    public FamTreeSer(FamTreeOper<Human> familyTree, HumanFact humanFact) {
        this.familyTree = familyTree;
        this.humanFact = humanFact;
    }

    public void addHuman(String name, String gender, String birthDateInput) {
        Human human = humanFact.createHuman(name, gender, birthDateInput);
        familyTree.addRelative(human);
    }

    public Human findHuman(String name) {
        return familyTree.findHuman(name);
    }

    public List<Human> getRelatives() {
        return familyTree.getRelatives();
    }

    public void sortName() {
        familyTree.sortName();
    }

    public void sortBirthDate() {
        familyTree.sortBirthDate();
    }

    public void addParentChild(String parentName, String childName) {
        Human parent = familyTree.findHuman(parentName);
        Human child = familyTree.findHuman(childName);
        if (parent != null && child != null) {
            parent.addChild(child);
            if (parent.getGender().equals("Мужской")) {
                child.setFather(parent);
            } else {
                child.setMother(parent);
            }
        }
    }

    public List<Human> getChildren(String name) {
        Human human = familyTree.findHuman(name);
        return human != null ? human.getChildren() : null;
    }

    public Human[] getParents(String name) {
        Human human = familyTree.findHuman(name);
        if (human != null) {
            return new Human[]{human.getFather(), human.getMother()};
        }
        return null;
    }

    public List<Human> getSiblings(String name) {
        Human human = familyTree.findHuman(name);
        if (human != null) {
            Human father = human.getFather();
            Human mother = human.getMother();
            if (father != null) {
                return father.getChildren().stream()
                        .filter(child -> !child.equals(human))
                        .collect(Collectors.toList());
            } else if (mother != null) {
                return mother.getChildren().stream()
                        .filter(child -> !child.equals(human))
                        .collect(Collectors.toList());
            }
        }
        return null;
    }

    public List<Human> getAncestors(String name) {
        Human human = familyTree.findHuman(name);
        List<Human> ancestors = new ArrayList<>();
        if (human != null) {
            addAncestors(human, ancestors);
        }
        return ancestors;
    }

    private void addAncestors(Human human, List<Human> ancestors) {
        if (human.getFather() != null) {
            ancestors.add(human.getFather());
            addAncestors(human.getFather(), ancestors);
        }
        if (human.getMother() != null) {
            ancestors.add(human.getMother());
            addAncestors(human.getMother(), ancestors);
        }
    }

    public List<Human> getDescendants(String name) {
        Human human = familyTree.findHuman(name);
        List<Human> descendants = new ArrayList<>();
        if (human != null) {
            addDescendants(human, descendants);
        }
        return descendants;
    }

    private void addDescendants(Human human, List<Human> descendants) {
        for (Human child : human.getChildren()) {
            descendants.add(child);
            addDescendants(child, descendants);
        }
    }

    public int getGenerationCount() {
        int maxGeneration = 0;
        for (Human human : familyTree.getRelatives()) {
            int generation = getHumanGeneration(human);
            if (generation > maxGeneration) {
                maxGeneration = generation;
            }
        }
        return maxGeneration;
    }

    private int getHumanGeneration(Human human) {
        int generation = 0;
        Human current = human;
        while (current.getFather() != null || current.getMother() != null) {
            generation++;
            current = current.getFather() != null ? current.getFather() : current.getMother();
        }
        return generation;
    }

    public FamTreeOper<Human> getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(FamTreeOper<Human> familyTree) {
        this.familyTree = familyTree;
    }
}
