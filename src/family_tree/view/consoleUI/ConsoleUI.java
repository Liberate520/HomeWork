package family_tree.view.consoleUI;

import family_tree.model.help_classes.Gender;
import family_tree.model.program_classes.Human;
import family_tree.pesenter.Presenter;
import family_tree.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private boolean work;
    private Presenter presenter;
    private MainMenu menu;
    String filePath = "src/family_tree/model/saving_data/data.out";

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.work = true;
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        loadData();
        while (work) {
            System.out.println(menu.showMenu());
            execute();
        }

    }

    private void loadData() {
        try {
            presenter.loadDataFile(filePath);
            System.out.println("Данные загружены");
        }
        catch (Exception e) {
            System.out.println("Не удалось загрузить данные");
        }

    }


    private void execute() {
        String line = scanner.nextLine();
        if (!isCorrectChoice(line)) return;
        int choice = Integer.parseInt(line);
        menu.execute(choice);
    }

    private boolean isCorrectChoice(String line) {
        if (!line.matches("[0-9]+")) return false;
        int choice = Integer.parseInt(line);
        if (choice > menu.getSize()) return false;
        return true;
    }

    public void saveDataFile() {
        presenter.saveDataFile(filePath);
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void findByDocument() {
        String doc = getDocument();
        presenter.findByDocument(doc);
    }

    public void findByName() {
        String name = getName();
        presenter.findByName(name);
    }

    public void registerDeath() {
        String doc = getDocument();
        LocalDate date = getDate();
        presenter.registerDeath(doc, date);
    }

    public void addFamilyLink() {
        System.out.println("Ребёнок: ");
        String childDoc = getDocument();
        System.out.println("Родитель: ");
        String parentDoc = getDocument();
        presenter.addFamilyLink(childDoc, parentDoc);
    }

    public void addHuman() {
        String doc = getDocument();
        String name = getName();
        Gender gender = getGender();
        LocalDate date = getDate();
        presenter.addHuman(doc,name,gender,date);
    }

    private LocalDate getDate() {
        System.out.println("Укажите дату рождения в формате ДД ММ ГГГГ: ");
        String str = scanner.nextLine();
        while (!isCorrectDate(str)) {
            System.out.println("Дата указана неверно");
            System.out.println("Укажите дату рождения в формате ДД ММ ГГГГ: ");
            str = scanner.nextLine();
        }
        String[] str_parts = str.split(" ");
        LocalDate date = LocalDate.of(Integer.parseInt(str_parts[2]), Integer.parseInt(str_parts[1]), Integer.parseInt(str_parts[0]));
        return date;
    }

    private boolean isCorrectDate(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        dateFormat.setLenient(false);
        try {
            Date parsedDate = dateFormat.parse(str);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private Gender getGender() {
        genderMenu();
        String gender = scanner.nextLine();
        while (!isCorrectGender(gender)) {
            System.out.println("Введённое значение некорректно.");
            genderMenu();
            gender = scanner.nextLine();
        }
        if (gender == "1") {
            return Gender.Male;
        }
        else {
            return Gender.Female;
        }
    }

    private void genderMenu() {
        System.out.println("Выберите пол:");
        System.out.println("1. Мужской");
        System.out.println("2. Женский");
    }

    private boolean isCorrectGender(String gender) {
        if (gender.equals("1") || gender.equals("2")) {
            return true;
        }
        return false;
    }

    private String getDocument() {
        System.out.print("Введите номер документа: ");
        return scanner.nextLine();
    }

    private String getName() {
        System.out.print("Введите имя: ");
        return scanner.nextLine();
    }

    public void finish() {
        presenter.saveDataFile(filePath);
        work = false;
        System.out.println("Работа завершена.");
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }


    public void ShowTree() {
        presenter.getTreeInfo();
    }
}
