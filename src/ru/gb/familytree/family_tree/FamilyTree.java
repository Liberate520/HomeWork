package ru.gb.familytree.family_tree;

import ru.gb.familytree.human.Human;
import ru.gb.familytree.service.ComparatorByAge;
import ru.gb.familytree.service.ComparatorByName;
import ru.gb.familytree.service.ComparatorByBirthDay;
import ru.gb.familytree.service.FamilyTreeIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private int humansId;
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public boolean addHuman(Human human){
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

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<Human> getSiblings(int id) {
        List<Human> result = new ArrayList<>();
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        for (Human parent : human.getParents()) {
            for (Human child : parent.getChildren()) {
                if (!child.equals(human)) {
                    result.add(child);
                }
            }
        }
        return result;
    }

    public List<Human> getByName(String name) {
        List<Human> result = new ArrayList<>();
        for (Human human : humans) {
            if (human.getName().equals(name)) {
                result.add(human);
            }
        }
        return result;
    }

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding (Human human1, Human human2) {
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
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce (Human human1, Human human2) {
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
            Human human = getById(humansId);
            return humans.remove(human);
        }
        return false;
    }

    private boolean checkId(long id) {
        return  id < humansId && id >= 0;
    }

    public Human getById(long id) {
        for (Human human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder result = new StringBuilder();
        for (Human human : humans) {
            result.append(human).append("\n");
        }
        return result.toString();
    }

    public String getHumansChildrenInfo(int selectId) {
        StringBuilder result = new StringBuilder();
        result.append("Список детей для ")
                .append(humans.get(selectId-1).getName()).append(":\n");

        for(Human human : humans){
            if (human.getFather() != null) {
                if (human.getFather().getId() == selectId) {
                    result.append(human.getName()).append("\n");
                }
            }
        }
        return result.toString();
    }

    public void sortByName () {
        Collections.sort(humans, new ComparatorByName());
    }

    public void sortByAge() {
        Collections.sort(humans, new ComparatorByAge());
    }

    public void sortByBirthDay() {
        Collections.sort(humans, new ComparatorByBirthDay());
    }

    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(humans);
    }
}
