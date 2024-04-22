package src.view.commands;

import java.time.LocalDate;

import src.Model.Gender;
import src.view.ConsoleUI;

public class AddPerson extends Command {

    public AddPerson(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека";
    }

    @Override
    public void execute() {
        Gender gendr = null;
        //int year;
        //int mn;
        //int day;
        StringBuilder dt = new StringBuilder();

        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите пол\n");
        System.out.println("Где Ж - женский, а М - мужcкой");
        boolean wrk = true;
        while (wrk) {
            String gender = scanner.nextLine();
            if (gender.toUpperCase() == "Ж") {
                gendr = Gender.female;
                wrk = false;
            } else if (gender.toUpperCase() == "М") {
                gendr = Gender.male;
                wrk = false;
            } else {
                System.out.println("Ввод не корректен, попробуйте снова");
            }
        }
        System.out.println("Введите дату рождения\n");
        wrk = true;
        while (wrk) {
            System.out.println("Введите год: ");
            String num = scanner.nextLine();
            if (num.length() < 4 || num == null || num.contains("-")) {
                System.out.println("Ввод не корректен, попробуйте снова");
            } else {
                //year = Integer.parseInt(num);
                dt.append(num);
                wrk = false;
            }
        }
        wrk = true;
        while (wrk) {
            System.out.println("Введите месяц: ");
            String num = scanner.nextLine();
            if (num.length() < 4 || num == null || num.contains("-")) {
                System.out.println("Ввод не корректен, попробуйте снова");
            } else {
                //mn = Integer.parseInt(num);
                dt.append(num);
                wrk = false;
            }
        }
        wrk = true;
        while (wrk) {
            System.out.println("Введите день: ");
            String num = scanner.nextLine();
            if (num.length() < 4 || num == null || num.contains("-")) {
                System.out.println("Ввод не корректен, попробуйте снова");
            } else {
                //day = Integer.parseInt(num);
                dt.append(num);
                wrk = false;
            }
        }
        LocalDate date = LocalDate.parse(dt);

        presenter.addPerson(name, gendr, date);
    }

}
