package Family_Tree.view;

import Family_Tree.model.Human.Gender;
import Family_Tree.presenter.Presenter;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
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
            System.out.println("Добавить человека 4");
            System.out.println("Выход 5");
            String choice = scanner.nextLine();
            switch (choice) {
//                case "1":
//                    System.out.println("Введите имя человека");
//                    String name=scanner.nextLine();
//                    System.out.println("Введите возраст человека");
//                    String strAge=scanner.nextLine();
//                    int age=Integer.parseInt(strAge);

                case "1":
                    presenter.getInf();
                    break;
                case "2":
                    presenter.sortByAge();
                    break;
                case "3":
                    presenter.sortByName();
                    break;
                case "4":
                    System.out.println("Введите имя: ");
                    String name = scanner.nextLine();

                    System.out.println("Введите возраст человека ");
                    Integer age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Введите пол человека: ");
                    String gend = scanner.nextLine();
                    if(Objects.equals(gend, "Женщина")) {
                        Gender gender = Gender.Female;
//                        NewHuman(name, age, gender);
                        presenter.addHuman(name, age, gender);
                    }
                    else if(Objects.equals(gend, "Мужчина")){
                        Gender gender = Gender.Male;
//                        NewHuman(name, age, gender);
                        presenter.addHuman(name, age, gender);
                    }
                    else {
                        System.out.println("Введите: Мужчина или Женщина");
                    }
                    break;
                case "5":
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
//    public void NewHuman(String name, Integer age, Gender gender) {
//        Human human = new Human(name, age, gender);
//    }


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
