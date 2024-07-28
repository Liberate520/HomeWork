package View.Сommand;

import Presenter.FamilyTreePresenter;

public class PrintTreeCommand implements Command {

    private FamilyTreePresenter presenter;

    public PrintTreeCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.getView().showFamilyTree(presenter.getAllElements());
    }
}
