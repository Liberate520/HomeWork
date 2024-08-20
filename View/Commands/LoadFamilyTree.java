package View.Commands;

import model.Model;
import View.View;

public class LoadFamilyTree extends Command {

    public LoadFamilyTree(Model model, View view) {
        super(model, view);
    }

    @Override
    public void execute() {
        String fileName = view.getFileNameInput();
        model.loadFamilyTree(fileName);
        view.showMessage("Загружено!");
    }

    @Override
    public String getDescription() {
        return "Загрузить семейное дерево";
    }
}

