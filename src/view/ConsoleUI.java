package view;

import model.human.Gender;
import presenter.Presenter;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean isWork;
    private MainMenu menu;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        isWork = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        hello();
        while (isWork){
            printMenu();
            execute();
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void addHuman() {
        String name;
        Gender gender;
        int day,month,year;
        LocalDate birthDate;
        printAnswer("Введите имя:");
        name = scanner.nextLine();
        printAnswer("Укажите пол\n1 - мужской, 2- женский");
        String sex = scanner.nextLine();
        while (!(sex.charAt(0)=='1' || sex.charAt(0)=='2')){
            printAnswer("Укажите пол\n1 - мужской, 2- женский");
            sex = scanner.nextLine();
        }
        if (sex.equals("1"))
            gender = Gender.Male;
        else
            gender = Gender.Female;

        printAnswer("Введите дату рождения в формате dd mm yyyy");
        String strDate = scanner.nextLine();
        while (strDate.length()!= 10 && strDate.split(" ").length != 3 ){
            printAnswer("Введите дату рождения в формате dd mm yyyy");
            strDate = scanner.nextLine();
        }
        String[] arrDate = strDate.split(" ");
        day = Integer.parseInt(arrDate[0]);
        month = Integer.parseInt(arrDate[1]);
        year = Integer.parseInt(arrDate[2]);
        birthDate = LocalDate.of(year,month,day);
        presenter.addHuman(name,gender,birthDate);
    }

    private void hello(){
        printAnswer("Доброго времени суток!");
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }
    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        printAnswer(menu.menu());
    }

    private void inputError(){
        printAnswer(INPUT_ERROR);
    }

    public void finish() {
        printAnswer("Все го хо ро ше го");
        isWork = false;
    }

    public void addParent() {
        printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
        String choice = scanner.nextLine();
        while (!presenter.addParent(choice)){
            printAnswer("Что-то пошло не так :(\nпопробуйте ещё раз");
            printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
            choice = scanner.nextLine();
        }
        presenter.getFamilyTreeInfo();
    }
    public void addChild(){
        printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
        String choice = scanner.nextLine();
        while (!presenter.addChild(choice)){
            printAnswer("Что-то пошло не так :(\nпопробуйте ещё раз");
            printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
            choice = scanner.nextLine();
        }
        presenter.getFamilyTreeInfo();
    }

    public void getFamilyTreeinfo() {
        presenter.getFamilyTreeInfo();
    }
}
