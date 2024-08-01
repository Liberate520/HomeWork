package family_tree;

import human.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyTree {
    private List<Human> familyTree = new ArrayList<>();

    @Override
    public String toString() {
        return printList(familyTree);
    }

    public void add(Human human) {
        familyTree.add(human);
    }

    public List<Human> getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public List<Human> findByName(String name) {
        return familyTree.stream()
                .filter(h -> h.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public String printList(List<Human> list) {
        return list.stream()
                .map(Human::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
