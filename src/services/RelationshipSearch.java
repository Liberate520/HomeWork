package services;

import models.FamilyTree;
import models.Human;

import java.util.List;

/**
 * Класс для поиска родственных связей в генеалогическом древе.
 * Предоставляет методы для поиска родителей, супруга, братьев/сестер выбранного человека.
 */
public class RelationshipSearch {
    private FamilyTree familyTree;

    /**
     * Конструктор класса RelationshipSearch.
     *
     * @param familyTree Генеалогическое древо, в котором производится поиск
     */
    public RelationshipSearch(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    /**
     * Возвращает список родителей для указанного человека.
     *
     * @param person Человек, для которого ищутся родители
     * @return Список родителей
     */
    public List<Human> findParents(Human person) {
        return familyTree.getParents(person);
    }

    /**
     * Возвращает супруга для указанного человека.
     *
     * @param person Человек, для которого ищется супруг
     * @return Супруг
     */
    public Human findSpouse(Human person) {
        return familyTree.getSpouse(person);
    }

    /**
     * Возвращает список братьев и сестер для указанного человека.
     *
     * @param person Человек, для которого ищутся братья и сестры
     * @return Список братьев и сестер
     */
    public List<Human> findSiblings(Human person) {
        return familyTree.getSiblings(person);
    }
}