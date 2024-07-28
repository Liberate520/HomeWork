package view;

import model.person.Gender;
import model.person.Human;
import presenter.Presenter;

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
    private MainMenu menu;
    Gender gender;
    private static final String INPUT_ID_ERROR = "Человека нет с таким ID";

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        greeting();
        while (work) {
            System.out.println(menu.showMenu());
            System.out.println("Введите пункт меню (число):");
            String choiceStr = scanner.nextLine();
            int choice = strNumToInt(choiceStr);
            if (isNumMenu(choice)) {
                menu.execute(choice);
            } else {
                System.out.println("Неверный ввод. Попробуйте еще раз");
            }
        }
    }

    public void finish() {
        presenter.saveFile();
        scanner.close();
        work = false;
        System.out.println("Пока-пока, программа закрылась!");
    }

    private void greeting() {
        System.out.println("Программа запустилась.\nДобро пожаловать в программу для создания Вашего семейного древа!");
    }

    public void addHuman() {
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
        int idParent = strNumToInt(idParentStr);

        if (searchIdHuman(idParent)){
            System.out.println("Введите ID ребенка:");
            String idChildStr = scanner.nextLine();
            int idChild = strNumToInt(idChildStr);

            if (searchIdHuman(idChild)){
                presenter.addChildToParent(idParent, idChild);
            }else{inputIdError();}

        }else{inputIdError();}
    }

    public void getHumanBirthDate() {
        System.out.println("Введите ID челоека:");
        String choiceStr = scanner.nextLine();
        int idHuman = strNumToInt(choiceStr);
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
        int idHuman = strNumToInt(idHumanStr);
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
        long id1 = Long.parseLong(scanner.nextLine());
        if (searchIdHuman(id1)) {
            System.out.println("Введите ID невесты: ");
            long id2 = Long.parseLong(scanner.nextLine());

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
        long id1 = Long.parseLong(scanner.nextLine());
        if (searchIdHuman(id1)) {
            System.out.println("Введите ID жены: ");
            long id2 = Long.parseLong(scanner.nextLine());

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
        int idFather = strNumToInt(idFatherStr);

        if (searchIdHuman(idFather)){
            System.out.println("Укажите ID ребенка:");
            String idChildStr = scanner.nextLine();
            int idChild = strNumToInt(idChildStr);

            if (searchIdHuman(idChild)){
                presenter.setFather(idChild, idFather);
            }else{inputIdError();}

        }else{inputIdError();}
    }

    public void setMother() {
        System.out.println("Укажите ID мамы:");
        String idMotherStr = scanner.nextLine();
        int idMother = strNumToInt(idMotherStr);

        if (searchIdHuman(idMother)){
            System.out.println("Укажите ID ребенка:");
            String idChildStr = scanner.nextLine();
            int idChild = strNumToInt(idChildStr);

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

    private boolean isNumMenu(int choice) {
        if (choice > 0 && choice <= menu.size()){
            return true;
        }
        return false;
    }

    private Human getHumanById(long idHuman) {
        return presenter.getHumanById(idHuman);
    }

    public void save() {
        presenter.saveFile();
        System.out.println("Данные успешно сохранены в: " + presenter.getPath());
    }

    public void read() {
        presenter.readFile();
        System.out.println("Данные успешно импортированы из: " + presenter.getPath());
    }

    // Добавил возможность пользователю изменениять пути к файлу семейного древа
    public void setCustomPath() {
        System.out.println("Текущий путь для сохранения данных: " + presenter.getPath());

        System.out.print("Введите путь к директории для сохранения данных (например, C:\\Users\\User\\Documents): ");
        String directoryPath = scanner.nextLine();

        System.out.print("Введите имя файла (например, family_tree.out): ");
        String fileName = scanner.nextLine();

        String fullPath = Paths.get(directoryPath, fileName).toString();

        if (!directoryPath.isEmpty() && isValidDirectory(directoryPath)) {
            presenter.setCustomPath(fullPath);
            System.out.println("Путь для сохранения данных изменен на: " + presenter.getPath());
            save();
        } else {
            System.out.println("Указанный путь недействителен или не существует. Используется текущий путь: " + presenter.getPath());
        }
    }

    // Проверка на авлидность дериктории
    private boolean isValidDirectory(String path) {
        try {
            Path p = Paths.get(path);
            return Files.exists(p) && Files.isDirectory(p);
        } catch (Exception e) {
            return false;
        }
    }

    // Получение текущей дериктории
    public void getCurrentPath() {
        System.out.println("Текущий путь для сохранения данных: " + presenter.getPath());
    }

    private void inputIdError() {
        System.out.println(INPUT_ID_ERROR);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
