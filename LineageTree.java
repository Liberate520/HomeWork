package com.oop.homeWorkOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LineageTree {
    private List<Human> lineAge;

    public LineageTree() {
        lineAge = new ArrayList<>();
    }

    public void addHuman(Human human) {
        lineAge.add(human);
    }

    public Human getHumanById(int i) {
        if (i >= lineAge.size()) {
            System.out.println("Нет такого ID, вот первый ID.");
            return lineAge.get(0);
        } else
            return lineAge.get(i);
    }

    public void printLineAge() {
        for (int i = 0; i < lineAge.size(); i++) {
            System.out.println("ID: " + i + " " + lineAge.get(i).toString());
        }
    }

    public LineageTree getFatherLine(Human human) {
        LineageTree resTree = new LineageTree();
        resTree.addHuman(human);
        while (true) {
            if (Objects.isNull(human.getFather()))
                return resTree;
            human = human.getFather();
            resTree.addHuman(human);
        }
    }

    public LineageTree getMotherLine(Human human) {
        LineageTree resTree = new LineageTree();
        resTree.addHuman(human);
        while (true) {
            if (Objects.isNull(human.getMother()))
                return resTree;
            human = human.getMother();
            resTree.addHuman(human);
        }
    }
}
