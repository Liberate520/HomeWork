package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс FamilyTree представляет генеалогическое древо.
 * Он содержит список людей и позволяет добавлять, удалять и получать людей из списка.
 */
public class FamilyTree<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<T> familyMembers;

    /**
     * Конструктор класса FamilyTree.
     */
    public FamilyTree() {
        this.familyMembers = new ArrayList<>();
    }

    /**
     * Добавляет человека в генеалогическое древо.
     *
     * @param member человек, который добавляется в древо
     */
    public void add(T member) {
        familyMembers.add(member);
    }

    /**
     * Возвращает список людей в генеалогическом древе.
     *
     * @return список людей
     */
    public List<T> getFamilyMembers() {
        return familyMembers;
    }
}