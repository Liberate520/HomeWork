package family_tree.view;

import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private boolean work;
    private Presenter presenter;
    private Menu menu;
    public ConsoleUI(){
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        menu = new Menu(this);
    }
    @Override
    public void start() {
        System.out.println("Приветствие");
        while(work){
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
        }

    }

    public void addHuman(){
        Boolean genders = true;
        String gender = "";
        System.out.println("Введите имя");
        String firstName = scanner.nextLine();
        System.out.println("Фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Отчество");
        String patronymic = scanner.nextLine();
        System.out.println("Пол М/Ж");
        while (genders) {
            gender = scanner.nextLine();
            if (gender.equals("М")) {
                gender = "Male";
                genders = false;
            } else if (gender.equals("Ж")) {
                gender = "Female";
                genders = false;
            } else System.out.println("Не верно введен пол");
        }
        System.out.println("Дата в формате 1980-01-22");

        String date = scanner.nextLine();
        LocalDate  birthDate = LocalDate.parse(date);
        
        presenter.addHuman(firstName,patronymic,lastName, gender, birthDate);
    }


    public void getFamilyTreeInfo(){
        presenter.getFamilyTreeInfo();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByBirthday(){
        presenter.sortByBirthday();
    }


    public void finish(){
        work = false;
        scanner.close();
        System.out.println("Спасибо за внимание");
    }


    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
