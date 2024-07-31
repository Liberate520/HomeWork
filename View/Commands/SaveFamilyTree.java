package View.Commands;

import model.Model;
import View.View;

public class SaveFamilyTree implements Command {
    private Model model;
    private View view;

    public SaveFamilyTree(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void execute() {
        String fileName = view.getFileNameInput();
        model.saveFamilyTree(fileName);
        view.showMessage("Семейное дерево сохранено.");
    }

    @Override
    public String getDescription() {
        return "Сохранить семейное дерево";
    }
}
