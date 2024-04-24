package src.view;

import java.time.LocalDate;
import java.util.Scanner;

import src.model.FamilyTree;
import src.model.Gender;
import src.model.Person;
import src.presenter.Presenter;

public class ConsoleUI implements View {

    private String ERROR_ENTER = "Ввод не корректен, попробуйте снова";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;
    private FamilyTree<Person> list;


    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        //presenter.addPerson("v", Gender.male ,LocalDate.of(1987, 8, 7)  );
        //presenter.addPerson("b", Gender.female ,LocalDate.of(1988, 10,3)  );
        //presenter.addPerson("n", Gender.male ,LocalDate.of(2014, 4, 18)  );
        while (work) {
            System.out.println(mainMenu.menu());
            execut();
                        
        }
    }

    private void execut() {
        String input = scanner.nextLine();
        if (validationInput(input)){
            mainMenu.execut(input);
        }else{
            System.out.println(ERROR_ENTER);
        } 

    }

    public boolean validationInput(String text){
        if (text.matches("[1-9]+")){
            int num = Integer.parseInt(text);
            if (num<= mainMenu.getSize()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public void printAnswer(String txt) {

        
    }
     
    public void finish(){
        System.out.println("Завершение работы");
        work=false;
    }

    public void addPerson(){
        Gender gendr = null;
        //int year;
        //int mn;
        //int day;
        StringBuilder dt = new StringBuilder();

        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите пол\n");
        //System.out.println("Где Ж - женский, а М - мужcкой"); // не считывает русскую раскладку , найти решение
        System.out.println("Где 1 - женский, а 2 - мужcкой");
        boolean wrk = true;
        while (wrk) {
            String gender = scanner.nextLine();
            //System.out.println(gender);
            if (gender.contains("1")) {
                gendr = Gender.female;
                wrk = false;
            } else if (gender.contains("2")) {
                gendr = Gender.male;
                wrk = false;
            } else {
                System.out.println(ERROR_ENTER);
            }
        }
        System.out.println("Введите дату рождения\n");
        wrk = true;
        while (wrk) {
            System.out.println("Введите год: ");
            String num = scanner.nextLine();
            if (isNumeric(num)) {
                int year= Integer.parseInt(num);
                if(year <= LocalDate.now().getYear()){
                    dt.append(num);
                    dt.append("-");
                    wrk = false;}else{
                System.out.println(ERROR_ENTER);}
            } else {
                System.out.println(ERROR_ENTER);
            }
        }
        wrk = true;
        while (wrk) {
            System.out.println("Введите месяц: ");
            String num = scanner.nextLine();
            
            if (isNumeric(num)) {
                int mn= Integer.parseInt(num);
                if(0<mn && mn<13){
                    dt.append(num);
                    dt.append("-");
                    wrk = false;}else{
                System.out.println(ERROR_ENTER);}
            } else {
                System.out.println(ERROR_ENTER);
            }
        }
        wrk = true;
        while (wrk) {
            System.out.println("Введите день: ");
            String num = scanner.nextLine();
            if (isNumeric(num)) {
                int day= Integer.parseInt(num);
                if(0<day && day<32){
                    dt.append(num);
                    wrk = false;
                }else{
                System.out.println(ERROR_ENTER);}
            } else {
                System.out.println(ERROR_ENTER);
                
            }
        }
        //System.out.println(dt);
        LocalDate date = LocalDate.parse(dt.toString());
        System.out.println(date);
        //LocalDate date = LocalDate.of(year,mn,day);
        presenter.addPerson(name, gendr, date);
    }

    public static boolean isNumeric (String text){
        if (text == null || text.contains("-/*+ ")){
            return false;
        }
        try {
            int i = Integer.parseInt(text);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;}

    public void kinship(){
        System.out.println("Введите имя");
        System.out.println("Ребенка");
        StringBuilder inPut = new StringBuilder();

        inPut.append(enterString());
        inPut.append(" ");
        System.out.println("Введите имя");
        System.out.println("Отца");
        inPut.append(enterString());
        inPut.append(" ");
        System.out.println("Введите имя");
        System.out.println("Матери");
        inPut.append(enterString());
        inPut.append(" ");

        presenter.kinship(inPut.toString());

        
        
    }

    public String enterString(){
        boolean wrk = true;
        while(wrk){
            String name = scanner.nextLine();
            //num = new IsNumeric(name);
            if (name == null || isNumeric(name)) {
                System.out.println(ERROR_ENTER);                
            }else{
                wrk = false;
                return name;
            }
        }
        return ERROR_ENTER;       

    }

    public void printList(){
        presenter.prinrtListInfo(); 
    }    

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge(){
        presenter.sortByAge();        
    }

    }

    