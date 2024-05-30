package ru.gb.family_tree.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.HumanIterator;
import ru.gb.family_tree.tree.comparators.HumanComparatorByAge;
import ru.gb.family_tree.tree.comparators.HumanComparatorByName;
import ru.gb.family_tree.tree.comparators.HumanComparatorBySpouse;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long humansID;
    private List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) { // Не очень удачное решение, потому что id присваивается ниже
            humanList.add(human);
            human.setId(humansID++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getParents()) {
            child.addChild(human);
        }
    }

    public List<Human> getSiblings(long id) { // Поиск братьев и сестёр...
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent : human.getParents()) {
            for (Human child : human.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            res.add(human);
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean setDivorce(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            if (human1.getSpouse() != null && human2.getSpouse() != null) {
                human1.setSpouse(null);
                human2.setSpouse(null);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remove(long humanId) {
        if (checkId(humanId)) {
            Human human = getById(humanId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < humansID && id >= 0;
    }

    public Human getById(long id) {
        for (Human human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном древе ");
        sb.append(humanList.size());
        sb.append(" объектов: \n\n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }  

    public void sortBySpouse(){
        humanList.sort(new HumanComparatorBySpouse());

        // System.out.println("ПРОВЕРКА СОРТИРОВКИ ПО СМЕЙНОМУ ПОЛОЖЕНИЮ\n");
        // toString();

    }       

}
