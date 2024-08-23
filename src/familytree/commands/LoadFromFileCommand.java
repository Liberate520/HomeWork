package familytree.commands;
import familytree.service.FamilyTreeServiceInterface;
import familytree.ui.UserInterface;

import java.io.IOException;

public class LoadFromFileCommand implements Command {
    private final FamilyTreeServiceInterface familyTreeService;
    private final UserInterface view;

    public LoadFromFileCommand(FamilyTreeServiceInterface familyTreeService, UserInterface view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public void execute() {
        try {
            String filename = view.getUserInput("Введите имя файла для загрузки:");
            familyTreeService.loadFromFile(filename);
            view.displayMessage("Дерево загружено успешно!");
        } catch (IOException | ClassNotFoundException e) {
            view.displayMessage("Ошибка при загрузке: " + e.getMessage());
        }
    }
}