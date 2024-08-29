package Homework6_OOP.FamilyTrees;

import Homework6_OOP.Human.Human;
import Homework6_OOP.HumanInterfaces.Person;
import Homework6_OOP.FamilyTreeInterface.IFamilyTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends Human> implements IFamilyTree<T> {
    private final List<T> entities = new ArrayList<>();
    private long nextId = 1;

    @Override
    public void add(T entity) {
        entity.setId(nextId++);
        entities.add(entity);
    }

    @Override
    public T getById(long id) {
        for (T entity : entities) {
            if (entity.getId() == id) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public List<T> getByName(String name) {
        List<T> result = new ArrayList<>();
        for (T entity : entities) {
            if (entity.getName().equalsIgnoreCase(name)) {
                result.add(entity);
            }
        }
        return result;
    }

    @Override
    public boolean remove(long id) {
        return entities.removeIf(entity -> entity.getId() == id);
    }

    @Override
    public boolean setWedding(long id1, long id2) {
        T person1 = getById(id1);
        T person2 = getById(id2);
        if (person1 != null && person2 != null) {
            person1.setSpouse(person2);
            person2.setSpouse(person1);
            return true;
        }
        return false;
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        for (T entity : entities) {
            info.append(entity).append("\n");
        }
        return info.toString();
    }

    @Override
    public List<T> getEntityList() {
        return new ArrayList<>(entities);
    }

    @Override
    public void addParentChildRelation(Person parent, Person child) {

    }

    @Override
    public void saveToFile(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(entities);
            oos.writeLong(nextId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            entities.clear();
            entities.addAll((List<T>) ois.readObject());
            nextId = ois.readLong();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
