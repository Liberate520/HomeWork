package familytree.commands;

import familytree.model.Person;
import familytree.service.FamilyTreeServiceInterface;
import familytree.ui.UserInterface;

public class FindMemberCommand implements Command {
    private final FamilyTreeServiceInterface familyTreeService;
    private final UserInterface view;

    public FindMemberCommand(FamilyTreeServiceInterface familyTreeService, UserInterface view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public boolean execute() {
        String familyName = view.getUserInput("Введите фамилию:");
        String firstName = view.getUserInput("Введите имя:");
        String fatherName = view.getUserInput("Введите отчество:");

        Person member = familyTreeService.findMember(familyName, firstName, fatherName);
        if (member != null) {
            view.displayMessage("Найденный член семьи: " + member);
        } else {
            view.displayMessage("Член семьи не найден.");
        }
        return false;
    }
}