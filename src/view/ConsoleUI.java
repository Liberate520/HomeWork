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

    // Добавляем члена семьи
    public void addFamilyMember() {
        presenter.addPerson(addName(),addGender(),addBDate(),addDeathDate());
    }

    //Добавляем имя члена семьи
    private String addName() {
        System.out.println("Добавьте члена семьи:");
        return scanner.nextLine();
    }

    //Добавляем пол и проверяем на валидность введенное значение
    private Gender addGender() {
        System.out.println("Укажите пол (male/female):");
        //Проверяем на валидность введенные данные
        String printGender=scanner.nextLine();
        while (!printGender.equals("male")&&!printGender.equals("female")){
            System.out.println("Вы ввели некорректное значение. Попробуйте снова.");
            printGender=scanner.nextLine();
        }
        Gender gender = Gender.valueOf(printGender);
        return gender;
    }

    //Добавляем дату рождения и проверяем на валидность введенное значение
    private LocalDate addBDate(){
        System.out.println("Введите год рождения члена семьи в формате гггг-мм-дд:");
        //Проверяем на валидность введенную дату рождения.
        LocalDate today = LocalDate.now();
        LocalDate bDay = LocalDate.parse(scanner.nextLine());
        while(bDay.isAfter(today)){
            System.out.println("Вы ввели некорректное значение. Попробуйте снова.");
            bDay = LocalDate.parse(scanner.nextLine());
        }
        return bDay;
    }

    //В случае необходимости добавляем дату смерти
   private LocalDate addDeathDate(){
       System.out.println("В случае необходимости укажите дату смерти члена семьи в формате гггг-мм-дд. В противном случае пропустите, нажав Enter");
       String dateOfDeath=scanner.nextLine();
       LocalDate deathDate;
       if (dateOfDeath != "") {
           deathDate = LocalDate.parse(dateOfDeath);
           return deathDate;
       } else {
           return null;
       }
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
        System.out.println("Древо отcортировано по имени.");
        presenter.sortByName();

    }

    public void sortByDateOfBirth() {
        System.out.println("Древо отcортировано по дате рождения.");
        presenter.sortByDateOfBirth();
    }

    public void saveTree() {

        presenter.saveTree();
        System.out.println("Древо сохранено!");
    }

    public void printLoadedTree() {
        presenter.printLoadedTree();
    }

    public void finish() {
        System.out.println("Спасибо, что Вы выбрали нас! Хорошего дня!");
        work = false;

    }

}
