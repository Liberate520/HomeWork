package view.commands;

import presenter.Presenter;

public class SaveFamilyTree extends Command {

    public SaveFamilyTree(Presenter presenter) {
        super("Сохранить дерево", presenter);
    }

    @Override
    public void execute() {
        presenter.saveFamilyTree();
    }
}