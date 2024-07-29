package ru.gb2.family_tree7.presenter;


import ru.gb2.family_tree7.model.family_tree.FamilyTree;
import ru.gb2.family_tree7.model.family_tree.TreeNode;
import ru.gb2.family_tree7.model.human.Human;
import ru.gb2.family_tree7.view.ConsoleUI;
import ru.gb2.family_tree7.view.View;

public class Presenter {
    private View view;
    private FamilyTree familyTree;
    private TreeNode member;
    private Human human;

    // Конструктор
    public Presenter(View view, FamilyTree<Human> familyTree) {
        this.view = view;
        this.familyTree = familyTree;
    }

    public Presenter(ConsoleUI view, FamilyTree familyTree) {
    }

    public void displayFamilyTree() {
//        // Предполагаем, что метод getMembers() существует в FamilyTree
//        view.showFamilyMembers(familyTree.addMember(human));
        for (Object human : familyTree) {
            System.out.println(human);
        }
    }
}

