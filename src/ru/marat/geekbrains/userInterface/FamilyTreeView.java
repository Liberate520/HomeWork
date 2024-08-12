package ru.marat.geekbrains.userInterface;

import ru.marat.geekbrains.models.FamilyTree;
import ru.marat.geekbrains.models.Person;

public interface FamilyTreeView {
    void start();
    void displayFamilyTree(FamilyTree<Person> familyTree);
    void displayMessage(String message);
}
