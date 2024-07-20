package View.Сommand;

import java.time.LocalDate;
import java.util.Scanner;

// import FamilyTree.FamilyTree;
import Human.Gender;
import Human.Human;
import Presenter.FamilyTreePresenter;

public class AddHumanCommand implements Command {
    private final FamilyTreePresenter presenter;
    private final Scanner scanner;

    public AddHumanCommand(FamilyTreePresenter presenter, Scanner scanner) {
        this.presenter = presenter;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите дату рождения (YYYY-MM-DD):");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Введите дату смерти (если есть) (YYYY-MM-DD):");
        String deathDateInput = scanner.nextLine();
        LocalDate deathDate = deathDateInput.isEmpty() ? null : LocalDate.parse(deathDateInput);

        System.out.println("Введите пол (Male/Female):");
        Gender gender = Gender.valueOf(scanner.nextLine());

        System.out.println("Введите имя отца (если есть):");
        String fatherName = scanner.nextLine();
        Human father = presenter.findByName(fatherName);

        System.out.println("Введите имя матери (если есть):");
        String motherName = scanner.nextLine();
        Human mother = presenter.findByName(motherName);

        presenter.onAddHuman(name, birthDate, deathDate, gender, father, mother);
    }
}
