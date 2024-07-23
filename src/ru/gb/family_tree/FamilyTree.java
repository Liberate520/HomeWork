package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    // Добавление члена семьи
    public void addMember(Human human) {
        this.members.add(human);
    }

    // Получение всех детей выбранного человека
    public List<Human> getChildren(Human human) {
        return human.getChildren();
    }

    // Поиск человека по полному имени (для удобства)
    public Human findByFullName(String fullName) {
        for (Human member : members) {
            if (member.getFullName().equalsIgnoreCase(fullName)) {
                return member;
            }
        }
        return null;
    }
}