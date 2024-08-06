package src.View;

import java.util.Scanner;

import src.Presenter.Presenter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;
    
    public ConsoleUI() throws SecurityException, IOException{
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() throws ClassNotFoundException, IOException {
        System.out.println("Здравствуйте!");             
        while(work){   
            showMenu();             
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);         
            mainMenu.run(choice);
        }
    }

    public void stop(){
        work = false;
        scanner.close();
    }

    private void showMenu() {
            System.out.println(mainMenu.menu());
    }

    public void getInfo (){
        presenter.getInfo();
    }

    public void addHuman (){
            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            System.out.println("Введите дату рождения (формат 'гггг-мм-дд'): ");
            LocalDate dateofbirth = LocalDate.parse(scanner.nextLine());
            System.out.println("Выберите пол \n 1 - Мужской \n 2 - Женский ");
            String gen = scanner.nextLine();
            String gender = null;
            switch(gen){
                case "1":
                gender = "male";
                break;
                case "2":
                gender = "female";
                break;
                default:
                System.out.println("Неверный ввод");
            }
            presenter.addHuman(name, dateofbirth, gender);
            System.out.println("Добавлен новый член семьи");
        }  

    public void getMember(){
        System.out.println("Введите имя ");        
        String name = scanner.nextLine();
        presenter.getMember(name);
    }

    public void addChild (){
        System.out.println("Введите имя ребенка");        
        String childName = scanner.nextLine();
        System.out.println("Введите имя родителя");
        String parentName = scanner.nextLine();
        presenter.addChildren(childName, parentName);
        // TODO Add ways to create a new entity or just add a name without an entity if the parent child doesn't extst yet
    }

    public void addParent (){
        System.out.println("Введите имя ребенка");        
        String childName = scanner.nextLine();
        System.out.println("Введите имя родителя");
        String parentName = scanner.nextLine();
        presenter.addParent(childName, parentName);
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByBirthday(){
        presenter.sortByBirthday();
    }

    public void sortByChildren(){
        presenter.sortByChildren();
    }

    public void load() throws ClassNotFoundException, IOException{
        presenter.load();
    }

    public void save() throws FileNotFoundException, IOException{
        presenter.save();
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
