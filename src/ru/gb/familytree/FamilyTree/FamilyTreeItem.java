package ru.gb.familytree.FamilyTree;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem {
    String getName();
    LocalDate getBirthDate();
    <T extends FamilyTreeItem> List<T> getChildren();
    <T extends FamilyTreeItem> List<T> getParents();
}
