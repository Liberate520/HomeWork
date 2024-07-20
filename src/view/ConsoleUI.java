package view;

import presenter.Presenter;
import model.human.Gender;
import model.human.Human;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private boolean work;
    private Presenter presenter;
    private MainMenu menu;
    Gender gender;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Приветствие\n");
        while (work) {
            System.out.println(menu.menu());
            System.out.println("\nВведите число:");
            String choiceStr = scanner.nextLine();
            int choice = strNumToInt(choiceStr);
            if (isNumMenu(choice)){
                menu.execute(choice);
            } else {
                System.out.println("Пункта меню с таким номером нет. Попробуйте еще раз");
            }
        }
    }

    public void finish() {
        work = false;
        scanner.close();
        System.out.println("До новых встреч!");
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void addHuman(){
        System.out.println("Укажите имя:");
        String name = scanner.nextLine();

        System.out.println("Укажите гендер:");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("Введите число:");
        String choiceStr = scanner.nextLine();
        if (choiceStr.equals("1")){
            gender = Gender.Male;
        } else if (choiceStr.equals("2")){
            gender = Gender.Female;
        } else {
            System.out.println("Не верное число");
        }

        System.out.println("Укажите дату рождения в формате yyyy-mm-dd");
        String dateOfBirthStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);

        presenter.addHuman(name, gender, dateOfBirth);
    }

    public void setMother(){
        System.out.println("Укажите id мамы:");
        String idMotherStr = scanner.nextLine();
        int idMother = strNumToInt(idMotherStr);

        if (searchIdHuman(idMother)){
            System.out.println("Укажите id ребенка:");
            String idChildrenStr = scanner.nextLine();
            int idChildren = strNumToInt(idChildrenStr);

            if (searchIdHuman(idChildren)){
                presenter.setMother(idChildren, idMother);
            }else{System.out.println("Человека с таким Id нет");}

        }else{System.out.println("Человека с таким Id нет");}
    }

    public void setFather(){
        System.out.println("Укажите id папы:");
        String idFatherStr = scanner.nextLine();
        int idFather = strNumToInt(idFatherStr);

        if (searchIdHuman(idFather)){
            System.out.println("Укажите id ребенка:");
            String idChildrenStr = scanner.nextLine();
            int idChildren = strNumToInt(idChildrenStr);

            if (searchIdHuman(idChildren)){
                presenter.setFather(idChildren, idFather);
            }else{System.out.println("Человека с таким Id нет");}

        }else{System.out.println("Человека с таким Id нет");}
    }

    public void setChildren(){
        System.out.println("Укажите id родителя:");
        String idParentStr = scanner.nextLine();
        int idParent = strNumToInt(idParentStr);

        if (searchIdHuman(idParent)){
            System.out.println("Укажите id ребенка:");
            String idChildrenStr = scanner.nextLine();
            int idChildren = strNumToInt(idChildrenStr);

            if (searchIdHuman(idChildren)){
                presenter.setChildren(idParent, idChildren);
            }else{System.out.println("Человека с таким Id нет");}

        }else{System.out.println("Человека с таким Id нет");}
    }

    public void setDateOfDeath(){
        System.out.println("Укажите id человека:");
        String idHumanStr = scanner.nextLine();
        int idHuman = strNumToInt(idHumanStr);
        
        if (searchIdHuman(idHuman)){
            System.out.println("Укажите дату смерти в формате yyyy-mm-dd");
            String dateOfDeathStr = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateOfDeath = LocalDate.parse(dateOfDeathStr, formatter);
            
            presenter.setDateOfDeath(idHuman, dateOfDeath);
        } else {System.out.println("Человека с таким Id нет");}
    }

    public Human getHuman(int idHuman){
        return presenter.getHuman(idHuman);
    }

    public void getHumansListInfo() {
        presenter.getHumansListInfo();
    }

    public void getFamilyTreeHuman() {
        System.out.println("Укажите id человека:");
        String idHumanStr = scanner.nextLine();
        int idHuman = strNumToInt(idHumanStr);
        if (searchIdHuman(idHuman)){
            presenter.getFamilyTreeHuman(idHuman);
        }else{System.out.println("Человека с таким Id нет");}
    }
    
    private int strNumToInt(String choiceStr) {
        try {
            int choice = Integer.parseInt(choiceStr);
          return choice;
        } catch(NumberFormatException e){
            return -1;
        }
    }
    
    private boolean searchIdHuman(int idHuman) {
        if (getHuman(idHuman) != null){
            return true;
        }
        return false;
    }

    private boolean isNumMenu(int choice) {
        if (choice > 0 && choice <= menu.size()){
            return true;
        }
        return false;
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
