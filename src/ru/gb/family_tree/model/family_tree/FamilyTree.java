package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.service.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeItem<T>> implements Serializable, Iterable<T> {
    private int humansId;
    private final List<T> items;

    public FamilyTree() {
        this.items = new ArrayList<>();
    }

    public boolean addItem(T item){
        if (item == null) {
            return false;
        }
        if (!items.contains(item)) {
            items.add(item);
            //item.setId(++humansId);
            addToParents(item);
            addToChildren(item);
            return true;
        }
        return false;
    }

    public void setFather(int idChildren, int idFather) {
        /*
        for (T itemChildren : items) {
            if (itemChildren.getId() == idChildren) {
                for (T itemFather : items) {
                    if (itemFather.getId() == idFather) {
                        itemChildren.setFather(itemFather);
                        addToParents(itemChildren);
                        addToChildren(itemChildren);
                    }
                }
            }
        }

         */
        T itemChildren = getById(idChildren);
        T itemFather = getById(idFather);
        itemChildren.setFather(itemFather);
        addToParents(itemChildren);
        addToChildren(itemChildren);
    }

    public void setMother(int idChildren, int idMother) {
        /*
        for (T itemChildren : items) {
            if (itemChildren.getId() == idChildren) {
                for (T itemFather : items) {
                    if (itemFather.getId() == idMother) {
                        itemChildren.setMother(itemFather);
                        addToParents(itemChildren);
                        addToChildren(itemChildren);
                    }
                }
            }
        }

         */
        T itemChildren = getById(idChildren);
        T itemMother = getById(idMother);
        itemChildren.setMother(itemMother);
        addToParents(itemChildren);
        addToChildren(itemChildren);
    }

    public void setDeathDay(int id, LocalDate deathDay) {
        for (T item : items) {
            if (item.getId() == id) {
                item.setDeathDate(deathDay);
            }
        }
    }

    private void addToParents(T human) {
        for (T parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(T human) {
        for (T child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<T> getSiblings(int id) {
        List<T> result = new ArrayList<>();
        T item = getById(id);
        if (item == null) {
            return null;
        }
        for (T parent : item.getParents()) {
            for (T child : parent.getChildren()) {
                if (!child.equals(item)) {
                    result.add(child);
                }
            }
        }
        return result;
    }

    public List<T> getByName(String name) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (item.getName().equals(name)) {
                result.add(item);
            }
        }
        return result;
    }

    public boolean setWedding(int id1, int id2) {
        if (checkId(id1) && checkId(id2)) {
            T human1 = getById(id1);
            T human2 = getById(id2);
            return setWedding(human1, human2);
        }
        return false;
    }

    private boolean setWedding (T human1, T human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(int id1, int id2) {
        if (checkId(id1) && checkId(id2)) {
            T human1 = getById(id1);
            T human2 = getById(id2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    private boolean setDivorce(T human1, T human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int humansId) {
        if (checkId(humansId)) {
            T item = getById(humansId);
            return items.remove(item);
        }
        return false;
    }

    private boolean checkId(int id) {
        return  id < items.size() && id >= 0;
    }

    public T getById(int id) {
        for (T item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public String getTreeInfo() {
        StringBuilder result = new StringBuilder();
        for (T item : items) {
            result.append(item).append("\n");
        }
        return result.toString();
    }

    public String getChildrenInfo(int selectId) {
        StringBuilder result = new StringBuilder();
        result.append("Список детей для ");

        for(T item : items) {
            if (item.getId() == selectId) {
                result.append(item.getName()).append(":\n");
                if (!item.getChildren().isEmpty()) {
                    result.append(item.getChildren().getFirst().getName());
                    for (int i = 1; i < item.getChildren().size(); i++) {
                        result.append(", ").append(item.getChildren().get(i).getName());
                    }
                } else {
                    result.append("отсутствуют");
                }
            }
        }

        return result.toString();
    }

    public void sortById () {
        items.sort(new HumanComparatorById<>());
    }

    public void sortByName () {
        items.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        items.sort(new HumanComparatorByAge<>());
    }

    public void sortByBirthDay() {
        items.sort(new HumanComparatorByBirthDay<>());
    }

    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(items);
    }
}
