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

        System.out.println("Введите пол (Male/Female)");
        Gender gender = Gender.valueOf(scanner.nextLine());
        
        System.out.println("Введите имя матери");
        String motherName = scanner.nextLine();
        LocalDate dobMother = !motherName.isEmpty() ? LocalDate.parse(scanner.nextLine()) : null;

        System.out.println("Введите имя отца");
        String fatherName = scanner.nextLine();
        LocalDate dobFather = !fatherName.isEmpty() ? LocalDate.parse(scanner.nextLine()) : null;

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

    public void saveTreeToFile() {
        System.out.println("Введите имя файла для сохранения дерева:");
        String filename = scanner.nextLine();
        service.saveToFile(service.printTree(),filename);
        System.out.println("Дерево успешно сохранено в файл " + filename);
    }

    public void loadTreeFromFile() {
        System.out.println("Введите имя файла для загрузки дерева:");
        String filename = scanner.nextLine();
        service.loadFromFile(filename);
        System.out.println("Дерево успешно загружено из файла " + filename);
    }

    @Override
    public void print(String text){
        System.out.println(text);
    }
}