package view.commands;

import presenter.Presenter;

public class LoadFamilyTree extends Command {

    public LoadFamilyTree(Presenter presenter) {
        super("Загрузить дерево", presenter);
    }

    @Override
    public void execute() {
        presenter.loadFamilyTree();
    }
}