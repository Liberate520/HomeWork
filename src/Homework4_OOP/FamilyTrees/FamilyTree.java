package Homework4_OOP.FamilyTrees;

import Homework4_OOP.Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FamilyTree<T extends Human> implements Serializable {
    private final List<T> entityList;
    private long entityId = 0; // Счетчик ID

    public FamilyTree() {
        this.entityList = new ArrayList<>();
    }

    public void add(T entity) {
        entity.setId(entityId++); // Присвоение уникального ID
        entityList.add(entity);
    }

    public List<T> getByName(String name) {
        return entityList.stream()
                .filter(entity -> entity.getName().equalsIgnoreCase(name))
                .toList();
    }

    public T getById(long id) {
        return entityList.stream()
                .filter(entity -> entity.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean remove(long id) {
        return entityList.removeIf(entity -> entity.getId() == id);
    }

    public boolean setWedding(long id1, long id2) {
        T person1 = getById(id1);
        T person2 = getById(id2);

        if (person1 instanceof Human human1 && person2 instanceof Human human2) {
            return createMarriage(human1, human2);
        }
        return false;
    }

    public boolean createMarriage(Human human1, Human human2) {
        if (human1 == null || human2 == null || human1.equals(human2)) {
            return false;
        }

        // Проверяем, что оба человека не состоят в браке
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        return false;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        for (T entity : entityList) {
            sb.append(entity).append("\n");
        }
        return sb.toString();
    }

    public List<T> getEntityList() {
        return entityList;
    }
}
