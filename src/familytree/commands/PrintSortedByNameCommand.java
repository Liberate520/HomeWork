package familytree.commands;

import familytree.model.Person;
import familytree.service.FamilyTreeServiceInterface;
import familytree.ui.UserInterface;

import java.util.List;

public class PrintSortedByNameCommand implements Command {
    private final FamilyTreeServiceInterface familyTreeService;
    private final UserInterface view;

    public PrintSortedByNameCommand(FamilyTreeServiceInterface familyTreeService, UserInterface view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public boolean execute() {
        List<Person> sortedByName = familyTreeService.getSortedByName();
        view.displayPersons(sortedByName);
        return false;
    }
}