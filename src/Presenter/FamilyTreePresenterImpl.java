package Presenter;

import model.FamilyTree;
import model.Node;
import view.UserInterface;

public class FamilyTreePresenterImpl extends FamilyTreePresenter {
    public FamilyTreePresenterImpl(FamilyTree<Node> familyTree, UserInterface userInterface) {
        super(familyTree, userInterface);
    }
}
