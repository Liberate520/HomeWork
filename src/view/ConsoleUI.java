package view;

import model.person.Gender;
import model.writer.Writable;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Указанный пункт отсутствует в меню. Попробуйте снова.";
    private Scanner scanner=new Scanner(System.in);
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;


    public ConsoleUI(Writable writable) {
        this.scanner = scanner;
        presenter = new Presenter(this,writable);
        work=true;
        menu=new MainMenu(this);
    }

    @Override
    public void printAnswer(String textAnswer) {
        System.out.println(textAnswer);
    }

    @Override
    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    private void hello(){
        System.out.println("Рады видеть Вас!");
        System.out.println();
    }


    //При выполнении проверяем на валидность введенные значения
    private void execute(){
        String line = scanner.nextLine();
        if (checkInputText(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    //Проверяем на валидность введенного значения (должны быть цифровые значения)
    private boolean checkInputText(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    //Проверяем на валидность в соответствии с пунктами меню
    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    //Вывод ошибки в случае неправильного ввода пункта меню
    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }


    public void addFamilyMember() {
        System.out.println("Добавьте члена семьи:");
        String name = scanner.nextLine();

        System.out.println("Укажите пол (male/female):");
        //Проверяем на валидность введенные данные
        String printGender=scanner.nextLine();
        while (!printGender.equals("male")&&!printGender.equals("female")){
            System.out.println("Вы ввели некорректное значение. Попробуйте снова.");
            printGender=scanner.nextLine();
        }
        Gender gender = Gender.valueOf(printGender);


        System.out.println("Введите год рождения члена семьи в формате гггг-мм-дд:");
        //Проверяем на валидность введенную дату рождения.
        LocalDate today = LocalDate.now();
        LocalDate bDay = LocalDate.parse(scanner.nextLine());
        while(bDay.isAfter(today)){
            System.out.println("Вы ввели некорректное значение. Попробуйте снова.");
            bDay = LocalDate.parse(scanner.nextLine());
        }
        LocalDate birthDate = bDay;


        System.out.println("В случае необходимости укажите дату смерти члена семьи в формате гггг-мм-дд. В противном случае пропустите, нажав Enter");
        String dateOfDeath=scanner.nextLine();
        LocalDate deathDate;
        if (dateOfDeath != "") {
            deathDate = LocalDate.parse(dateOfDeath);
        } else {
            deathDate=null;
        }

        presenter.addPerson(name,gender,birthDate,deathDate);
        System.out.println("Член семьи добавлен в древо.");
        System.out.println();
    }

    public void addKinship() {
        System.out.println("Введите имя родителя (должно полностью соответствовать имени ранее добавленного члена семьи)");
        String parentName = scanner.nextLine();
        System.out.println("Введите имя ребенка (должно полностью соответствовать имени ранее добавленного члена семьи)");
        String childName = scanner.nextLine();
        presenter.addKinship(parentName,childName);
        System.out.println();
    }

    public void showTree() {
        presenter.getTreeInfo();
    }

    public void sortByName() {
        presenter.sortByName();

    }

    public void sortByDateOfBirth() {
        presenter.sortByDateOfBirth();
    }

    public void saveTree() {
        presenter.saveTree();
    }

    public void printLoadedTree() {
        presenter.printLoadedTree();
    }

    public void finish() {
        System.out.println("Спасибо, что Вы выбрали нас! Хорошего дня!");
        work = false;

    }

}
