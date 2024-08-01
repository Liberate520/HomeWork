package ru.gb.family_tree.interfaces;

import java.util.Iterator;

// Обобщенный интерфейс для итерирования по элементам типа T
public interface MyIterable<T> {
    Iterator<T> iterator();
}
