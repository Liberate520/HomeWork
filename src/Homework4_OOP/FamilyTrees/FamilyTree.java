package Homework4_OOP.FamilyTrees;

import Homework4_OOP.Human.Person;
import Homework4_OOP.Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Person> implements Iterable<T>, Serializable {
    private long entityId;
    private List<T> entityList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> entityList) {
        this.entityList = entityList;
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(entityList);
    }

    public boolean add(T entity) {
        if (entity == null) {
            return false;
        }

        if (!entityList.contains(entity)) {
            entityList.add(entity);
            if (entity instanceof Human) {
                Human human = (Human) entity;
                human.setId(entityId++);
                addToParents(human);
                addToChildren(human);
            }
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
        T person = getById(id);
        if (person instanceof Human human) {
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
        return null;
    }

    public List<T> getByName(String name) {
        List<T> res = new ArrayList<>();
        for (T entity : entityList) {
            if (entity.getName().equals(name)) {
                res.add(entity);
            }
        }
        return res;
    }

    public boolean setWedding(long id1, long id2) {
        if (checkId(id1) && checkId(id2)) {
            Human human1 = (Human) getById(id1);
            Human human2 = (Human) getById(id2);
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

    public boolean remove(long id) {
        if (checkId(id)) {
            T entity = getById(id);
            return entityList.remove(entity);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < entityId && id >= 0;
    }

    public T getById(long id) {
        for (T entity : entityList) {
            if (entity.getId() == id) {
                return entity;
            }
        }
        return null;
    }

    public void sortByName() {
        entityList.sort(Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        entityList.sort(Comparator.comparing(entity -> {
            if (entity instanceof Human) {
                return ((Human) entity).getBirthDate();
            }
            return null;
        }));
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В древе: ");
        sb.append(entityList.size());
        sb.append(" объектов(-а): \n");
        for (T entity : entityList) {
            sb.append(entity);
            sb.append("\n");
        }
        return sb.toString();
    }
}
