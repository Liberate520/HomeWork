package familytree.commands;

import familytree.service.FamilyTreeServiceInterface;
import familytree.ui.UserInterface;

public class AddParentChildRelationshipCommand implements Command {
    private final FamilyTreeServiceInterface familyTreeService;
    private final UserInterface view;

    public AddParentChildRelationshipCommand(FamilyTreeServiceInterface familyTreeService, UserInterface view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public boolean execute() {
        String parentFamilyName = view.getUserInput("Введите фамилию родителя:");
        String parentFirstName = view.getUserInput("Введите имя родителя:");
        String parentFatherName = view.getUserInput("Введите отчество родителя:");

        String childFamilyName = view.getUserInput("Введите фамилию ребенка:");
        String childFirstName = view.getUserInput("Введите имя ребенка:");
        String childFatherName = view.getUserInput("Введите отчество ребенка:");

        familyTreeService.addParentChildRelationship(parentFamilyName, parentFirstName, parentFatherName,
                childFamilyName, childFirstName, childFatherName);
        view.displayMessage("Родительско-детская связь добавлена!");
        return false;
    }
}