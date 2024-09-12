package view;

import model.human.Gender;
import model.human.Human;
import presenter.Presenter;

import java.security.PublicKey;
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
            //System.out.println("1. Добавить человека");
            //System.out.println("2. Вывести список людей");
            //System.out.println("3. Сортировка");
            //System.out.println("4. Сохранить/восстановить");
            //System.out.println("5. Выход");

            //выбор человека
            //инфо о человеке
            //добавить родственную связь-- добавить родителя, ребенка, брата/сестру
            //установить дату смерти
            //отсортировать дерево-- по ID, по имени, по возрасту
            // загрузить/сохранить дерево
            //загрузить тестовый список
            //распечатать дерево
            //очистить дерево
            //завершить работу


        }

    }
    private void error(){
        System.out.println("Неверный выбор");
    }
    public void addHuman(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол: MALE/FEEMALE");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Введите дату рождения: ");
        LocalDate birthday = LocalDate.parse(scanner.nextLine());
        //TODO а если не gender и не LocalDate, дописать
    }
    public Human findHuman(int id){
        return presenter.getById(id);
    }
    private void printTree(){
        presenter.printTree();
    }



    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }
}
