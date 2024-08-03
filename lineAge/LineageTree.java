package com.oop.homeWorkOOP.lineAge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import com.oop.homeWorkOOP.human.Gender;
import com.oop.homeWorkOOP.human.Human;
import com.oop.homeWorkOOP.human.comparators.compareHumanByBirthDate;
import com.oop.homeWorkOOP.human.comparators.compareHumanByName;

public class LineageTree implements Serializable, Iterable<Human> {
    private List<Human> lineAge;

    public LineageTree() {
        lineAge = new ArrayList<>();
    }

    public boolean addHuman(Human human) {
        if (lineAge.contains(human)) {
            System.out.println("Такой человек уже есть в древе.");
            return false;
        }
        searchAndAddChildren(human);
        searchAndAddParents(human);
        lineAge.add(human);
        return true;
    }

    private boolean searchAndAddParents(Human human) {
        boolean fl = false;
        for (Human mem : lineAge) {
            if (mem.getChildren().size() > 0) {
                for (Human chil : mem.getChildren()) {
                    if (chil.equals(human)) {
                        if (chil.getGender() == Gender.Male && human.getFather() == null) {
                            human.setFather(mem);
                            fl = true;
                        } else if (chil.getGender() == Gender.Female && human.getMother() == null) {
                            human.setMother(mem);
                            fl = true;
                        }
                    }

                }
            }
        }
        return fl;
    }

    private boolean searchAndAddChildren(Human human) {
        boolean fl = false;
        for (Human mem : lineAge) {
            for (Human par : mem.getParents()) {
                if (par != null) {
                    if (par.equals(human)) {
                        human.addChild(mem);
                        fl = true;
                    }
                }
            }
        }
        return fl;
    }

    public Human getHumanById(int i) {
        if (i >= lineAge.size()) {
            System.out.println("Нет такого ID.");
            return null;
        } else
            return lineAge.get(i);
    }

    public List<Human> getHumanByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : lineAge) {
            if (name.equals(human.getName())) {
                res.add(human);
            }
        }
        return res;
    }

    public void printLineAge() {
        for (int i = 0; i < lineAge.size(); i++) {
            System.out.println("ID: " + i + " " + lineAge.get(i).toString());
        }
    }

    public LineageTree getAllFather(Human human) {
        LineageTree resTree = new LineageTree();
        resTree.addHuman(human);
        while (true) {
            if (Objects.isNull(human.getFather()))
                return resTree;
            human = human.getFather();
            resTree.addHuman(human);
        }
    }

    public LineageTree getAllMother(Human human) {
        LineageTree resTree = new LineageTree();
        resTree.addHuman(human);
        while (true) {
            if (human.getMother() == null) {
                return resTree;
            }
            human = human.getMother();
            resTree.addHuman(human);
        }
    }

    public LineageTree getAllChildren(Human human) {
        LineageTree resTree = new LineageTree();
        resTree.addHuman(human);
        if (human.getChildren().size() <= 0) {
            return resTree;
        }
        for (Human chil : human.getChildren()) {
            getAllChildren(chil, resTree);
        }
        return resTree;
    }

    private LineageTree getAllChildren(Human human, LineageTree resTree) {
        resTree.addHuman(human);
        if (human.getChildren().size() <= 0) {
            return resTree;
        }
        for (Human chil : human.getChildren()) {
            getAllChildren(chil, resTree);
        }
        return resTree;
    }

    public LineageTree getAllParents(Human human) {
        LineageTree resTree = new LineageTree();
        resTree.addHuman(human);
        if (human.getParents().size() <= 0) {
            return resTree;
        }
        for (Human par : human.getParents()) {
            getAllParents(par, resTree);
        }
        return resTree;
    }

    private LineageTree getAllParents(Human human, LineageTree resTree) {
        resTree.addHuman(human);
        if (human.getParents().size() <= 0) {
            return resTree;
        }
        for (Human par : human.getParents()) {
            getAllParents(par, resTree);
        }
        return resTree;
    }

    @Override
    public Iterator<Human> iterator() {
        return new LineAgeIterator(lineAge);
    }

    public void sortByName() {
        lineAge.sort(new compareHumanByName());
    }

    public void sortByBirthDate() {
        lineAge.sort(new compareHumanByBirthDate());
    }

}
