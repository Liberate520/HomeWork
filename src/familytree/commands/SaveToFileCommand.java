package familytree.commands;

import familytree.service.FamilyTreeService;
import familytree.ui.UserInterface;

import java.io.IOException;

public class SaveToFileCommand implements Command {
    private final FamilyTreeService familyTreeService;
    private final UserInterface view;

    public SaveToFileCommand(FamilyTreeService familyTreeService, UserInterface view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public void execute() {
        String filename = view.promptForInput("Введите имя файла для сохранения: ");

        try {
            familyTreeService.saveToFile(filename);
            view.displayMessage("Дерево успешно сохранено в файл: " + filename);
        } catch (IOException e) {
            view.displayMessage("Ошибка при сохранении: " + e.getMessage());
        }
    }
}