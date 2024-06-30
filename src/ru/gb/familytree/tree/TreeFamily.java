package ru.gb.familytree.tree;

import ru.gb.familytree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeFamily implements Serializable {
    private long humansId;
    private List<Human> humanList;

    public TreeFamily() {
        this(new ArrayList<>());
    }

    public TreeFamily(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void add(Human human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);

        }
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

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве: ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
