package View.Commands;

import model.Model;
import View.View;

public class ShowFamilyTree implements Command {
    private Model model;
    private View view;

    public ShowFamilyTree(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void execute() {
        view.showFamilyTree(model.getFamilyTree().toString());
    }

    @Override
    public String getDescription() {
        return "Показать всё семейное дерево";
    }
}
