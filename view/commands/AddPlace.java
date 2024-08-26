package view.commands;

import presenter.Presenter;
import java.util.Scanner;

// Применяем SRP: Класс AddPlace отвечает за добавление места.
public class AddPlace extends Command {

    public AddPlace(Presenter presenter) {
        super("Добавить место", presenter);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер дома: ");
        int homeNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите улицу: ");
        String street = scanner.nextLine();
        System.out.println("Введите название субьекта: ");
        String region = scanner.nextLine();
        System.out.println("Введите страну: ");
        String country = scanner.nextLine();
        System.out.println("Введите почтовый индекс: ");
        int postalCode = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите название населенного пункта: ");
        String locality = scanner.nextLine();
        presenter.addPlace(homeNumber, street, region, country, postalCode, locality);
    }
}
