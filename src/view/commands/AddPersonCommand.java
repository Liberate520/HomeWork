package view.commands;

import presenter.Presenter;
import view.Command;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

        System.out.print("Enter death date (YYYY-MM-DD) or 'none' if alive: ");
        String deathDateStr = scanner.nextLine();
        LocalDate deathDate = deathDateStr.equalsIgnoreCase("none") ? null : LocalDate.parse(deathDateStr);

        System.out.print("Enter gender (male/female): ");
        String gender = scanner.nextLine();

        System.out.print("Enter spouse name or 'none': ");
        String spouseName = scanner.nextLine();
        spouseName = spouseName.equalsIgnoreCase("none") ? null : spouseName;

        System.out.print("Enter children names separated by commas or 'none': ");
        String childrenStr = scanner.nextLine();
        List<String> childrenNames = childrenStr.equalsIgnoreCase("none") ? new ArrayList<>() : List.of(childrenStr.split(","));

        System.out.print("Enter father name or 'none': ");
        String fatherName = scanner.nextLine();
        fatherName = fatherName.equalsIgnoreCase("none") ? null : fatherName;

        System.out.print("Enter mother name or 'none': ");
        String motherName = scanner.nextLine();
        motherName = motherName.equalsIgnoreCase("none") ? null : motherName;

        presenter.addPerson(name, birthDate, deathDate, gender, spouseName, childrenNames, fatherName, motherName);
    }

    @Override
    public String getName() {
        return "add";
    }
}
