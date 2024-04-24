package family_tree.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import family_tree.model.human.Gender;
import family_tree.model.writer.Writable;
import family_tree.presenter.Presenter;

public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;
    private boolean flag;
    private MainMenu mainMenu;

    public ConsoleUI(Writable<?> fileHandler) { 
        this.scanner = new Scanner(System.in);
        flag = true;
        mainMenu = new MainMenu(this);
        presenter = new Presenter(this, fileHandler);
    }

    @Override
    public void displayFamilyTree(String familyTreeInfo) {
        System.out.println("Текущее семейное дерево:");
        System.out.println(familyTreeInfo);
    }

    @Override
    public void start() {
        hello();
        while (flag) {
            System.out.println(mainMenu.getMenu());
            String strChoice = scanner.nextLine();
            try {
                int choice = Integer.parseInt(strChoice);
                if (choice >= 1 && choice <= mainMenu.getCommandsSize()) {
                    mainMenu.execute(choice);
                } else {
                    System.out
                            .println("Неверный выбор. Пожалуйста, введите число от 1 до " + mainMenu.getCommandsSize());
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите число.");
            }
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);

    }

    private void hello() {
        System.out.println("Приветствую! Выберите действие: ");
    }

    public void finish() {
        System.out.println("До свидания!");
        flag = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void addHuman() {
        System.out.println("Укажите имя человека:");
        String name = scanner.nextLine();

        System.out.println("Укажите дату рождения человека (гггг-мм-дд):");
        String strDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(strDate);

        System.out.println("Укажите пол человека (Male/Female):");
        String strGender = scanner.nextLine();
        strGender = strGender.substring(0, 1).toUpperCase() + strGender.substring(1).toLowerCase();
        Gender gender;
        try {
            gender = Gender.valueOf(strGender);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверно указан пол. Допустимые значения: Male или Female.");
            return;
        }

        presenter.createAndAddHuman(name, gender, date);
    }

    public void loadTreeFromFile() {
        presenter.loadFamilyTree();
    }

    public void saveTreeToFile() {
        boolean success = presenter.saveFamilyTree();
        if (success) {
            System.out.println("Дерево успешно сохранено в файл.");
        } else {
            System.out.println("Не удалось сохранить дерево в файл.");
        }
    }

    public void addCreateRelationshipsCommand() {
        System.out.println("Введите имя мужа:");
        String husbandName = scanner.nextLine();
        if (!presenter.doesHumanExist(husbandName)) {
            System.out.println("Муж с именем " + husbandName + " не найден.");
            return;
        }
    
        System.out.println("Введите имя жены:");
        String wifeName = scanner.nextLine();
        if (!presenter.doesHumanExist(wifeName)) {
            System.out.println("Жена с именем " + wifeName + " не найдена.");
            return;
        }
    
        List<String> childrenNames = new ArrayList<>();
        String childName;
        do {
            System.out.println("Введите имя ребенка (или оставьте строку пустой, чтобы закончить):");
            childName = scanner.nextLine();
            if (!childName.isEmpty()) {
                if (presenter.doesHumanExist(childName)) {
                    childrenNames.add(childName);
                } else {
                    System.out.println("Ребенок с именем " + childName + " не найден.");
                }
            }
        } while (!childName.isEmpty());
    
        if (!childrenNames.isEmpty()) {
            presenter.createRelationships(husbandName, wifeName, childrenNames);
        }
    }
}