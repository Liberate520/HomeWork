package ru.gb.familytree.model.human.tree;

import ru.gb.familytree.model.human.SomeBody;
import ru.gb.familytree.model.human.HumanComparatorByAge;
import ru.gb.familytree.model.human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeFamily<T extends SomeBody> implements Serializable, Iterable<T> {
    private long humansId;
    private List<T> humanList;

    public TreeFamily() {
        this.humanList = new ArrayList<>();
    }

    public TreeFamily(List<T> humanList) {
        this.humanList = humanList;
    }

    public void add(T human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);
        }
    }

    private void addToParents(T human) {
        for (SomeBody parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(T human) {
        for (SomeBody child : human.getChildren()) {
            child.addParent(human);
        }
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве: ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (T human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortTreeByName() {
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortTreeByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }

    @Override
    public Iterator<T> iterator() {
        //return studentList.iterator(); //простой вариант
        return new TreeFamilyIterator<>(humanList);
    }

    public String getListOfHumans() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");
        for (T human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
