package ru.gb.family_tree.model.tree.interfaces;

public interface Searchable<T> {
    T findMember(String name);
}
