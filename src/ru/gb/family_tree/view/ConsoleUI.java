package ru.gb.family_tree.view;

import ru.gb.family_tree.model.FT.FamilyTree;
import ru.gb.family_tree.model.FT.FileHandler;
import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.model.Human.Human;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.presenter.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;
    private String filePath = "familyTree.txt";

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
        fileHandler = new FileHandler();
        try {
            familyTree = fileHandler.loadFamilyTree(filePath);
            System.out.println("Загруженное семейное древо: ");
            System.out.println(familyTree);
        } catch (IOException | ClassNotFoundException e) {
            familyTree = new FamilyTree<>();
            e.printStackTrace();
        }

        Service<Human> service = new Service<>(familyTree);
        presenter = new Presenter(this, service);
    }

    @Override
    public void start() {
        System.out.println("Привествую!");
        while (work){
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            //метод проверки данных на валидность
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
        }
    }

    public void addHuman() {
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Укажите пол (мужской/женский): ");
        String genderInput = scanner.nextLine().toLowerCase();
        Gender gender = Gender.valueOf(genderInput);
        System.out.println("Введите дату рождения (ГГГГ-ММ-ДД): ");
        String birthDateInput = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateInput);

        presenter.addHuman(lastName, name, gender, birthDate);
        getFamilyTree();
        saveFamilyTree();
        System.out.println("Человек добавлен в семейное древо: " + familyTree);
    }

    public void findHumanByName() {
        System.out.println("Введите имя человека для поиска: ");
        String nameHuman = scanner.nextLine();
        Human human = presenter.findHumanByName(nameHuman);
        if (human != null) {
            System.out.println("Найден член семьи: " + human);
        } else {
            System.out.println("Член семьи с таким именем не найден.");
        }
        getFamilyTree();
    }

    public void getFamilyTree() {
        presenter.getFamilyTree();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
        getFamilyTree();
    }

    public void sortByName() {
        presenter.sortByName();
        getFamilyTree();
    }

    public void finish() {
        saveFamilyTree();
        System.out.println("До новых встреч!");
        work = false;
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void saveFamilyTree() {
        try {
            fileHandler.saveFamilyTree(familyTree, "familyTree.txt");
            System.out.println("FamilyTree сохранено в файл " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
