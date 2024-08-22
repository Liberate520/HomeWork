package familytree.commands;

import familytree.model.Person;
import familytree.service.FamilyTreeService;
import familytree.ui.UserInterface;

import java.time.LocalDate;

public class AddMemberCommand implements Command {
    private final FamilyTreeService familyTreeService;
    private final UserInterface view;

    public AddMemberCommand(FamilyTreeService familyTreeService, UserInterface view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public void execute() {
        String familyName = view.getUserInput("Введите фамилию:");
        String firstName = view.getUserInput("Введите имя:");
        String fatherName = view.getUserInput("Введите отчество:");

        String genderInput = view.getUserInput("Введите пол (MALE/FEMALE):").toUpperCase();
        Person.Gender gender;
        try {
            gender = Person.Gender.valueOf(genderInput);
        } catch (IllegalArgumentException e) {
            view.displayMessage("Некорректный ввод пола. Используется MALE по умолчанию.");
            gender = Person.Gender.MALE;
        }

        LocalDate dateOfBirth = LocalDate.parse(view.getUserInput("Введите дату рождения (YYYY-MM-DD):"));
        LocalDate dateOfDeath = null;
        String deathKnown = view.getUserInput("Известна ли дата смерти? (да/нет):").toLowerCase();
        if (deathKnown.equals("да")) {
            dateOfDeath = LocalDate.parse(view.getUserInput("Введите дату смерти (YYYY-MM-DD):"));
        }

        familyTreeService.addMember(familyName, firstName, fatherName, gender, dateOfBirth, dateOfDeath);
        view.displayMessage("Член семьи добавлен.");
    }
}