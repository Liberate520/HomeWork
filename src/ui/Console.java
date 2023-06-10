package ui;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import human.Gender;
import presenter.Presenter;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu mainMenu;
    
    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new Menu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work) {
            presenter.loadFile();
            System.out.println(mainMenu.print());
            int choice = inputNumMenu();
            if (choice == -1){
                System.out.println("Ошибка ввода");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLine(line)){
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")){
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= mainMenu.size();
    }

    public void addHuman() {
        System.out.println("Введите имя");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Выберите пол:\n1. Мужской\n2. Женский");
        Gender gender = null;
        while (gender == null) {
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    gender = Gender.Male;
                    break;
                case "2":
                    gender = Gender.Female;
                    break;
                default:
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }
        System.out.println("Введите дату рождения в формате 'дд.мм.гггг'");
        String input = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        presenter.addHuman(firstName, lastName, gender, birthDate);
    }
    
    public void finish() {
        System.out.println("До свидания!");
        work = false;
    }

    public void getInfo() {
        presenter.getInfo();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void saveFile() {
        presenter.saveFile();
    }

    @Override
    public void loadFile() {
        presenter.loadFile();
    }
}
