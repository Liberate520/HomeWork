package family_tree;
import human.Human;
import human.PersonComparators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>  {
    public List<Human> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addHuman(Human human) {
        this.familyTree.add(human);
    }

    public String findHuman(String name) {
        String result = "";
        for (int i = 0; i < this.familyTree.size(); i++) {
            if (this.familyTree.get(i).getName().equals(name)) {
                result += familyTree.get(i).toString();
            } else {
                result += String.format("Имя %s не найдено!", name);
            }
        }
        return result;
    }
    public void sortByName() {
        Collections.sort(familyTree, PersonComparators.compareByName);
    }

    public void sortByAge() {
        Collections.sort(familyTree, PersonComparators.compareByAge);
    }
    @Override
    public Iterator<Human> iterator() {
        return familyTree.iterator();
        }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Human human : this.familyTree) {
            result.append(human.toString());
            result.append("\n");
        }
        return result.toString();
    }
}