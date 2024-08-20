package View.Commands;

import model.Model;
import View.View;

public class ShowFamilyTree extends Command {

    public ShowFamilyTree(Model model, View view) {
        super(model, view);
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

