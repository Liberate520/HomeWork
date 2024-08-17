package view.commands;

import presenter.Presenter;
import view.Command;

import java.time.LocalDate;
import java.util.Scanner;

public class AddPersonCommand implements Command {
    private Presenter presenter;

    public AddPersonCommand(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter birth date (YYYY-MM-DD): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter death date (YYYY-MM-DD or 'none' if alive): ");
        String deathDateInput = scanner.nextLine();
        LocalDate deathDate = null;
        if (!deathDateInput.equalsIgnoreCase("none")) {
            deathDate = LocalDate.parse(deathDateInput);
        }

        System.out.print("Enter gender (MALE/FEMALE): ");
        String gender = scanner.nextLine();
        presenter.addPerson(name, birthDate, deathDate, gender);
    }
}
