package seminar2.View.commands;

import seminar2.model.Human.Gender;
import seminar2.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }


    @Override
    public void start() {
        System.out.println("Приветстую!");

        while(work){
//            System.out.println("1. Добавить родственника.");
//            System.out.println("2. Вывести родственника по имени и фамилии.");
//            System.out.println("3. Вывести членов одной семьи.");
//            System.out.println("4. Получить информацию о семейном древе.");
//            System.out.println("5. Отсортировать по имени.");
//            System.out.println("6. Отсортировать по фамилии.");
//            System.out.println("7. Отсортировать по возрасту.");
//            System.out.println("8. Отсортировать по количеству детей.");
//            System.out.println("9. Выход из приложения.\n");
//
//            String choice = scanner.nextLine();
//
//            switch(choice){
//                case "1":
//                    addRelative();
//                    break;
//                case "2":
//                    getByNameSurname();
//                    break;
//                case "3":
//                    getByOneFamily();
//                    break;
//                case "4":
//                    getTreeInfo();
//                    break;
//                case "5":
//                    sortByName();
//                    break;
//                case "6":
//                    sortBySurname();
//                    break;
//                case "7":
//                    sortByAge();
//                    break;
//                case "8":
//                    System.out.println("***");
//                    break;
//                case "9":
//                    finish();
//                    break;
//                default:
//                    System.out.println("Неправильный ввод. Повторите.\n");
//            }

            System.out.println(mainMenu.menu());
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            mainMenu.execute(choice);
        }



    }

    public void finish() {
        work = false;
        System.out.println("Работа приложения окончена.");
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortBySurname() {
        presenter.sorBySurname();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getTreeInfo() {
        presenter.getTreeInfo();
    }

    public void getByOneFamily() {
        System.out.println("Укажите фамилию семьи: ");
        String surname = scanner.nextLine();
        presenter.getByOneFamily(surname);
    }

    public void getByNameSurname() {
        System.out.println("Укажите имя родственника: ");
        String name = scanner.nextLine();
        System.out.println("Укажите фамилию родственника: ");
        String surname = scanner.nextLine();
        presenter.getByNameSurname(name, surname);
    }


    public void addRelative(){
        System.out.println("Укажите имя родственника: ");
        String name = scanner.nextLine();
        System.out.println("Укажите фамилию родственника: ");
        String surname = scanner.nextLine();
        System.out.println("Укажите пол родственника: Male/female");
        String gender = scanner.nextLine();
        //Gender.valueOf(gender);
        System.out.println("Укажите год рожения родственника: ");
        int year_rel = scanner.nextInt();
        System.out.println("Укажите месяц рожения родственника: ");
        int month_rel = scanner.nextInt();
        System.out.println("Укажите день рожения родственника: ");
        int day_rel = scanner.nextInt();
        LocalDate dateOfBirth = LocalDate.of(year_rel, month_rel, day_rel);
        System.out.println(dateOfBirth);


        presenter.addRelative(name, surname, Gender.valueOf(gender), dateOfBirth);

    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
