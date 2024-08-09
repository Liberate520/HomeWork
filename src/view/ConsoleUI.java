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
            inputError();
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
            inputError();
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

    public void addParent() {
        printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
        String choice = scanner.nextLine();
        while (!presenter.addParent(choice)){
            inputError();
            printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
            choice = scanner.nextLine();
        }
        presenter.getFamilyTreeInfo();
    }
    public void addChild(){
        printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
        String choice = scanner.nextLine();
        while (!presenter.addChild(choice)){
            inputError();
            printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
            choice = scanner.nextLine();
        }
        presenter.getFamilyTreeInfo();
    }

    public void setWedding() {
        String name1,name2;
        int id1, id2;
        printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice < 1 || choice > 2){
            inputError();
            printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
            choice = Integer.parseInt(scanner.nextLine());
        }
        if (choice == 1){
            printAnswer("Введите первое имя");
            name1 = scanner.nextLine();
            printAnswer("Введите второе имя");
            name2 = scanner.nextLine();
            presenter.setWedding(name1,name2);
        }else{
            printAnswer("Введите первый id");
            id1 = Integer.parseInt(scanner.nextLine());
            printAnswer("Введите второй id");
            id2 = Integer.parseInt(scanner.nextLine());
            presenter.setWedding(id1, id2);
        }
    }
    public void setDivorce() {
        String name1,name2;
        int id1, id2;
        printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice < 1 || choice > 2){
            inputError();
            printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
            choice = Integer.parseInt(scanner.nextLine());
        }
        if (choice == 1){
            printAnswer("Введите первое имя");
            name1 = scanner.nextLine();
            printAnswer("Введите второе имя");
            name2 = scanner.nextLine();
            presenter.setDivorce(name1,name2);
        }else{
            printAnswer("Введите первый id");
            id1 = Integer.parseInt(scanner.nextLine());
            printAnswer("Введите второй id");
            id2 = Integer.parseInt(scanner.nextLine());
            presenter.setDivorce(id1, id2);
        }
    }
    public void getFamilyTreeinfo() {
        presenter.getFamilyTreeInfo();
    }

    public void sortByName() {
        presenter.sortByName();
    }
    public void sortByAge() {
        presenter.sortByAge();
    }
    public void sortByBirthdate() {
        presenter.sortByBirthDate();
    }

    public void saveToFile() {
        String filename;
        String filePath = "src/model/writer/";
        printAnswer("Укажите имя файла");
        filename = scanner.nextLine();
        filePath += filename+".txt";
        if (presenter.saveToFile(filePath))
            printAnswer("Файл " + filename + " успешно сохранен");
        else
            printAnswer("Ошибка сохранения");
    }
    public void loadFromFile() {
        String filename;
        String filePath = "src/model/writer/";
        printAnswer("Укажите имя файла");
        filename = scanner.nextLine();
        filePath += filename+".txt";
        if (presenter.loadFromFile(filePath))
            printAnswer("Файл " + filename + " успешно загружен");
        else
            printAnswer("Ошибка загрузки");
    }
}
