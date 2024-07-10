package ru.gb.familytree.familytree;

import ru.gb.familytree.human.HumanInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<HumanInfo> {
    private List<HumanInfo> people;

    public FamilyTree() {
        people = new ArrayList<>();
    }

    public void addPerson(HumanInfo person) {
        people.add(person);
    }

    public HumanInfo findPersonByName(String name) {
        for (HumanInfo person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public List<HumanInfo> getChildrenOfPerson(String name) {
        HumanInfo person = findPersonByName(name);
        if (person != null) {
            return person.getChildren();
        }
        return new ArrayList<>();
    }

    public List<HumanInfo> getPeople() {
        return people;
    }

    @Override
    public Iterator<HumanInfo> iterator() {
        return people.iterator();
    }

    public void sortByName() {
        Collections.sort(people, Comparator.comparing(HumanInfo::getName));
    }

    public void sortByDob() {
        Collections.sort(people, Comparator.comparing(HumanInfo::getDob));
    }
}
