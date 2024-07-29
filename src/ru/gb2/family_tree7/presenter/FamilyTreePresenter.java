package ru.gb2.family_tree7.presenter;


import ru.gb2.family_tree7.model.family_tree.FamilyTree;
import ru.gb2.family_tree7.model.family_tree.TreeNode;
import ru.gb2.family_tree7.model.human.Human;
import ru.gb2.family_tree7.view.ConsoleFamilyTreeView;
import ru.gb2.family_tree7.view.FamilyTreeView;

public class FamilyTreePresenter {
    private FamilyTreeView view;
    private FamilyTree familyTree;
    private TreeNode member;
    private Human human;

    // Конструктор
    public FamilyTreePresenter(FamilyTreeView view, FamilyTree<Human> familyTree) {
        this.view = view;
        this.familyTree = familyTree;
    }

    public FamilyTreePresenter(ConsoleFamilyTreeView view, FamilyTree familyTree) {
    }

    public void displayFamilyTree() {
//        // Предполагаем, что метод getMembers() существует в FamilyTree
//        view.showFamilyMembers(familyTree.addMember(human));
        for (Object human : familyTree) {
            System.out.println(human);
        }
    }
}

