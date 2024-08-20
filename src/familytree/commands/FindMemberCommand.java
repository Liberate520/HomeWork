package familytree.commands;

import familytree.model.Person;
import familytree.service.FamilyTreeService;
import familytree.ui.UserInterface;

public class FindMemberCommand implements Command {
    private final FamilyTreeService familyTreeService;
    private final UserInterface view;

    public FindMemberCommand(FamilyTreeService familyTreeService, UserInterface view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public void execute() {
        String familyName = view.getUserInput("Введите фамилию:");
        String firstName = view.getUserInput("Введите имя:");
        String fatherName = view.getUserInput("Введите отчество:");

        Person member = familyTreeService.findMember(familyName, firstName, fatherName);
        if (member != null) {
            view.displayMessage("Найденный член семьи: " + member);
        } else {
            view.displayMessage("Член семьи не найден.");
        }
    }
}