package View;

import Model.Human.Gender;
import Presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
//    Scanner scanner;
    Presenter presenter;
    MainMenu mainMenu;
//    boolean work;

    public ConsoleUI(){
//        scanner = new Scanner((System.in));
        presenter = new Presenter();
//        work = true;
         this.mainMenu = new MainMenu();
    }

    @Override
    public void startMenu() {
//        while(work) {
            System.out.println("Выберите пункт меню:");
            System.out.println(mainMenu.toString());

//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//                    System.out.println("Семейное дерево:" + getFamilyTreeInfo());
//                    break;
//                case 2:
//                    System.out.println("Дерево отсортировано по имени");
//                    sortByName();
//                    break;
//                case 3:
//                    addtoTree();
//                    System.out.println("Добавлен в дерево");
//                    break;
//                case 4:
//                    System.out.println("Работа завершена");
//                    work=false;
//                    break;
//                default:
//                    System.out.println("Выбран неверный пункт меню");
//                    break;
//            }
        }
    }

//    void addtoTree(){
//        System.out.println("Введите имя:");
//        String name = scanner.nextLine();
//        System.out.println("Вы ввели имя:" + name);
//        System.out.println("Введите пол (male/female:");
//        String gender = scanner.nextLine();
//        System.out.println("Вы ввели возраст:" + gender);
//        System.out.println("Введите дату рождения (в формате ГГГГ-ММ-ДД):");
//        String dobInput = scanner.nextLine();
//        LocalDate dob = LocalDate.parse(dobInput);
//        System.out.println("Вы ввели дату рождения:" + dob);
//        presenter.addToTree(name, Gender.valueOf(gender), dob);
//    }

//    String getFamilyTreeInfo(){
//        return presenter.getFamilyTreeInfo();
//    }

//    void sortByName(){
//        presenter.sortByName();
//    }

//    @Override
//    public void execute() {
//
//    }

