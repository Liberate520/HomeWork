package familytree.menu;

import familytree.presenter.FamilyTreePresenter;

public class PrintTreeCommand implements Command {
    private FamilyTreePresenter presenter;

    public PrintTreeCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.displayFamilyTree();
    }
}

