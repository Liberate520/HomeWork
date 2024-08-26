package view.commands;

import java.util.Scanner;

import presenter.Presenter;

public class AddBirthPlace extends Command {

    public AddBirthPlace(Presenter presenter) {
        super("Добавить место рождения человеку", presenter);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID человека: ");
        long humanID = Long.parseLong(scanner.nextLine());
        System.out.println("Введите ID места: ");
        long placeID = Long.parseLong(scanner.nextLine());
        presenter.addBirthPlace(humanID, placeID);
    }
}
