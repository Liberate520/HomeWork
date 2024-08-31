package familytree.commands;

import familytree.model.Person;
import familytree.service.FamilyTreeServiceInterface;
import familytree.ui.UserInterface;

import java.util.List;

public class PrintSortedByDateOfBirthCommand implements Command {
    private final FamilyTreeServiceInterface familyTreeService;
    private final UserInterface view;

    public PrintSortedByDateOfBirthCommand(FamilyTreeServiceInterface familyTreeService, UserInterface view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public boolean execute() {
        List<Person> sortedByDateOfBirth = familyTreeService.getSortedByDateOfBirth();
        view.displayPersons(sortedByDateOfBirth);
        return false;
    }
}
