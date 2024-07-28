package View.Сommand;

import java.time.LocalDate;
// import java.util.Scanner;

// import FamilyTree.FamilyTree;
import Human.Gender;
import Human.Human;
import Presenter.FamilyTreePresenter;
import View.ConsoleInputHandler;

public class AddHumanCommand implements Command {
    private FamilyTreePresenter presenter;
    private ConsoleInputHandler inputHandler;

    public AddHumanCommand(FamilyTreePresenter presenter, ConsoleInputHandler inputHandler) {
        this.presenter = presenter;
        this.inputHandler = inputHandler;
    }

    @Override
    public void execute() {
        String name = inputHandler.getStringInput("Введите имя: ");
        LocalDate birthDate = inputHandler.getDateInput("Введите дату рождения (YYYY-MM-DD): ");
        LocalDate deathDate = inputHandler.getDateInput("Введите дату смерти (YYYY-MM-DD) или оставьте пустым: ");
        Gender gender = inputHandler.getGenderInput("Введите пол (MALE/FEMALE): ");

        // Human father = presenter.findByName(inputHandler.getStringInput("Введите имя отца (или оставьте пустым): "));
        // Human mother = presenter.findByName(inputHandler.getStringInput("Введите имя матери (или оставьте пустым): "));
        String fatherName = inputHandler.getStringInput("Введите имя отца (или оставьте пустым): ");
        Human father = fatherName.isEmpty() ? null : presenter.findByName(fatherName);
        
        String motherName = inputHandler.getStringInput("Введите имя матери (или оставьте пустым): ");
        Human mother = motherName.isEmpty() ? null : presenter.findByName(motherName);



        presenter.onAddHuman(name, birthDate, deathDate, gender, father, mother);
    }
}
