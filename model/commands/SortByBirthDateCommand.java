package model.commands;

import model.services.FamilyTreeService;
import view.View;

public class SortByBirthDateCommand implements Command {
    private FamilyTreeService service;
    private View view;

    public SortByBirthDateCommand(FamilyTreeService service, View view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        service.sortByBirthDate();
        view.display("Дерево отсортировано по дате рождения.");
    }
}
