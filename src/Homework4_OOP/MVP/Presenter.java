package Homework4_OOP.MVP;

import Homework4_OOP.FamilyTrees.FamilyTree;
import Homework4_OOP.Human.Gender;
import Homework4_OOP.Human.Human;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private final View view;
    private final FamilyTree<Human> tree;

    public Presenter(View view, FamilyTree<Human> tree) {
        this.view = view;
        this.tree = tree;
    }

    public void start() {
        boolean running = true;
        while (running) {
            view.displayMenu();
            int choice = view.getUserChoice();

            switch (choice) {
                case 1 -> addHuman();
                case 2 -> searchByName();
                case 3 -> removeById();
                case 4 -> printTree();
                case 5 -> {
                    view.displayMessage("Exiting...");
                    running = false;
                }
                default -> view.displayMessage("Invalid choice, please try again.");
            }
        }
    }

    private void addHuman() {
        String name = view.getUserInput("Введите имя: ");
        String gender = view.getUserInput("Выберете пол человека (Male/Female): ");
        String birthDateStr = view.getUserInput("Введите год рождения (yyyy-mm-dd): ");
        LocalDate birthDate = LocalDate.parse(birthDateStr);

        Human human = new Human(name, Gender.valueOf(gender), birthDate);
        tree.add(human);
        view.displayMessage("Вы добавили человека");
    }

    private void searchByName() {
        String name = view.getUserInput("Введите имя для поиска: ");
        List<Human> results = tree.getByName(name);
        if (results.isEmpty()) {
            view.displayMessage("Человека с таким именем не найдено: " + name);
        } else {
            view.displayHumans(results);
        }
    }

    private void removeById() {
        long id = Long.parseLong(view.getUserInput("Введите ID: "));
        boolean result = tree.remove(id);
        if (result) {
            view.displayMessage("Вы удалили человека");
        } else {
            view.displayMessage("Человека с таким ID нет: " + id);
        }
    }

    private void printTree() {
        view.displayMessage(tree.getInfo());
    }
}
