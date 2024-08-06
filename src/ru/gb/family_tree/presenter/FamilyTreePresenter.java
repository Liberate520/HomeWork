package ru.gb.family_tree.presenter;

import ru.gb.family_tree.interfaces.HasRelations;
import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.view.FamilyTreeView;

import java.io.Serializable;

public class FamilyTreePresenter<T extends HasRelations<T> & Serializable> {
    private FamilyTree<T> familyTree;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree<T> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void addMember(T member) {
        familyTree.addMember(member);
        view.showMessage("Член добавлен: " + member);
    }

    public void setSpouse(int id1, int id2) {
        T member1 = familyTree.getMember(id1);
        T member2 = familyTree.getMember(id2);
        if (member1 != null && member2 != null) {
            // Пример: метод setSpouse должен быть у класса T
        } else {
            view.showMessage("Член не найден.");
        }
    }

    public void setParent(int childId, int parentId) {
        T child = familyTree.getMember(childId);
        T parent = familyTree.getMember(parentId);
        if (child != null && parent != null) {
            child.addParent(parent);
            view.showMessage("Родитель добавлен: " + parent + " для ребенка " + child);
        } else {
            view.showMessage("Член не найден.");
        }
    }

    public void showAllMembers() {
        view.showAllMembers(familyTree.getAllMembers());
    }

    // Другие методы...
}
