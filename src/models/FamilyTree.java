package models;

import enums.Gender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс для представления генеалогического древа.
 * Реализует основные операции над деревом, такие как:
 * - Установка родителей для человека
 * - Установка супруга для человека
 * - Получение детей, родителей, супруга и братьев/сестер для человека
 */
public class FamilyTree {
    private Map<Human, List<Human>> parents;
    private Map<Human, Human> spouses;

    /**
     * Конструктор класса FamilyTree.
     * Инициализирует внутренние структуры данных для хранения родственных связей.
     */
    public FamilyTree() {
        parents = new HashMap<>();
        spouses = new HashMap<>();
    }

    /**
     * Устанавливает родителей для указанного человека.
     *
     * @param child   Человек, для которого устанавливаются родители
     * @param parents Список родителей
     */
    public void setParents(Human child, List<Human> parents) {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.MALE && !this.parents.containsKey(parent)) {
                this.parents.put(parent, new ArrayList<>());
            } else if (parent.getGender() == Gender.FEMALE && !this.parents.containsKey(parent)) {
                this.parents.put(parent, new ArrayList<>());
            }
        }

        for (Human parent : parents) {
            this.parents.get(parent).add(child);
        }

        this.parents.put(child, new ArrayList<>(parents));
    }

    /**
     * Устанавливает супруга для указанного человека.
     *
     * @param person Человек, для которого устанавливается супруг
     * @param spouse Супруг
     */
    public void setSpouse(Human person, Human spouse) {
        spouses.put(person, spouse);
        spouses.put(spouse, person);
    }

    /**
     * Возвращает список детей для указанного человека.
     *
     * @param person Человек, для которого получаем список детей
     * @return Список детей
     */
    public List<Human> getChildren(Human person) {
        if (parents.containsKey(person)) {
            return parents.get(person);
        }
        return new ArrayList<>();
    }

    /**
     * Возвращает список родителей для указанного человека.
     *
     * @param person Человек, для которого получаем список родителей
     * @return Список родителей
     */
    public List<Human> getParents(Human person) {
        List<Human> result = new ArrayList<>();
        for (Map.Entry<Human, List<Human>> entry : parents.entrySet()) {
            if (entry.getValue().contains(person)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    /**
     * Возвращает супруга для указанного человека.
     *
     * @param person Человек, для которого получаем супруга
     * @return Супруг
     */
    public Human getSpouse(Human person) {
        return spouses.get(person);
    }

    /**
     * Возвращает список братьев и сестер для указанного человека.
     *
     * @param person Человек, для которого получаем список братьев и сестер
     * @return Список братьев и сестер
     */
    public List<Human> getSiblings(Human person) {
        List<Human> siblings = new ArrayList<>();
        List<Human> parents = getParents(person);
        for (Human parent : parents) {
            siblings.addAll(getChildren(parent));
        }
        siblings.remove(person);
        return siblings;
    }
}