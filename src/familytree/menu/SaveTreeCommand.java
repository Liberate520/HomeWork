package familytree.menu;

import familytree.presenter.FamilyTreePresenter;

public class SaveTreeCommand implements Command {
    private FamilyTreePresenter presenter;

    public SaveTreeCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.saveFamilyTree();
    }
}