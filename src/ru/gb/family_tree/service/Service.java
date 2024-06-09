package ru.gb.family_tree.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import ru.gb.family_tree.builder.ItemBuilder;
import ru.gb.family_tree.item.FamilyTreeItem;
import ru.gb.family_tree.item.Gender;
import ru.gb.family_tree.tree.FamilyTree;
import ru.gb.family_tree.saving_data.*;

public class Service<E extends FamilyTreeItem<E>> {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private FamilyTree<E> tree;
    private ItemBuilder<E> itemBuilder;
    private FamilyTreeItem<E> item;
    private String storage;
    private Writable writable;

    public Service() {
        tree = new FamilyTree<>();
        itemBuilder = new ItemBuilder<E>();
        item = itemBuilder.build(name, gender, birthDate);
        // storage = "I:/000 Geek Brains/ОСНОВНОЙ КУРС
        // ПРОГРАММИРОВАНИЕ/Объектно-ориентированное
        // программирование/homeWork/family_tree.out";
        storage = "../../../../../family_tree.out";
        writable = new FileHandler(tree);
    }

    @SuppressWarnings("unchecked")
    public void addItem(String name, Gender gender, LocalDate birthDate) {
        tree.add((E) itemBuilder.build(name, gender, birthDate));
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public void sortBySpouse() {
        tree.sortBySpouse();
    }

    public void saveTree() throws FileNotFoundException, IOException {
        writable.write_object(tree, storage);
    }

    @SuppressWarnings("unchecked")
    public FamilyTree<E> readTree() throws FileNotFoundException, ClassNotFoundException, IOException {
        tree = writable.read_object(storage);
        return tree;
    }

    public List<FamilyTreeItem<E>> getSiblings(long id) { // Поиск братьев и сестёр...
        return tree.getSiblings(id);
    }

    public List<FamilyTreeItem<E>> getByName(String name) {
        return tree.getByName(name);
    }

    public boolean setWedding(long itemID1, long itemID2) {
        return tree.setWedding(itemID1, itemID2);
    }

    public boolean setDivorce(long itemID1, long itemID2) {
        return tree.setDivorce(itemID1, itemID2);
    }

    public boolean remove(long id) {
        return tree.remove(id);
    }

    public FamilyTreeItem<E> getById(long id) {
        return tree.getById(id);
    }

    public long getId() {
        return item.getId();
    }

    @Override
    public String toString() {
        return tree.getInfo();
    }
}