package model.commands;

import model.services.FamilyTreeService;
import view.View;

public class LoadTreeCommand implements Command {
    private FamilyTreeService service;
    private View view;

    public LoadTreeCommand(FamilyTreeService service, View view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        String filename = view.getUserInput("Введите имя файла для загрузки: ");
        service.loadTree(filename);
        view.display("Дерево загружено из файла " + filename);
    }
}
