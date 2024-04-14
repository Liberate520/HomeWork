package ru.gb.family_tree.dog_family_tree;

import ru.gb.family_tree.family_tree.TreeNode;

import java.util.List;

public class DogFamilyTree<E extends TreeNode<E>> {
    private final List<E> dogList;
    private long countDogs;

    public DogFamilyTree(List<E> dogList) {
        this.dogList = dogList;
    }
}
