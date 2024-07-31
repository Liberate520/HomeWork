package view;

import model.person.Gender;
import model.person.Human;
import presenter.Presenter;
import view.extraMenus.FileMenu;
import view.extraMenus.SortMenu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private boolean work;
    private Presenter presenter;
    private MainMenu mainMenu;
    private SortMenu sortMenu;
    private FileMenu fileMenu;
    private static final String INPUT_ID_ERROR = "Человека нет с таким ID";

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        mainMenu = new MainMenu(this);
        sortMenu = new SortMenu(this);
        fileMenu = new FileMenu(this);
    }

    @Override
    public void start() {
        greeting();
        checkAndOrCreateDefaultFile();
        while (work) {
            System.out.println(mainMenu.showMenu());
            System.out.println("Введите пункт меню (число):");
            String choiceStr = scanner.nextLine();
            int choice = strNumToInt(choiceStr);
            if (isNumMainMenu(choice)) {
                mainMenu.execute(choice);
            } else {
                System.out.println("Неверный ввод. Попробуйте еще раз");
            }
        }
    }

    private void greeting() {
        System.out.println("Программа запустилась.\nДобро пожаловать в программу для создания Вашего семейного древа!");
    }

    // Открыть меню по сортировке
    public void openSortMenu() {
        System.out.println(sortMenu.showMenu());
        System.out.println("Введите пункт меню (число):");
        String choiceStr = scanner.nextLine();
        int choice = strNumToInt(choiceStr);
        if (isNumSortMenu(choice)) {
            sortMenu.execute(choice);
        } else {
            System.out.println("Неверный ввод. Попробуйте еще раз");
        }
    }

    // Открыть меню по работе с фалами семейного древа
    public void openFileMenu() {
        System.out.println(fileMenu.showMenu());
        System.out.println("Введите пункт меню (число):");
        String choiceStr = scanner.nextLine();
        int choice = strNumToInt(choiceStr);
        if (isNumFileMenu(choice)) {
            fileMenu.execute(choice);
        } else {
            System.out.println("Неверный ввод. Попробуйте еще раз");
        }
    }

    public void finish() {
        presenter.saveFile();
        scanner.close();
        work = false;
        System.out.println("Пока-пока, программа закрылась!\nСемейное древо сохранилось в файл: " + presenter.getPath());
    }

    public void addHuman() {
        Gender gender;
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("""
                Укажите гендер:
                1. Мужской
                2. Женский
                Введите число:""");
        String choiceStr = scanner.nextLine();
        if (choiceStr.equals("1")){
            gender = Gender.Male;
        } else if (choiceStr.equals("2")){
            gender = Gender.Female;
        } else {
            System.out.println("Введено неверное число, попробуйте снова");
            return;
        }

        System.out.println("Введите дату рождения в формате yyyy-MM-dd (пример 2001-12-28)");
        String dateOfBirthStr = scanner.nextLine();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);
            presenter.addHuman(name, gender, dateOfBirth);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Неверный ввод даты");
        }

    }

    public void addChild() {
        System.out.println("Введите ID родителя:");
        String idParentStr = scanner.nextLine();
        long idParent = strNumToLong(idParentStr);

        if (searchIdHuman(idParent)){
            System.out.println("Введите ID ребенка:");
            String idChildStr = scanner.nextLine();
            long idChild = strNumToLong(idChildStr);

            if (searchIdHuman(idChild)){
                presenter.addChildToParent(idParent, idChild);
            }else{inputIdError();}

        }else{inputIdError();}
    }

    public void getHumanBirthDate() {
        System.out.println("Введите ID челоека:");
        String choiceStr = scanner.nextLine();
        long idHuman = strNumToLong(choiceStr);
        if (searchIdHuman(idHuman)) {
            System.out.println(getHumanById(idHuman).getName() + ":");
            presenter.getHumanBirthDate(idHuman);
        } else {
            inputIdError();
        }
    }

    public void getHumansListInfo() {
        presenter.getHumansListInfo();
    }

    public void setDateOfDeath() {
        System.out.println("Введите ID челоека:");
        String idHumanStr = scanner.nextLine();
        long idHuman = strNumToLong(idHumanStr);
        if (searchIdHuman(idHuman)) {
            System.out.println("Укажите дату смерти в формате yyyy-mm-dd");
            String dateOfDeathStr = scanner.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateOfDeath = LocalDate.parse(dateOfDeathStr, formatter);
                presenter.setDateOfDeath(idHuman, dateOfDeath);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Неверный ввод даты");
            }
        } else {inputIdError();}
    }

    public void setWedding() {
        System.out.println("Введите ID жениха: ");
        String idHusband = scanner.nextLine();
        long id1 = strNumToLong(idHusband);

        if (searchIdHuman(id1)) {
            System.out.println("Введите ID невесты: ");
            String idWife = scanner.nextLine();
            long id2 = strNumToLong(idWife);

            if (searchIdHuman(id2)) {
                presenter.setWedding(id1, id2);
                System.out.println("Ура! Состоялась свадьба!");
            } else {
                System.out.println("Невеста с таким ID не найдена");
            }
        } else {
            System.out.println("Жених с таким ID не найден");
        }
    }

    public void setDivorce() {
        System.out.println("Введите ID мужа: ");
        String idHusband = scanner.nextLine();
        long id1 = strNumToLong(idHusband);
        if (searchIdHuman(id1)) {
            System.out.println("Введите ID жены: ");
            String idWife = scanner.nextLine();
            long id2 = strNumToLong(idWife);

            if (searchIdHuman(id2)) {
                presenter.setDivorce(id1, id2);
                System.out.println("Развод состоялся");
            } else {
                System.out.println("Жена с таким ID не найдена");
            }
        } else {
            System.out.println("Муж с таким ID не найден");
        }
    }

    public void setFather() {
        System.out.println("Укажите ID отца:");
        String idFatherStr = scanner.nextLine();
        long idFather = strNumToLong(idFatherStr);

        if (searchIdHuman(idFather)){
            System.out.println("Укажите ID ребенка:");
            String idChildStr = scanner.nextLine();
            long idChild = strNumToLong(idChildStr);

            if (searchIdHuman(idChild)){
                presenter.setFather(idChild, idFather);
            }else{inputIdError();}

        }else{inputIdError();}
    }

    public void setMother() {
        System.out.println("Укажите ID мамы:");
        String idMotherStr = scanner.nextLine();
        long idMother = strNumToLong(idMotherStr);

        if (searchIdHuman(idMother)){
            System.out.println("Укажите ID ребенка:");
            String idChildStr = scanner.nextLine();
            long idChild = strNumToLong(idChildStr);

            if (searchIdHuman(idChild)){
                presenter.setMother(idChild, idMother);
            }else{inputIdError();}

        }else{inputIdError();}
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByChildrenQuantity() {
        presenter.sortByChildrenQuantity();
    }

    public void sortById() {
        presenter.sortById();
    }

    public void save() {
        System.out.println("Сохранение семейного древа:");
        System.out.println("1. Сохранить в файл по умолчанию: " + presenter.getPath());
        System.out.println("2. Сохранить в указанный файл");

        String choiceStr = scanner.nextLine();
        int choice = strNumToInt(choiceStr);

        if (choice == 1) {
            presenter.saveFile();
            System.out.println("Семейное древо сохранено в файл по умолчанию.");
        } else if (choice == 2) {
            setCustomPath();
            presenter.saveFile();
            System.out.println("Данные успешно сохранены в: " + presenter.getPath());
        } else {
            System.out.println("Введено неверное значение.");
        }
    }

    public void importFile() {
        System.out.print("Введите путь к файлу для импорта (например, C:\\Users\\User\\Documents\\family_tree.ser): ");
        String filePath = scanner.nextLine();

        if (isValidFile(filePath)) {
            if (presenter.readFile() != null) {
                presenter.setCustomPath(filePath);
                presenter.readFile();
                presenter.getHumansListInfo();
                System.out.println("Данные успешно импортированы из файла: " + filePath);
            } else {
                System.out.println("Ошибка при импорте данных. Используются текущие данные.");
            }
        } else {
            System.out.println("Указанный файл недействителен или не существует.");
        }
    }

    // Добавил возможность пользователю изменить путь к файлу семейного древа
    public void setCustomPath() {
        System.out.print("Введите путь к директории для сохранения данных (например, C:\\Users\\User\\Documents): ");
        String directoryPath = scanner.nextLine();

        System.out.print("Введите имя файла (например, family_tree.out): ");
        String fileName = scanner.nextLine();

        String fullPath = Paths.get(directoryPath, fileName).toString();

        if (isValidDirectory(directoryPath)) {
            presenter.setCustomPath(fullPath);
            System.out.println("Путь для сохранения данных изменен на: " + presenter.getPath());
        } else {
            System.out.println("Указанный путь недействителен или не существует. Используется текущий путь: " + presenter.getPath());
        }
    }

    // Показать текущий путь к файлу, с которым работаем
    public void showCurrentFilePath() {
        System.out.println("Сейчас используется файл по этому пути: " + presenter.getPath());
    }

    // Преобразование строки (выбор пользователя) в long
    private long strNumToLong(String choiceStr) {
        try {
            return Long.parseLong(choiceStr);
        } catch(NumberFormatException e){
            return -1;
        }
    }

    // Преобразование строки (выбор пользователя) в int
    private int strNumToInt(String choiceStr) {
        try {
            return Integer.parseInt(choiceStr);
        } catch(NumberFormatException e){
            return -1;
        }
    }

    private boolean searchIdHuman(long idHuman) {
        return getHumanById(idHuman) != null;
    }

    // Проверка на валидность выбора пункта Главного меню
    private boolean isNumMainMenu(int choice) {
        if (choice > 0 && choice <= mainMenu.size()){
            return true;
        }
        return false;
    }

    // Проверка на валидность выбора пункта Меню сортировки
    private boolean isNumSortMenu(int choice) {
        if (choice > 0 && choice <= sortMenu.size()){
            return true;
        }
        return false;
    }

    // Проверка на валидность выбора пункта Меню по работе с файлами
    private boolean isNumFileMenu(int choice) {
        if (choice > 0 && choice <= fileMenu.size()){
            return true;
        }
        return false;
    }

    private Human getHumanById(long idHuman) {
        return presenter.getHumanById(idHuman);
    }

    // Проверка на валидность дериктории
    private boolean isValidDirectory(String path) {
        try {
            Path p = Paths.get(path);
            return Files.exists(p) && Files.isDirectory(p);
        } catch (Exception e) {
            return false;
        }
    }

    // Проверка на валидность файла
    private boolean isValidFile(String path) {
        try {
            Path p = Paths.get(path);
            return Files.exists(p) && Files.isRegularFile(p);
        } catch (Exception e) {
            return false;
        }
    }

    private void inputIdError() {
        System.out.println(INPUT_ID_ERROR);
    }

    // Проверка на наличие дефолтного familyTree файла и его создание, если он отсутствует
    private void checkAndOrCreateDefaultFile() {
        File defaultFile = new File(presenter.getPath());
        if (!defaultFile.exists()) {
            try {
                // Создаем новый файл
                if (defaultFile.createNewFile()) {
                    System.out.println("\nСоздан файл по умолчанию для семейного древа: " + presenter.getPath());
                } else {
                    System.out.println("\nНе удалось создать файл по умолчанию: " + presenter.getPath());
                }
            } catch (IOException e) {
                System.out.println("\nОшибка при создании файла: " + presenter.getPath());
                e.printStackTrace();
            }
        } else {
            System.out.println("\nФайл по умолчанию для семейного древа уже существует: " + presenter.getPath());
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
