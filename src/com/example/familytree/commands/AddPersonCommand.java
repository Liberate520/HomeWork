package com.example.familytree.commands;

import com.example.familytree.mvp.FamilyTreePresenter;
import com.example.familytree.mvp.FamilyTreeView;

public class AddPersonCommand implements Command {
    private final FamilyTreePresenter presenter;
    private final FamilyTreeView view;

    public AddPersonCommand(FamilyTreePresenter presenter, FamilyTreeView view) {
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public void execute() {
        try {
            int id = view.getPersonIdInput();
            String name = view.getPersonNameInput();
            String birthDate = view.getPersonBirthDateInput();
            String gender = view.getPersonGenderInput();
            presenter.addPerson(id, name, birthDate, gender);
        } catch (NumberFormatException e) {
            view.displayMessage("Ошибка: ID должен быть числовым значением.");
        }
    }

    @Override
    public String getDescription() {
        return "Добавление человека";
    }
}
