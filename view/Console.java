package homeWork.view;

import java.time.LocalDate;
import java.util.Scanner;
import homeWork.model.service.Service;
import homeWork.presenter.Presenter;
import homeWork.model.gender.Gender;

public class Console implements View{

    private Scanner scanner;
    private Presenter presenter;
    private Service service;
    private boolean flag;
    private Menu menu;
    
    public Console(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        service = new Service();
        menu = new Menu(this);
        flag = true;
    }

    @Override
    public void start(){
        System.out.println("Система запущена");
        while(flag){
            System.out.println(menu.printMenu());
            String strIndex = scanner.nextLine();
            int index = Integer.parseInt(strIndex);
            menu.execute(index);
        }
    }

    public void addHuman(){
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();

        System.out.println("Введите дату рождения в формате гггг-мм-дд");
        String strdob = scanner.nextLine();
        LocalDate dob = LocalDate.parse(strdob);
        System.out.println("Введите дату смерти(если есть), иначе 0");
        String strdod = scanner.nextLine();
        LocalDate dod = strdod.equals("0") ? null : LocalDate.parse(strdod);
        System.out.println("Введите пол");
        String genderString = scanner.nextLine();
        Gender gender=null;
        if (genderString.equalsIgnoreCase("Male")) {
            gender = Gender.Male;
        } else if (genderString.equalsIgnoreCase("Female")) {
            gender = Gender.Female;
        }
        System.out.println("Введите имя матери");
        String motherName = scanner.nextLine();
        LocalDate dobMother = null;
        if(!motherName.isEmpty()){
            System.out.println("Введите день рождения матери");
            String strdobMother = scanner.nextLine();
            dobMother = LocalDate.parse(strdobMother);
        }
        System.out.println("Введите имя отца");
        String fatherName = scanner.nextLine();
        LocalDate dobFather = null;
        if(!fatherName.isEmpty()){
            System.out.println("Введите день рождения отца");
            String strdobFather = scanner.nextLine();
            dobFather = LocalDate.parse(strdobFather);
        }
        presenter.addHuman(name, dob, dod, gender, service.findPerson(motherName, dobMother), service.findPerson(fatherName, dobFather));
    }

    public void getTreeList(){
        presenter.getTree();
    }

    public void sortbyName(){
        presenter.sortbyName();
    }

    public void sortbyDate(){
        presenter.sortbyDate();
    }

    public void finish(){
        System.out.println("Завершение работы...");
        flag = false;
    }

    @Override
    public void print(String text){
        System.out.println(text);
    }
}