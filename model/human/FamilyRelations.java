package model.human;

import java.util.ArrayList;
import java.util.List;

import model.family_tree.FamilyTreeItem;

// Применяем SRP: Класс FamilyRelations отвечает за управление семейными отношениями.
// Применяем DIP: Используем интерфейс для зависимостей.
public class FamilyRelations<T extends FamilyTreeItem<T>> {
    private T father;
    private T mother;
    private T spouse;
    private List<T> children;

    public FamilyRelations() {
        this.children = new ArrayList<>();
    }

    public void setFather(T father) {
        this.father = father;
    }

    public void setMother(T mother) {
        this.mother = mother;
    }

    public void setSpouse(T spouse) {
        this.spouse = spouse;
    }

    public boolean addChild(T child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(T child) {
        return children.remove(child);
    }

    public List<T> getChildren() {
        return children;
    }

    public T getFather() {
        return father;
    }

    public T getMother() {
        return mother;
    }

    public T getSpouse() {
        return spouse;
    }
}