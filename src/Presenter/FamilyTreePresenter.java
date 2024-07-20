package Presenter;

import java.time.LocalDate;
import java.util.Scanner;

import FamilyTree.FamilyTree;
import Human.Gender;
import Human.Human;
import View.FamilyTreeView;
import Writer.Writer;
import Writer.FamilyTreeFileHandler;

public class FamilyTreePresenter {
    private final FamilyTree<Human> familyTree;
    public FamilyTreeView view;
    private final Scanner scanner;
    private boolean work;

    public FamilyTreePresenter(FamilyTree<Human> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
        this.scanner = new Scanner(System.in);
        this.work = true;
        
    }

    public void setView(FamilyTreeView view) {
        this.view = view;
    }


    public void onAddHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human father, Human mother) {
        Human human = new Human(familyTree.getNextId(), name, birthDate, deathDate, gender, father, mother);
        familyTree.addElement(human);
    }

    public void onSortByName() {
        familyTree.sortByName();
        view.showFamilyTree(familyTree.getAllElements());
    }

    public void onSortByBirthDate() {
        familyTree.sortByBirthDate();
        view.showFamilyTree(familyTree.getAllElements());
    }

    public void onSortByAge() {
        familyTree.sortByAge();
        view.showFamilyTree(familyTree.getAllElements());
    }

    public void onSave(Writer fileHandler, String filename) {
        fileHandler.setPath(filename);
        fileHandler.save(familyTree);
        view.displayMessage("Дерево сохранено в файл: " + filename);
    }

    public void onLoad(Writer fileHandler) {
        FamilyTree<?> loadedTree = fileHandler.read();
        if (loadedTree != null) {
            this.familyTree.clear();
            for (Object element : loadedTree.getAllElements()) {
                if (element instanceof Human) {
                    familyTree.addElement((Human) element);
                }
            }
            view.displayMessage("Дерево загружено из файла.");
            view.showFamilyTree(familyTree.getAllElements());
        } else {
            view.displayMessage("Не удалось загрузить дерево.");
        }
    }

    public void onUserInput() {
        System.out.println("Здравствуйте!");

        while (work) {
            System.out.println("1. Добавить члена семьи");
            System.out.println("2. Вывести дерево на печать");
            System.out.println("3. Отсортировать по имени");
            System.out.println("4. Отсортировать по возрасту");
            System.out.println("5. Отсортировать по дате рождения");
            System.out.println("6. Сохранить в файл");
            System.out.println("7. Выгрузить из файла");
            System.out.println("8. Выход");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    addHuman();
                    break;
                case "2":
                    view.showFamilyTree(familyTree.getAllElements());
                    break;
                case "3":
                    onSortByName();
                    break;
                case "4":
                    onSortByAge();
                    break;
                case "5":
                    onSortByBirthDate();
                    break;
                case "6":
                    save();
                    break;
                case "7":
                    load();
                    break;
                case "8":
                    finish();
                    break;
                default:
                    view.showError("Неизвестная команда: " + input);
            }
        }
    }

    private void finish() {
        work = false;
        scanner.close();
    }

    private void addHuman() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите дату рождения (YYYY-MM-DD):");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Введите дату смерти (если есть) (YYYY-MM-DD):");
        String deathDateInput = scanner.nextLine();
        LocalDate deathDate = deathDateInput.isEmpty() ? null : LocalDate.parse(deathDateInput);

        System.out.println("Введите пол (Male/Female):");
        Gender gender = Gender.valueOf(scanner.nextLine());

        System.out.println("Введите имя отца (если есть):");
        String fatherName = scanner.nextLine();
        Human father = familyTree.findByName(fatherName);

        System.out.println("Введите имя матери (если есть):");
        String motherName = scanner.nextLine();
        Human mother = familyTree.findByName(motherName);

        onAddHuman(name, birthDate, deathDate, gender, father, mother);
    }

    private void save() {
        System.out.println("Введите имя файла для сохранения:");
        String filename = scanner.nextLine();
        Writer fileHandler = new FamilyTreeFileHandler();
        onSave(fileHandler, filename);
    }

    private void load() {
        System.out.println("Введите имя файла для загрузки:");
        String filename = scanner.nextLine();
        Writer fileHandler = new FamilyTreeFileHandler();
        fileHandler.setPath(filename);
        onLoad(fileHandler);
    }
    
    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public Human findByName(String name) {
        return familyTree.findByName(name);
    }
}
