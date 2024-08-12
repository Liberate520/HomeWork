package homeWork.Tree;

import homeWork.Human.Comporators.ComparingByName;
import homeWork.Human.Comporators.ComparingByBirthday;
import homeWork.Human.Human;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> familyTree = new ArrayList<Human>();

    public void addHuman(Human human) {
        familyTree.add(human);
    }

    public String getFamilyTree() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");
        for (Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void removeHuman(Human human) {
        familyTree.remove(human);
    }

    public void setFamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTree);
    }

    public void sortByName() {
        familyTree.sort(new ComparingByName());
    }

    public void sortByAge() {
        familyTree.sort(new ComparingByBirthday());
    }
}