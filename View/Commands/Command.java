package View.Commands;

import View.View;
import model.Model;

public abstract class Command {
    protected Model model;
    protected View view;

    public Command(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public abstract void execute();

    public abstract String getDescription();
}