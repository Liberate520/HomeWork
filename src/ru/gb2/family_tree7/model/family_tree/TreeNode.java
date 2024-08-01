package ru.gb2.family_tree7.model.family_tree;

import java.util.List;

public interface TreeNode<E> {
    long getId(); // Получение уникального идентификатора узла
    void setId(long id); // Установка уникального идентификатора узла

    public interface Named {
        String getName(); // Получение имени узла
    }

    public interface ParentChildRelation<E> {
        List<E> getParents(); // Получение списка родителей

        List<E> getChildren(); // Получение списка детей

        void addParent(E parent); // Добавление родителя

        void addChild(E child); // Добавление ребенка

        void removeParent(E parent); // Удаление родителя

        void removeChild(E child); // Удаление ребенка
    }
}

