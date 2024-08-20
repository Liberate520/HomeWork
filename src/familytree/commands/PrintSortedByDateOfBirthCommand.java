package familytree.commands;

import familytree.model.Person;
import familytree.service.FamilyTreeService;
import familytree.ui.UserInterface;

import java.util.List;

public class PrintSortedByDateOfBirthCommand implements Command {
    private final FamilyTreeService familyTreeService;
    private final UserInterface view;

    public PrintSortedByDateOfBirthCommand(FamilyTreeService familyTreeService, UserInterface view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public void execute() {
        List<Person> sortedByDateOfBirth = familyTreeService.getSortedByDateOfBirth();
        view.displayPersons(sortedByDateOfBirth);
    }
}
