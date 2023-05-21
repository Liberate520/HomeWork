package ui.commands;

import ui.View.View;

public class GetInfo implements Command{
    private View view;

    public GetInfo(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Показать семейное дерево";
    }

    @Override
    public void execute() {
        view.getInfo();
    }
}
