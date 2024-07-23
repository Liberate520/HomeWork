package model.commands;

import model.services.FamilyTreeService;
import view.UserInput;
import view.View;

public class AddPersonCommand implements Command {
    private FamilyTreeService service;
    private View view;

    public AddPersonCommand(FamilyTreeService service, View view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        UserInput userInput = view.getUserInput();
        service.addPerson(userInput.getName(), userInput.getBirthDate(), userInput.getGender(), userInput.getFatherId(), userInput.getMotherId());
        view.display("Человек добавлен в дерево.");
    }
}
