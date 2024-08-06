package ru.gb.family_tree.presenter;

import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.models.Human;
import ru.gb.family_tree.view.FamilyTreeView;

public class FamilyTreePresenter {
    private FamilyTree<Human> familyTree;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree<Human> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void addMember(String name, String birthDate, String gender) {
        Human member = new Human(familyTree.getAllMembers().size() + 1, name, birthDate, gender);
        familyTree.addMember(member);
        view.showMessage("Член добавлен: " + member);
    }

    public void showAllMembers() {
        view.showAllMembers(familyTree.getAllMembers());
    }

    public void showMember(int id) {
        Human member = familyTree.getMember(id);
        if (member != null) {
            view.showMember(member);
        } else {
            view.showMessage("Член не найден.");
        }
    }

    public void setParent(int childId, int parentId) {
        Human child = familyTree.getMember(childId);
        Human parent = familyTree.getMember(parentId);
        if (child != null && parent != null) {
            child.addParent(parent);
            view.showMessage("Родитель установлен.");
        } else {
            view.showMessage("Член(ы) не найдены.");
        }
    }

    public void setSpouse(int memberId, int spouseId) {
        Human member = familyTree.getMember(memberId);
        Human spouse = familyTree.getMember(spouseId);
        if (member != null && spouse != null) {
            member.setSpouse(spouse);
            view.showMessage("Супружеская связь установлена.");
        } else {
            view.showMessage("Член(ы) не найдены.");
        }
    }

    // Другие методы...
}
