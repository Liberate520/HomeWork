package model.commands;

import model.services.FamilyTreeService;
import view.View;

public class ShowTreeCommand implements Command {
    private FamilyTreeService service;
    private View view;

    public ShowTreeCommand(FamilyTreeService service, View view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        view.display(service.showTree());
    }
}
