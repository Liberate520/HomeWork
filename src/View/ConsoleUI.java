package View;


import Model.Human.Gender;
import Presenter.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException{
        System.out.println("Доброго времени суток");
        while (work){
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
        }
    }

    public void finish() {
        work = false;
        scanner.close();
        System.out.println("Завершение работы. До новых встреч.");
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    @Override
    public void answer(String answer) {
        System.out.println(answer);
    }

    public void addHuman(){
        System.out.println("Введите имя человека:");
        String name = scanner.nextLine();
        System.out.println("Вы ввели имя:" + name);
        System.out.println("Введите дату рождения в формате ГГГГ-ММ-ДД");
        String dateInput = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(dateInput);
        System.out.println("Вы ввели дату рождения:" + birthDate);
        System.out.println("Выберите пол: 1. Мужчина; 2. Женщина");
        String choice = scanner.nextLine();
        Gender gender = Gender.Male;
        boolean flag = true;
        while (flag) {
            switch (choice) {
                case "1":
                    gender = Gender.Male;
                    flag = false;
                    break;
                case "2":
                    gender = Gender.Female;
                    flag = false;
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
        }
        presenter.addHuman(name, birthDate, gender);
    }

    public void getFamilyTreeInfo(){
        presenter.getFamilyTreeInfo();
    }

    public void saveToFile() throws IOException{
        if(presenter.saveToFile()){
            System.out.println("Дерево сохранено\n");
        }
        getFamilyTreeInfo();
    }

    public void readFileFamilyTree() throws IOException, ClassNotFoundException{
        presenter.readFileFamilyTree();
        getFamilyTreeInfo();
    }

    public void addParent(){
        System.out.println("Введите id родителя:");
        long idParent = Long.parseLong(scanner.nextLine());
        System.out.println("Вы ввели Id:" + idParent);
        System.out.println("Введите id ребенка:");
        long idChild = Long.parseLong(scanner.nextLine());
        System.out.println("Вы ввели Id:" + idChild);
        if(presenter.addParent(idParent, idChild)){
            System.out.println("Родитель добавлен");
        }
        getFamilyTreeInfo();
    }

    public void addChild(){
        System.out.println("Введите id родителя:");
        long idParent = Long.parseLong(scanner.nextLine());
        System.out.println("Вы ввели Id:" + idParent);
        System.out.println("Введите id ребенка:");
        long idChild = Long.parseLong(scanner.nextLine());
        System.out.println("Вы ввели Id:" + idChild);
        if(presenter.addChild(idParent, idChild)){
            System.out.println("Ребенок добавлен");
        };
        getFamilyTreeInfo();
    }

}




// было до появления пакета с командами
//            System.out.println("1. Добавить человека");
//            System.out.println("2. Показать дерево");
//            System.out.println("3. Отсортировать по дате");
//            System.out.println("4. Отсортировать по имени");
//            System.out.println("5. Завершение работы");
//
//            String choice = scanner.nextLine();
//
//            switch (choice){
//                case "1":
//                    addHuman();
//                    break;
//                case "2":
//                    getFamilyTreeInfo();
//                    break;
//                case "3":
//                    sortByAge();
//                    break;
//                case "4":
//                    sortByName();
//                    break;
//                case "5":
//                    finish();
//                    break;
//                default:
//                    System.out.println("Введено неверное значение. Попробуйте еще раз.");
//            }