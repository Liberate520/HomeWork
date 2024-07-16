package View;

import Model.family_tree.human.Gender;
import Presenter.Presenter;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleUI implements View{
private Scanner scanner;
private boolean work;
private Presenter presenter;
private MainMenu menu;

    public ConsoleUI() {
        scanner =new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        menu = new MainMenu(this);


    }

    @Override
    public void start() {
        System.out.println("Здравствуйте дорогуша! Начнем исследование вашей семьи");
        while (work) {
            // Выводим меню и запрашиваем выбор пользователя
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();


            try {
                int choice = Integer.parseInt(choiceStr);


                if (choice < 1 || choice > menu.size()) {
                    System.out.println("Ошибка: выберите число из доступного списка.");
                    continue;
                }


                menu.execute(choice);

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число.");
            }
        }

    }

    public void SortById() {
        presenter.sortById();
    }

    public void SetSpouse() {
        System.out.println("Укажите id первого супруга");
        String idStr1 = scanner.nextLine();
        System.out.println("Укажите id второго супруга");
        String idStr2 = scanner.nextLine();
        presenter.setSpouse(idStr1, idStr2);
    }

    public void SetFamily() {
        System.out.println("Укажите id родителя");
        String idStr1 = scanner.nextLine();
        System.out.println("Укажите id ребенка");
        String idStr2 = scanner.nextLine();
        presenter.SetFamily(idStr1, idStr2);
    }

    public void SetSex() {
        System.out.println("Укажите id ");
        String idStr = scanner.nextLine();
        System.out.println("Укажите пол");
        String sexStr = scanner.nextLine();
        presenter.SetSex(idStr, sexStr);
    }

    public void finish() {
        work = false;
        scanner.close();
        System.out.println("До новых встреч");
    }

    public void Load() {
        presenter.Load();
    }

    public void Save() {
        presenter.Save();
    }

    public void SortByAge() {
        presenter.sortByAge();
    }

    public void SortByName() {
        presenter.sortByName();
    }

    public void getTree() {
        presenter.getTree();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }
    public void add() {
        System.out.println("Укажите имя ");
    String name = scanner.nextLine();
                    System.out.println("Укажите пол ");
    String sexStr = scanner.nextLine();



        System.out.println("Укажите дату рождения человека через пробел в формате ГГГГ MM ДД: ");

        String brthDateStr = scanner.nextLine();
        LocalDate brthDate = StrToLocalDate(brthDateStr);
        presenter.addHuman(name, sexStr, brthDate);

    }
    private LocalDate StrToLocalDate(String brthDateStr) {
        LocalDate brthDate = null; // Инициализируем переменную заранее

        try {
            String[] dataList = brthDateStr.split(" ");
            int year = Integer.parseInt(dataList[0]);
            int month = Integer.parseInt(dataList[1]);
            int day = Integer.parseInt(dataList[2]);
            brthDate = LocalDate.of(year, month, day);
        } catch (DateTimeException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getMessage());

        }

        return brthDate;
    }

}
