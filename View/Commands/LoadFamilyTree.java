package View.Commands;

import model.Model;
import View.View;

public class LoadFamilyTree implements Command {
    private Model model;
    private View view;

    public LoadFamilyTree(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void execute() {
        String fileName = view.getFileNameInput();
        model.loadFamilyTree(fileName);
        view.showMessage("Семейное дерево загружено.");
    }

    @Override
    public String getDescription() {
        return "Загрузить семейное дерево";
    }
}
