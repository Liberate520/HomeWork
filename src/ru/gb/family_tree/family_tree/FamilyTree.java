package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.service.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeItem<T>> implements Serializable, Iterable<T> {
    private int humansId;
    private List<T> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public boolean addHuman(T human){
        if (human == null) {
            return false;
        }
        if (!humans.contains(human)) {
            humans.add(human);
            human.setId(++humansId);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(T human) {
        for (T parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(T human) {
        for (T child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<T> getSiblings(int id) {
        List<T> result = new ArrayList<>();
        T human = getById(id);
        if (human == null) {
            return null;
        }
        for (T parent : human.getParents()) {
            for (T child : parent.getChildren()) {
                if (!child.equals(human)) {
                    result.add(child);
                }
            }
        }
        return result;
    }

    public List<T> getByName(String name) {
        List<T> result = new ArrayList<>();
        for (T human : humans) {
            if (human.getName().equals(name)) {
                result.add(human);
            }
        }
        return result;
    }

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding (T human1, T human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    private boolean setDivorce(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce (T human1, T human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(long humansId) {
        if (checkId(humansId)) {
            T human = getById(humansId);
            return humans.remove(human);
        }
        return false;
    }

    private boolean checkId(long id) {
        return  id < humansId && id >= 0;
    }

    public T getById(long id) {
        for (T human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder result = new StringBuilder();
        for (T human : humans) {
            result.append(human).append("\n");
        }
        return result.toString();
    }

    public String getHumansChildrenInfo(int selectId) {
        StringBuilder result = new StringBuilder();
        result.append("Список детей для ");
        //        .append(humans.get(selectId-1).getName()).append(":\n");

        for(T human : humans) {
            if (human.getId() == selectId) {
                result.append(human.getName()).append(":\n");
                result.append(human.getChildrenInfo());
            }
        }

        /*
        for(T human : humans) {
            if (human.getFather() != null) {
                if (human.getFather().getId() == selectId) {
                    result.append(human.getName()).append("\n");
                }
            }
        }

        for(T human : humans) {
            if (human.getMother() != null) {
                if (human.getMother().getId() == selectId) {
                    result.append(human.getName()).append("\n");
                }
            }
        }

         */
        return result.toString();
    }

    public void sortById () {
        humans.sort(new HumanComparatorById<>());
    }

    public void sortByName () {
        humans.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        humans.sort(new HumanComparatorByAge<>());
    }

    public void sortByBirthDay() {
        humans.sort(new HumanComparatorByBirthDay<>());
    }

    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(humans);
    }
}
