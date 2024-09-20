import java.io.Serializable;
import java.lang.foreign.SegmentAllocator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    static long treeId = 0;
    private List<Human> familyTree;

    public FamilyTree() {
        this(new ArrayList<Human>());
    }

    public FamilyTree(ArrayList<Human> humans) {
        this.familyTree = humans;
    }

    public boolean addHuman(Human human) {
        boolean res = false;
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            treeId += 1;
            human.setId(treeId);
            addToFamily(human);
            res = true;
        }
        return res;
    }

    private void addToFamily(Human human) {
        if (human.getMother() != null)
            human.getMother().addChildren(human);
        if (human.getFather() != null)
            human.getFather().addChildren(human);
        for (Human child : human.getChildren()) {
            child.setParent(human);
        }
    }

    public boolean setWedding(Human human1, Human human2) {
        boolean res = false;
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            res = true;
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : familyTree) {
            stringBuilder.append(human.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String findByName(String name) {
        StringBuilder humanToFind = new StringBuilder();
//        String humanToFind = "no data found";
        for (Human human : familyTree) {
            if (human.getName().equalsIgnoreCase(name)) {
                humanToFind.append(human.toString());
            }
            if (human.getFirstName().equalsIgnoreCase(name)) {
                humanToFind.append(human.toString());
            }
            else if (human.getSecondName().equalsIgnoreCase(name)) {
                humanToFind.append(human.toString());
            } else humanToFind.append("no data found");
        }
        return humanToFind.toString();
    }

    public String findByBirthDate(LocalDate birthDate) {
        String humanToFind = "no data found";
        for (Human human : familyTree) {
            if (human.getBirthDate().equals(birthDate)) {
                humanToFind = human.toString();
            }
        }
        return humanToFind;
    }
}
