package ru.marat.geekbrains.models;

public interface ParentChildRelationship<T> {
    T getMother(T member);
    T getFather(T member);
}
