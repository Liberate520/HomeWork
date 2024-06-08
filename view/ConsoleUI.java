package OOP.SemDZ.homeWork.view;

import java.time.LocalDate;
import java.util.Scanner;

import OOP.SemDZ.homeWork.model.human.Gender;
import OOP.SemDZ.homeWork.presenter.Presenter;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work = true;

    public ConsoleUI () {
        scanner = new Scanner (System.in);
        work = true;
        presenter = new Presenter(this);
    }

    @Override
    public void start () {
        System.out.println("Hello");
        while (work){
            System.out.println("Выберите действие:");
            System.out.println("1: Добавить нового члена семьи");
            System.out.println("2: Показать семейное дерево");
            System.out.println("3: Отсортировать дерево по имени");
            System.out.println("4: Отсортировать дерево по возрасту");
            System.out.println("5: Завершение работы");

            String choise = scanner.nextLine();
            switch (choise) {
                case "1":
                    addHuman();
                    break;
                case "2":
                    printFamilyTree();
                    break;
                case "3":
                    sortByName();
                    break;
                case "4":
                    sortByAge();
                    break;
                case "5":
                    work = false;
                    break;
                    
            
                default:
                System.out.println("Неверное значение. Попробуйте еще раз.");
                
            }
        }

    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    private void printFamilyTree(){
        System.out.println(presenter.printFamilyTree());
    }

    private void addHuman(){

        System.out.println("Укажите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол (м/ж): ");
        String genderStr = scanner.nextLine();
        System.out.println("Введите дату рождения:");
        System.out.println("Число: ");
        String dateStr = scanner.nextLine();
        System.out.println("Месяц: ");
        String monthStr = scanner.nextLine();
        System.out.println("Год: ");
        String yearStr = scanner.nextLine();
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dateStr);

        presenter.addHuman(name, addGender(genderStr), LocalDate.of(year, month, day));
    }

    public Gender addGender (String genderStr){
        if (genderStr.equals("м")){
            return Gender.Male;
        }
        else return Gender.Female;      

    }

    @Override
    public void printAnswer(String answer){
        System.out.println(answer);        
    }
    

}
