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

    // Получение всех детей выбранного человека в виде поддерева
    public FamilyTree getChildren(Human human) {
        FamilyTree subtree = new FamilyTree();
        addChildrenRecursively(subtree, human);
        return subtree;
    }

    // Рекурсивное добавление детей и их потомков в поддерево
    private void addChildrenRecursively(FamilyTree subtree, Human human) {
        for (Human child : human.getChildren()) {
            subtree.addMember(child);
            addChildrenRecursively(subtree, child);
        }
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

    // Получение всех членов семьи
    public List<Human> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "members=\n" + members.stream()
                                     .map(Human::toString)
                                     .collect(Collectors.joining("\n")) +
                '}';
    }
}