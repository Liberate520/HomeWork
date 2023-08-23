package Model.FamilyTree.FamilyTree;

import Model.FamilyTree.Comparator.SortByAge;
import Model.FamilyTree.Comparator.SortByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends EntityItem<E>> implements Serializable, Iterable<E>, EntityTree<E> {
    private List<E> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }
    @Override
    public void addToList(E human) {
        familyTree.add(human);
    }

    public E findById(int id) {
        if (id <= familyTree.size()) {
            return familyTree.get(id - 1);
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyMemberIterator<>(familyTree);
    }

    @Override
    public void sortByName() {
        familyTree.sort(new SortByName<>());
    }

    @Override
    public void sortByAge() {
        familyTree.sort(new SortByAge<>());
    }

    @Override
    public void makeMarriage(E spouseOne, E spouseTwo) {
        spouseOne.setSpouse(spouseTwo);
        spouseTwo.setSpouse(spouseOne);
    }

    @Override
    public int getSize() {
        return familyTree.size();
    }

    @Override
    public String getInfoFamilyTree() {
        if (familyTree.size() == 0) {
            return null;
        } else {
            StringBuilder info = new StringBuilder();
            for (int i = 0; i < familyTree.size(); i++) {
                String st = "id: %s, %s".formatted(Integer.toString(i + 1),
                        familyTree.get(i).getInfo());
                info.append(st);
                int length = familyTree.get(i).getInfo().length();
                info.append("\n");
                String str = "";
                for (int j = 0; j < length; j++) {
                    str += "-";
                }
                info.append(str);
                info.append("\n");
            }
            return info.toString();
        }
    }
}