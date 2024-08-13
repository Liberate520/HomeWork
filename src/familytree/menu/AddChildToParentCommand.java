package familytree.menu;

import familytree.presenter.FamilyTreePresenter;

public class AddChildToParentCommand implements Command {
    private FamilyTreePresenter presenter;
    private String parentName;
    private String childName;

    public AddChildToParentCommand(FamilyTreePresenter presenter, String parentName, String childName) {
        this.presenter = presenter;
        this.parentName = parentName;
        this.childName = childName;
    }

    @Override
    public void execute() {
        presenter.addChildToParent(parentName, childName);
    }
}
