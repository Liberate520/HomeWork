package presenter;

import model.commands.*;
import model.services.FamilyTreeService;
import view.View;

import java.util.HashMap;
import java.util.Map;

public class FamilyTreePresenter {
    private FamilyTreeService service;
    private View view;
    private Map<Integer, Command> commandMap;

    public FamilyTreePresenter(FamilyTreeService service, View view) {
        this.service = service;
        this.view = view;
        this.commandMap = new HashMap<>();
        initializeCommands();
    }

    private void initializeCommands() {
        commandMap.put(1, new AddPersonCommand(service, view));
        commandMap.put(2, new ShowTreeCommand(service, view));
        commandMap.put(3, new SortByNameCommand(service, view));
        commandMap.put(4, new SortByBirthDateCommand(service, view));
        commandMap.put(5, new SaveTreeCommand(service, view));
        commandMap.put(6, new LoadTreeCommand(service, view));
        commandMap.put(7, new ExitCommand(view));
    }

    public void start() {
        boolean running = true;
        while (running) {
            view.showMenu();
            int choice = view.getUserIntInput("Выберите действие: ");
            Command command = commandMap.get(choice);
            if (command != null) {
                command.execute();
                if (command instanceof ExitCommand) {
                    running = false;
                }
            } else {
                view.displayError("Неверный выбор, пожалуйста, попробуйте снова.");
            }
        }
    }
}
