package ru.gb.family_tree.family_tree;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

//public class FamilyTreeIterator<T extends TreeNode<T>> implements Iterator<T> {
//    private List<T> list;
//    private int index;

//    public FamilyTreeIterator(List<T> list) {
//        this.list = list;
//        index = 0;
//    }

//    @Override
//    public boolean hasNext() {
//       return index < list.size();
//    }

//    @Override
//    public T next() {
//        return list.get(index++);
//    }
//}
public class FamilyTreeIterator<T extends TreeNode<T>> implements Iterator<T> {
    private final List<T> list;
    private int index;

    public FamilyTreeIterator(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the iterator");
        }
        return list.get(index++);
    }
}