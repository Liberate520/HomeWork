// FamilyTreeView.java
package ru.gb.family_tree.view;

import java.util.Scanner;
import ru.gb.family_tree.Human;
import ru.gb.family_tree.presenter.FamilyTreePresenter;

public class FamilyTreeView implements View {
    
    private static final String INPUT_ERROR = "\nInvalid input";
    private FamilyTreePresenter presenter;
    private boolean work;
    private Scanner scanner;
    private MainMenu menu;
    
    
    public FamilyTreeView() {
        this.presenter = new FamilyTreePresenter(this);
        this.work = true;
        scanner = new Scanner(System.in);
        menu = new MainMenu(this);
    }

    @Override
    public void display(String data) {
        System.out.println(data);
    }
    
    @Override
    public void run() {
        // Инициализация примера
        presenter.initializeFamilyTree();

        hello();
        while (work){
            printMenu();
            execute();
        }
        
    }

    private void hello() {
        display("Hello!");
    }

    /*
     * Отображение полного дерева
     */
    public void showTree() {
        display("Full family tree:");
        display(presenter.getFamilyTree());
    }
    /*
     * Сортировка и отображение по имени
     */
    public void sortByName() {
        
        presenter.sortByName();
        display("\nSorted by name:");
        display(presenter.getFamilyTree());        
    }
    /*
     * Сортировка и отображение по дате рождения
     */
    public void sortByBirthDate() {
        presenter.sortByBirthDate();
        display("\nSorted by birth date:");
        display(presenter.getFamilyTree());        
    }
    /*
     * Пример использования поиска и получения детей
     */
    public void showChildren() {
        
        Human foundFather = presenter.findByFullName("John Michael Doe");
        if (foundFather != null) {
            display("\nChildren and descendants of " + foundFather.getFullName() + ":");
            display(presenter.getChildren(foundFather));
        } else {
            display("Father not found.");
        }
    }

    public void finish() {
        display("See you");
        work = false;
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        display(menu.menu());
    }

    private void inputError(){
        display(INPUT_ERROR);
    }}
