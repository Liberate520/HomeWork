package View.Commands;

import model.Model;
import View.View;

public class SaveFamilyTree extends Command {

    public SaveFamilyTree(Model model, View view) {
        super(model, view);
    }

    @Override
    public void execute() {
        String fileName = view.getFileNameInput();
        model.saveFamilyTree(fileName);
        view.showMessage("Сохранено!");
    }

    @Override
    public String getDescription() {
        return "Сохранить семейное дерево";
    }
}

