

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class FamilyTree implements Iterable<Human>{
    private List<Human> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean addHuman(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child: human.getChildren()) {
            child.addParent(human);
        }
    }

    public Human getHumanByName(String name) {
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public List<Human> getChildrenOf(Human human) {
        return human.getChildren();
    }

    public void setPeople(List<Human> peopleFromFile) {
        this.humanList = peopleFromFile;
    }

    public List<Human> getPeople() {
        return humanList;
    }

    public void sortByName() {
        Collections.sort(humanList, (h1, h2) -> h1.getName().compareTo(h2.getName()));
        printHuman();
    }

    public void sortByBirthDate() {
        Collections.sort(humanList, (h1, h2) -> h1.getBirthDate().compareTo(h2.getBirthDate()));
        printHuman();
    }

    public void printHuman() {
        for (Human human : this) {
            System.out.println(human);
        }
    }

    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }
}