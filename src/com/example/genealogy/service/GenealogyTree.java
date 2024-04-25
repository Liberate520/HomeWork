package com.example.genealogy.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GenealogyTree<T> implements Iterable<T> {

    private T root;
    private List<T> people;

    public GenealogyTree(T root) {
        this.root = root;
        this.people = new ArrayList<>();
    }

    @Override
    public Iterator<T> iterator() {
        return new GenealogyTreeIterator(root);
    }

    private class GenealogyTreeIterator implements Iterator<T> {

        private T currentPerson;

        public GenealogyTreeIterator(T root) {
            this.currentPerson = root;
        }

        @Override
        public boolean hasNext() {
            return currentPerson != null;
        }

        @Override
        public T next() {
            T nextPerson = currentPerson;
            currentPerson = findNextPerson(currentPerson);
            return nextPerson;
        }

        private T findNextPerson(T person) {
            if (!getChildren(person).isEmpty()) {
                return getChildren(person).get(0);
            } else {
                T parent = getParent(person);
                while (parent != null && getChildren(parent).indexOf(person) == getChildren(parent).size() - 1) {
                    person = parent;
                    parent = getParent(parent);
                }
                if (parent != null) {
                    return getChildren(parent).get(getChildren(parent).indexOf(person) + 1);
                }
            }
            return null;
        }
    }

    public void sortByName() {
        Collections.sort(people, new Comparator<T>() {
            @Override
            public int compare(T p1, T p2) {
                return getName(p1).compareTo(getName(p2));
            }
        });
    }

    public void sortByDateOfBirth() {
        Collections.sort(people, new Comparator<T>() {
            @Override
            public int compare(T p1, T p2) {
                return getDateOfBirth(p1).compareTo(getDateOfBirth(p2));
            }
        });
    }

    public void addPerson(T person) {
        people.add(person);
    }

    public void removePerson(T person) {
        people.remove(person);
    }

    public String getName(T person) {
        return getName(person);
    }

    public T getParent(T person) {
        return getParent(person);
    }

    public List<T> getChildren(T person) {
        return getChildren(person);
    }

    public Date getDateOfBirth(T person) {
        return getDateOfBirth(person);
    }
}
