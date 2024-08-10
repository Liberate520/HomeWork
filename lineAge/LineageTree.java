package com.oop.homeWorkOOP.lineAge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.oop.homeWorkOOP.human.Gender;
import com.oop.homeWorkOOP.human.comparators.compareHumanByBirthDate;
import com.oop.homeWorkOOP.human.comparators.compareHumanByName;

public class LineageTree<T extends LineAgeItem<T>> implements Serializable, Iterable<T> {
    private List<T> lineAge;

    public LineageTree() {
        lineAge = new ArrayList<>();
    }

    public boolean addHuman(T human) {
        if (lineAge.contains(human)) {
            System.out.println("Такой человек уже есть в древе.");
            return false;
        }
        searchAndAddChildren(human);
        searchAndAddParents(human);
        lineAge.add(human);
        return true;
    }

    private boolean searchAndAddParents(T human) {
        boolean fl = false;
        for (T mem : lineAge) {
            if (!mem.getChildren().isEmpty()) {
                for (T chil : mem.getChildren()) {
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

    private boolean searchAndAddChildren(T human) {
        boolean fl = false;
        for (T mem : lineAge) {
            for (T par : mem.getParents()) {
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

    public T getHumanById(int i) {
        if (i >= lineAge.size()) {
            System.out.println("Нет такого ID.");
            return null;
        } else
            return lineAge.get(i);
    }

    public List<T> getHumanByName(String name) {
        List<T> res = new ArrayList<>();
        for (T human : lineAge) {
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

    public LineageTree<T> getAllFather(T human) {
        LineageTree<T> resTree = new LineageTree<>();
        resTree.addHuman(human);
        while (true) {
            if (human.getFather() == null)
                return resTree;
            human = (T) human.getFather();
            resTree.addHuman(human);
        }
    }

    public LineageTree<T> getAllMother(T human) {
        LineageTree<T> resTree = new LineageTree<>();
        resTree.addHuman(human);
        while (true) {
            if (human.getMother() == null) {
                return resTree;
            }
            human = human.getMother();
            resTree.addHuman(human);
        }
    }

    public LineageTree<T> getAllChildren(T human) {
        LineageTree<T> resTree = new LineageTree<>();
        resTree.addHuman(human);
        if (human.getChildren().size() <= 0) {
            return resTree;
        }
        for (T chil : human.getChildren()) {
            getAllChildren(chil, resTree);
        }
        return resTree;
    }

    private LineageTree<T> getAllChildren(T human, LineageTree<T> resTree) {
        resTree.addHuman(human);
        if (human.getChildren().size() <= 0) {
            return resTree;
        }
        for (T chil : human.getChildren()) {
            getAllChildren(chil, resTree);
        }
        return resTree;
    }

    public LineageTree<T> getAllParents(T human) {
        LineageTree<T> resTree = new LineageTree<>();
        resTree.addHuman(human);
        if (human.getParents().size() <= 0) {
            return resTree;
        }
        for (T par : human.getParents()) {
            getAllParents(par, resTree);
        }
        return resTree;
    }

    private LineageTree<T> getAllParents(T human, LineageTree<T> resTree) {
        resTree.addHuman(human);
        if (human.getParents().size() <= 0) {
            return resTree;
        }
        for (T par : human.getParents()) {
            getAllParents(par, resTree);
        }
        return resTree;
    }

    @Override
    public Iterator<T> iterator() {
        return new LineAgeIterator<>(lineAge);
    }

    public void sortByName() {
        lineAge.sort(new compareHumanByName<T>());
    }

    public void sortByBirthDate() {
        lineAge.sort(new compareHumanByBirthDate<T>());
    }

}
