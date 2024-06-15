
package com.familytree.view;

import com.familytree.model.animal.Dog;
import com.familytree.model.family_tree.FamilyTreeModel;
import com.familytree.model.family_tree.TreeNode;
import com.familytree.model.human.Human;
import com.familytree.presenter.FamilyTreePresenter;
import com.familytree.view.commands.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private FamilyTreePresenter<TreeNode> familyTreePresenter;
    private boolean work;
    private List<Command> commands;

    public ConsoleUI(FamilyTreeModel<TreeNode> model) {
        this.familyTreePresenter = new FamilyTreePresenter<>(model, this);
        this.scanner = new Scanner(System.in);
        this.work = true;
        this.commands = new ArrayList<>();
        initCommands();
    }

    private void initCommands() {
        commands.add(new AddHuman(this));
        commands.add(new AddDog(this));
        commands.add(new GetHumanListInfo(this));
        commands.add(new SortByName(this));
        commands.add(new SortByBirthDate(this));
        commands.add(new Finish(this));
    }

    public void start() {
        System.out.println("Приветствую!");

        // Загружаем и выводим список при старте программы
        printHumanList(familyTreePresenter.getNodes());

        while (work) {
            System.out.println("Выберите команду:");
            for (int i = 0; i < commands.size(); i++) {
                System.out.println((i + 1) + ". " + commands.get(i).getDescription());
            }
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr) - 1;
            if (choice >= 0 && choice < commands.size()) {
                commands.get(choice).execute();
            } else {
                System.out.println("Неверный выбор");
            }
        }
    }

    public void finish() {
        work = false;
        System.out.println("До новых встреч!");
    }

    public void addHuman() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите дату рождения (в формате dd.MM.yyyy)");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        Human human = new Human(name, birthDate);
        familyTreePresenter.addHuman(human);
    }

    public void addDog() {
        System.out.println("Укажите имя собаки");
        String name = scanner.nextLine();
        System.out.println("Укажите породу собаки");
        String breed = scanner.nextLine();

        Dog dog = new Dog(name, breed);
        familyTreePresenter.addDog(dog);
    }

    public void printHumanList(List<TreeNode> nodes) {
        if (nodes.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (TreeNode node : nodes) {
                if (node instanceof Human) {
                    Human human = (Human) node;
                    System.out.println("Имя: " + human.getName() + ", Дата рождения: " + human.getBirthDate());
                } else if (node instanceof Dog) {
                    Dog dog = (Dog) node;
                    System.out.println("Имя: " + dog.getName() + ", Порода: " + dog.getBreed());
                }
            }
        }
    }

    public void sortByName() {
        familyTreePresenter.sortByName();
        System.out.println("Список отсортирован по имени");
        printHumanList(familyTreePresenter.getNodes()); // Выводим отсортированный список
    }

    public void sortByBirthDate() {
        familyTreePresenter.sortByBirthDate();
        System.out.println("Список отсортирован по дате рождения");
        printHumanList(familyTreePresenter.getNodes()); // Выводим отсортированный список
    }

    @Override
    public void updateView() {

    }

    @Override
    public void displayNodes(TreeNode[] nodes) {

    }

    @Override
    public FamilyTreePresenter<TreeNode> getFamilyTreePresenter() {
        return familyTreePresenter;
    }
}
