package model.commands;

import model.services.FamilyTreeService;
import view.View;

public class SaveTreeCommand implements Command {
    private FamilyTreeService service;
    private View view;

    public SaveTreeCommand(FamilyTreeService service, View view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        String filename = view.getUserInput("Введите имя файла для сохранения: ");
        service.saveTree(filename);
        view.display("Дерево сохранено в файл " + filename);
    }
}
