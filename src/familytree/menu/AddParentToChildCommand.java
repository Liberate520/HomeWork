package familytree.menu;

import familytree.presenter.FamilyTreePresenter;

public class AddParentToChildCommand implements Command {
    private FamilyTreePresenter presenter;
    private String childName;
    private String parentName;

    public AddParentToChildCommand(FamilyTreePresenter presenter, String childName, String parentName) {
        this.presenter = presenter;
        this.childName = childName;
        this.parentName = parentName;
    }

    @Override
    public void execute() {
        presenter.addParentToChild(childName, parentName);
    }
}