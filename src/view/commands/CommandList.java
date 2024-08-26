package view.commands;

import model.family_tree.FamilyTreeItem;

import java.util.List;

public interface CommandList<T extends FamilyTreeItem> {

    void add(T item);

    List<T> getFamilyTree();

    List<T> findByName(String name);

    void sortByName();

    void sortByBirthDate();

    void sortByAge();

    String printList(List<T> list);
}
