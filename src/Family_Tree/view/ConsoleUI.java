package Family_Tree.view;

import Family_Tree.model.FamilyTree.FamilyTree;
import Family_Tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private FamilyTree familytree;
    private boolean work;

    public ConsoleUI(){
        scanner=new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }
    @Override
    public void start() {
        System.out.println("Добрый день! Выберите одно из следующих действий:");
        while (work) {
            System.out.println("Получить информацию о древе 1");
            System.out.println("Отсортировать по имени 2");
            System.out.println("Отсортировать по возрасту 3");
            System.out.println("Выход 4");
            String choice = scanner.nextLine();
            switch (choice) {
//                case "1":
//                    System.out.println("Введите имя человека");
//                    String name=scanner.nextLine();
//                    System.out.println("Введите возраст человека");
//                    String strAge=scanner.nextLine();
//                    int age=Integer.parseInt(strAge);

                case "1":
                    presenter.getInfo();
                    break;
                case "2":
                    presenter.sortByAge();
                    break;
                case "3":
                    presenter.sortByName();
                    break;
                case "4":
                    finish();
                    break;
                default:
                    System.out.println("Ошибка");
            }
        }
    }

    @Override
    public void PrintAnswer(String answer) {
        System.out.println(answer);
    }
    private void finish(){
        System.out.println("Конец работы!");
        work=false;
    }

//    private void getInfo() {
//        String answer = familytree.getInfo();
//        view.PrintAnswer(answer);
//    }
//
//    private void sortByAge(){
//        familytree.sortByAge();
//        getInfo();
//    }
//    private void sortByName(){
//        familytree.sortByName();
//        getInfo();
//    }
}
