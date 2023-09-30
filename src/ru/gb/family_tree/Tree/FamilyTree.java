package ru.gb.family_tree.Tree;

import ru.gb.family_tree.Family.Human;
import ru.gb.family_tree.Family.ComparatotBy.HumanComparatorByAge;
import ru.gb.family_tree.Family.ComparatotBy.HumanComparatorByGender;
import ru.gb.family_tree.Family.ComparatotBy.HumanComparatorByName;
import ru.gb.family_tree.Family.ComparatotBy.HumanComparatorByDateOfBirth;
import ru.gb.family_tree.HumanIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Human> {
    private long humanId;
    private List<Human> humans;
    private FamilyTree familyTree;


    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humans) {
        this.humans = humans;
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humans.contains(human)) {
            humans.add(human);
            human.setId(humanId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    public Human getById(long id) {
        for (Human human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    private void addToParents(Human human) {
        Human mother = human.getMother();
        Human father = human.getFather();
        if (mother != null) {
            mother.addChild(human);
        }
        if (father != null) {
            father.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<Human> getSiblings(int id) {
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        List<Human> siblings = new ArrayList<>();
        Human mother = human.getMother();
        Human father = human.getFather();

        for (Human child : mother.getChildren()) {
            if (!child.equals(human)) {
                siblings.add(child);
            }
        }
        for (Human child : father.getChildren()) {
            if (!child.equals(human) && siblings.contains(child)) {
                siblings.add(child);
            }
        }
        return siblings;
    }

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(Human human1, Human human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        return false;
    }

    private boolean checkId(long id) {
        if (id >= humanId || id < 0) {
            return false;
        }
        return true;
    }

    public void addHuman(Human human) {
        humans.add(human);
    }

    public String getHumansNames() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family:\n");
        for (Human human : humans) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getHumansNames();
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family:\n");
        for (Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        humans.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        humans.sort(new HumanComparatorByAge());
    }

    public void sortByGender() {
        humans.sort(new HumanComparatorByGender());
    }

    public void sortByDateOfBirth() {
        humans.sort(new HumanComparatorByDateOfBirth());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humans);
    }


}