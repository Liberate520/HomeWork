package view;

import model.person.Gender;
import model.person.Human;
import presenter.Presenter;

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

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void save() {
        presenter.saveFile();
        System.out.println("Экспорт завершен успешно");
    }

    public void read() {
        presenter.readFile();
        System.out.println("Импорт данных выполнен");
    }

    private void inputIdError() {
        System.out.println(INPUT_ID_ERROR);
    }
}
