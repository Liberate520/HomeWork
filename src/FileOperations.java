package com.example.familytree.operations;

import com.example.familytree.FamilyTree;

public interface FileOperations {
    void saveToFile(String filename, FamilyTree tree); // Метод для сохранения всего дерева в файл
    FamilyTree loadFromFile(String filename); // Метод для загрузки дерева из файла
}
