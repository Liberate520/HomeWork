package familytree.commands;

import familytree.model.Person;
import familytree.service.FamilyTreeService;
import familytree.ui.UserInterface;

import java.util.List;

public class PrintSortedByNameCommand implements Command {
    private final FamilyTreeService familyTreeService;
    private final UserInterface view;

    public PrintSortedByNameCommand(FamilyTreeService familyTreeService, UserInterface view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public void execute() {
        List<Person> sortedByName = familyTreeService.getSortedByName();
        view.displayPersons(sortedByName);
    }
}