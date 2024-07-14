//package ru.gb.family.tree;
//
//import ru.gb.family.human.Human;
//import ru.gb.family.writer.FileHandler;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class FamilyTree implements Serializable Iterable<Human> {
//    private long humansId; // переменная для присваивания идентифткатора
//    private List<Human> humanList; //список людей
//
//    // два конструктора один конструктор вызывает другой
//    public FamilyTree() {
//        this(new ArrayList<>());
//    }
//
//    public FamilyTree(List < Human > humanList) {
//        this.humanList = humanList;
//    }
//
//    //метод добавления человека
//    public boolean add(Human human){
//        if (human == null) {
//            return false; //проверка что пустую ссылку не дали
//        }
//        if (!humanList.contains(human)) {
//            humanList.add(human);
//            human.setId(humansId++);
//
//            addToParents(human);
//            addToChildren(human);
//
//            return true;
//        }
//        return false;
//    }
//
//    private void addToParents (Human human){
//        for (Human parent : human.getParents()) {
//            parent.addChild(human);
//        }
//    }
//
//    private void addToChildren (Human human){
//        for (Human child : human.getChildren()) {
//            child.addParent(human);
//        }
//    }
//
//    //методы поиска братьев сестер
//    public List<Human> getSiblings ( int id){
//        Human human = getById(id);
//        if (human == null) {
//            return null;
//        }
//        List<Human> res = new ArrayList<>();
//        for (Human parent : human.getParents()) {
//            for (Human child : parent.getChildren()) {
//                if (!child.equals(human)) {
//                    res.add(child);
//                }
//            }
//        }
//        return res;
//    }
//
//    public List<Human> getByName (String name){ // поиск по имени
//        List<Human> res = new ArrayList<>();
//        for (Human human : humanList) {
//            if (human.getName().equals(name)) {
//                res.add(human);
//            }
//        }
//        return res;
//    }
//
//    //метод создания супружеской связи
//    public boolean setWedding ( long humansId1, long humansId2){
//        if (checkId(humansId1) && checkId(humansId2)) {
//            Human human1 = getById(humansId1);
//            Human human2 = getById(humansId2);
//            return setWedding(human1, human2);
//        }
//        return false;
//    }
//
//    //развод
//    public boolean setWedding (Human human1, Human human2){
//        if (human1.getSpouse() == null && human2.getSpouse() == null) {
//            human1.setSpouse(human2);
//            human2.setSpouse(human1);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean remove ( long humansId){
//        if (checkId(humansId)) {
//            Human human = getById(humansId);
//            return humanList.remove(human);
//        }
//        return false;
//    }
//
//    //проверяет id в нужном диапозоне
//    private boolean checkId ( long id){
//        return id < humansId && id >= 0;
//    }
//
//    public Human getById ( long id){
//        for (Human human : humanList) {
//            if (human.getId() == id) {
//                return human;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public String toString () {
//        return getInfo();
//    }
//
//    public String getInfo () {
//        StringBuilder sb = new StringBuilder();
//        sb.append("В дереве");
//        sb.append(humanList.size());
//        sb.append(" объектов: \n");
//        for (Human human : humanList) {
//            sb.append(human);
//            sb.append("\n");
//        }
//        return sb.toString();
//    }
//
//    @Override
//    public Iterator<Human> iterator() {
//        return new FamilyTreeIterator(humanList);
//    }
//
//    public void sortBirthDate () {
//        humanList.sort(new HumanComparatorByBirthDate());
//    }
//
//    public void sortByName () {
//        humanList.sort(new HumanComparatorByName());
//    }
//}

package ru.gb.family.tree;

import ru.gb.family.human.Human;
import ru.gb.family.human.HumanComparatorByBirthDate;
import ru.gb.family.human.HumanComparatorByName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.Serializable;
public class FamilyTree implements Serializable {
    private long humansId; // переменная для присваивания идентифткатора
    private List<Human> humanList; //список людей

    // два конструктора один конструктор вызывает другой
    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    //метод добавления человека
    public boolean add(Human human) {
        if (human == null) {
            return false; //проверка что пустую ссылку не дали
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);

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

    //методы поиска братьев сестер
    public List<Human> getSiblings(int id) {
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent : human.getParents()) {
            for (Human child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name) { // поиск по имени
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    //метод создания супружеской связи
    public boolean setWedding(long humansId1, long humansId2) {
        if (checkId(humansId1) && checkId(humansId2)) {
            Human human1 = getById(humansId1);
            Human human2 = getById(humansId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    //развод
    public boolean setWedding(Human human1, Human human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(long humansId) {
        if (checkId(humansId)) {
            Human human = getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    //проверяет id в нужном диапозоне
    private boolean checkId(long id) {
        return id < humansId && id >= 0;
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
        sb.append("В дереве");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}

//    @Override
//    public Iterator<Human> iterator() {
//        return new FamilyTreeIterator(humanList);
//    }
//
//    public void sortBirthDate() {
//        humanList.sort(new HumanComparatorByBirthDate());
//    }
//
//    public void sortByName() {
//        humanList.sort(new HumanComparatorByName());
//    }
//}