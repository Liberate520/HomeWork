package family_tree.presenter;

import family_tree.model.FamilyTreeModel;
import family_tree.person.Person;
import family_tree.util.GenealogyTree;
import family_tree.view.FamilyTreeView;

public class FamilyTreePresenterImpl implements FamilyTreePresenter {
    private final GenealogyTree<Person> tree;
    private final FamilyTreeView view;

    public FamilyTreePresenterImpl(GenealogyTree<Person> tree, FamilyTreeView view) {
        this.tree = tree;
        this.view = view;
    }

    @Override
    public void displayFamilyTree() {
        // Реализация метода
    }

    @Override
    public void addPerson() {
        // Реализация метода
    }

    @Override
    public void removePerson() {
        // Реализация метода
    }

    // Другие методы презентера
}
