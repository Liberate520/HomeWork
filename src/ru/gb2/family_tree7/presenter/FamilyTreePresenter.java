package ru.gb2.family_tree7.presenter;


import ru.gb2.family_tree7.model.family_tree.FamilyTree;
import ru.gb2.family_tree7.model.family_tree.TreeNode;
import ru.gb2.family_tree7.model.human.Human;
import ru.gb2.family_tree7.view.ConsoleFamilyTreeView;
import ru.gb2.family_tree7.view.FamilyTreeView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FamilyTreePresenter {
//    private FamilyTreeView view;
//    private FamilyTree familyTree;
//    private TreeNode member;
//    private Human human;
//
//    // Конструктор
//    public FamilyTreePresenter(FamilyTreeView view, FamilyTree<Human> familyTree) {
//        this.view = view;
//        this.familyTree = familyTree;
//    }
//
//    public FamilyTreePresenter(ConsoleFamilyTreeView view, FamilyTree familyTree) {
//    }
//
//    public void displayFamilyTree() {
////        // Предполагаем, что метод getMembers() существует в FamilyTree
////        view.showFamilyMembers(familyTree.addMember(human));
//        for (Object human : familyTree) {
//            System.out.println(human);
//        }
//    }
private final FamilyTreeView view;
    private final List<Human> members; // Список членов семьи

    public FamilyTreePresenter(FamilyTreeView view) {
        this.view = view;
        this.members = new ArrayList<>();
    }

    public void addMember() {
        Human newMember = view.getNewMember();
        members.add(newMember);
        view.showMessage("Член семьи добавлен успешно.");
    }

    public void showMembers() {
        view.showMembers(members);
    }
}

