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
    private Menu menu;
    private boolean work;
    private static final String inputErr = "Неверный ввод!";

    public ConsoleUi(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new Menu(this);
    }


    @Override
    public void start() {
        hellow();
        while (work){
            printMenu();
            execute();
        }
    }

    //распечатать дерево
    //выбор человека
    //инфо о человеке
    //добавить родственную связь-- добавить родителя, ребенка, брата/сестру
    //установить дату смерти
    //отсортировать дерево-- по ID, по имени, по возрасту
    // загрузить/сохранить дерево
    //загрузить тестовый список
    //очистить дерево
    //завершить работу

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if(checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if(text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if(numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    public void finish(){
        System.out.println("РАБОТА ЗАВЕРШЕНА");
        work = false;
    }
    private void inputError(){
        System.out.println(inputErr);
    }
    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void hellow(){
        System.out.println("--== СЕМЕЙНОЕ ДЕРЕВО 1.0 ==--");
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
