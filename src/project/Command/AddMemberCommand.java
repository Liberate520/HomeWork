package project.Command;

import java.time.LocalDate;
import java.util.Scanner;

import project.Members.Gender;
import project.Members.Human;
import project.Presenter.FamilyTreePresenter;

public class AddMemberCommand implements Command {
    private FamilyTreePresenter presenter;
    private Scanner scanner;

    public AddMemberCommand(FamilyTreePresenter presenter, Scanner scanner) {
        this.presenter = presenter;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (ГГГГ-ММ-ДД): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Введите пол (мужской/женский): ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        presenter.addMember(new Human(name, birthDate, gender));
    }
}
