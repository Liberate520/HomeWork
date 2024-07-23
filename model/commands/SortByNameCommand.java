package model.commands;

import model.services.FamilyTreeService;
import view.View;

public class SortByNameCommand implements Command {
    private FamilyTreeService service;
    private View view;

    public SortByNameCommand(FamilyTreeService service, View view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        service.sortByName();
        view.display("Дерево отсортировано по имени.");
    }
}
