package family_tree.presenter;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.family_tree.TreeRoot;
import family_tree.model.human.Human;
import family_tree.view.View;

public class Presenter<T extends TreeRoot<T>> {
    private final View view;
    private FamilyTree newTree;

    public Presenter(View view) {
        this.view = view;
    }

    public void add(Human human) {
        newTree.add(human);
        printTree();
    }

    public void printTree() {
        String answer = newTree.getInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        newTree.sortName();
        printTree();
    }

    public void sortBySurName() {
        newTree.sortSurName();
        printTree();
    }
}
