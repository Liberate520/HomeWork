package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;


    public ConsoleUI(){
        scanner=new Scanner(System.in);
        presenter=new Presenter(this);
        work=true;
        menu= new MainMenu(this);
    }

    @Override
    public void printRes (String text){
        System.out.println(text);
    }

    @Override
    public void start(){
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish(){
        System.out.println("Vsego dobrogo!");
        work=false;
    }

    public void hello(){
        System.out.println("Здраствуйте!");
    }


    public void getTreeInfo(){
        presenter.getTreeInfo();
    }

    public void addHuman(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию");
        String familiya = scanner.nextLine();
        System.out.println("Введите пол man или woman");
        String pol= scanner.nextLine();
        System.out.println("Введите дату рождения в формате гггг.мм.дд ");
        String birthDate=scanner.nextLine();
        presenter.addHuman (name, familiya, pol,birthDate );
        System.out.println("Человек успешно добавлен");
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void addSuprugById(){
        System.out.println("Введите ID первого супруга");
        String id1Str = scanner.nextLine();
        int id1=Integer.parseInt(id1Str);
        System.out.println("Введите ID второго супруга");
        id1Str = scanner.nextLine();
        int id2=Integer.parseInt(id1Str);
        presenter.addSuprugById(id1, id2);
    }

    public void addSuprugByNum(){
        System.out.println("Введите номер в списке первого супруга");
        String id1Str = scanner.nextLine();
        int id1=Integer.parseInt(id1Str);
        System.out.println("Введите номер в списке второго супруга");
        id1Str = scanner.nextLine();
        int id2=Integer.parseInt(id1Str);
        presenter.addSuprugByNum(id1, id2);
    }

    public void addChildByNum(){
        System.out.println("Введите номер в списке родителя");
        String id1Str = scanner.nextLine();
        int id1=Integer.parseInt(id1Str);
        System.out.println("Введите номер в списке ребенка");
        id1Str = scanner.nextLine();
        int id2=Integer.parseInt(id1Str);
        presenter.addChildByNum(id1, id2);
    }

    public void addChildById(){
        System.out.println("Введите ID родителя");
        String id1Str = scanner.nextLine();
        int id1=Integer.parseInt(id1Str);
        System.out.println("Введите ID ребенка");
        id1Str = scanner.nextLine();
        int id2=Integer.parseInt(id1Str);
        presenter.addChildById(id1, id2);
    }

    public void addParentByNum(){
        System.out.println("Введите номер в списке потомка");
        String id1Str = scanner.nextLine();
        int id1=Integer.parseInt(id1Str);
        System.out.println("Введите номер в списке родителя");
        id1Str = scanner.nextLine();
        int id2=Integer.parseInt(id1Str);
        presenter.addParentByNum(id1, id2);
    }

    public void addParentById(){
        System.out.println("Введите ID потомка");
        String id1Str = scanner.nextLine();
        int id1=Integer.parseInt(id1Str);
        System.out.println("Введите ID родителя");
        id1Str = scanner.nextLine();
        int id2=Integer.parseInt(id1Str);
        presenter.addParentById(id1, id2);
    }

    public void getParentByNum(){
        System.out.println("Введите номер человека из спискаь чьих родителей необходимо показать");
        String id1Str = scanner.nextLine();
        int id1=Integer.parseInt(id1Str);
        presenter.getParentByNum(id1);
    }


    public void save(){
        System.out.println("Сохранить дерево Y/N ?");
        String id1Str = scanner.nextLine();
        if (id1Str.equals("Y")){
            presenter.save();
            System.out.println("Семейное дерево сохранено!");
        }else{
            System.out.println("Отмена сохранения");
        }

    }


    public void load(){
        System.out.println("Загрузить дерево Y/N ?");
        String id1Str = scanner.nextLine();
        if (id1Str.equals("Y")){
            presenter.load();
            System.out.println("Семейное дерево загружено!");
            presenter.getTreeInfo();
        }else{
            System.out.println("Отмена Загрузки");
        }

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
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println("INPUT_ERROR");
    }
}
