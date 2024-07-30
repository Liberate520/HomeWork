package View.Commands;

import Model.Human.Gender;
import Presenter.Presenter;
import View.Command;
import View.MainMenu;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class AddtoTree extends Command {
    Scanner scanner;

    public AddtoTree()  {
        super("Добавить в дерево");
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Вы ввели имя:" + name);
        System.out.println("Введите пол (male/female:");
        String gender = scanner.nextLine();
        System.out.println("Вы ввели пол:" + gender);
        System.out.println("Введите дату рождения (в формате ГГГГ-ММ-ДД):");
        String dobInput = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dobInput);
        System.out.println("Вы ввели дату рождения:" + dob);
        presenter.addToTree(name, Gender.valueOf(gender), dob);
        System.out.println("в семейное дерево добавлен НОВЫЙ человек" + presenter.getFamilyTreeInfo());

    }

}
