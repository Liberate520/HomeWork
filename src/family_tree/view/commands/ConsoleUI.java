package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Введено неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    public void start() {
        System.out.println("Приветствие!");
        while (work){
            System.out.println(menu.menu());
            String strChoice = scanner.nextLine();
            int choice = Integer.parseInt(strChoice);
            menu.execute(choice);
        }
    }

    public void finish() {
        System.out.println("До новых встреч!");
        work = false;
    }

    public void getFamilyTreeInfo(){
        presenter.getFamilyTreeInfo();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void addParent(){
        presenter.getFamilyTreeInfo();
        int childId, parentId;
        printAnswer("Введите id ребёнка");
        childId = Integer.parseInt(scanner.nextLine());
        printAnswer("Введите id родителя");
        parentId = Integer.parseInt(scanner.nextLine());

        presenter.addParent(childId, parentId);
    }

    public void addChild(){
        presenter.getFamilyTreeInfo();
        int childId, parentId;
        printAnswer("Введите id родителя");
        parentId = Integer.parseInt(scanner.nextLine());
        printAnswer("Введите id ребёнка");
        childId = Integer.parseInt(scanner.nextLine());
        presenter.addChild(parentId, childId);
    }
    public void inputError(){
        printAnswer(INPUT_ERROR);
    }

    public void addHuman(){
        String name;
        Gender gender;
        LocalDate birthDate;
        String strFormatter = "dd.MM.yyyy";
        printAnswer("Введите имя:");
        name = scanner.nextLine();
        printAnswer("Укажите пол\n1 - мужской, 2 - женский");
        String sex = scanner.nextLine();
        while (!(sex.charAt(0) == '1' || sex.charAt(0) == '2')) {
            inputError();
            printAnswer("Укажите пол\n1 - мужской, 2 - женский");
            sex = scanner.nextLine();
        }
        if (sex.equals("1"))
            gender = Gender.Male;
        else
            gender = Gender.Female;

        printAnswer("Введите дату рождения в формате " + strFormatter);
        String strDate = scanner.nextLine();
        while (strDate.length() != 10 && strDate.split(".").length != 3) {
            inputError();
            printAnswer("Введите дату рождения в формате " + strFormatter);
            strDate = scanner.nextLine();
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(strFormatter);
        birthDate = LocalDate.parse(strDate, dateTimeFormatter);
        presenter.addHuman(name, gender, birthDate);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}