package familytree.menu;

import familytree.presenter.FamilyTreePresenter;

public class LoadTreeCommand implements Command {
    private FamilyTreePresenter presenter;

    public LoadTreeCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.loadFamilyTree();
    }
}