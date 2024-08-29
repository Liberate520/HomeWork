package view;

import model.human.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUi implements View{

    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUi(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);

    }


    @Override
    public void start() {
        while (true){
            System.out.println("1. Добавить человека");
            System.out.println("2. Вывести список людей");
            System.out.println("3. Сортировка");
            System.out.println("4. Сохранить/восстановить");
            System.out.println("5. Выход");

            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    addHuman();
                    break;
                case "2":
                    printTree();
                    break;
                case "3"://TODO вложенные меню на сортировку и сохр.восст
                    break;
                case "4":
                    break;
                case "5":
                    break;
                default: error();

            }


        }

    }
    private void error(){
        System.out.println("Неверный выбор");
    }
    private void addHuman(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол: MALE/FEEMALE");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Введите дату рождения: ");
        LocalDate birthday = LocalDate.parse(scanner.nextLine());
        //TODO а если не gender и не LocalDate, дописать
    }
    private void printTree(){
        presenter.printTree();
    }



    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }
}
