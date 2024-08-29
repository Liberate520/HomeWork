package GB_Homework.View;

import GB_Homework.Model.Gender.Gender;
import GB_Homework.Model.Human.Human;
import GB_Homework.Model.Service.Service;
import GB_Homework.Presenter.Presenter;
import GB_Homework.View.Commands.MainMenu;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private Boolean flag;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner=new Scanner(System.in);
        presenter=new Presenter(this);
        flag=true;
        mainMenu=new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Программа Семейное древо.");
        while (flag){
            System.out.println(mainMenu.menu());
            String choiceStr= scanner.nextLine();
            if (checkChoise(choiceStr)) {
                int choice = Integer.parseInt(choiceStr);
                mainMenu.execute(choice);
            }
        }
    }

    public boolean checkChoise(String choiceStr){ //Проверка на валидность
        if (choiceStr.matches("[0-9]*")){  // Проверить что это число
            int choice =Integer.parseInt(choiceStr);
            return choice>=0&choice<= mainMenu.size();
        }
        else return false;
    }

    public void end(){
        flag=false;
    }
    public void sortByData() {
        presenter.sortByData();
        presenter.printNameFamilyTree();
    }

    public void sortByName() {
        presenter.sortByName();
        presenter.printNameFamilyTree();
    }

    public void getFamiliTree() {
        System.out.println(presenter.getFamilyTree());
    }

    public void printNameFamilyTree() {
        presenter.printNameFamilyTree();
    }

    public void getSiblings() {
        System.out.println("Введите id , кого нужны братья и сёстры");
        String nameId = scanner.nextLine();
        System.out.println(presenter.getSiblings(Integer.parseInt(nameId)));
    }


    public void getAge(){
        System.out.println("Введите id , чей нужен возраст:");
        String nameAge = scanner.nextLine();
        Human human = presenter.getById(Integer.parseInt(nameAge));
        presenter.getAge(human);
    }

    public void addSpouse() {
        System.out.println("Введите id , кому добавить супруга(супругу):");
        String nameHuman = scanner.nextLine();
        System.out.println("Введите id супруга(супруги):");
        String nameSpouse = scanner.nextLine();
        Human human = presenter.getById(Integer.parseInt(nameHuman));
        Human spouse = presenter.getById(Integer.parseInt(nameSpouse));
        presenter.addSpouse(human,spouse);
    }

    public void addFather() {
        System.out.println("Введите id , кому добавить отца:");
        String nameHuman = scanner.nextLine();
        System.out.println("Введите id отца:");
        String nameFather = scanner.nextLine();
        Human human = presenter.getById(Integer.parseInt(nameHuman));
        Human father = presenter.getById(Integer.parseInt(nameFather));
        presenter.addFather(human,father);
    }

    public void addMother() {

        System.out.println("Введите id , кому добавить мать:");
        String nameHuman = scanner.nextLine();
        System.out.println("Введите id матери:");
        String nameMather = scanner.nextLine();
        Human human = presenter.getById(Integer.parseInt(nameHuman));
        Human mother = presenter.getById(Integer.parseInt(nameMather));
        presenter.addMother(human,mother);
    }

    public void addHuman() {
        System.out.println("Введите имя :");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения в формате (год-месяц-дата) :");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr);
        System.out.println("Если человек живой введите 'YES' , если нет введите 'NO'");
        String ziv = scanner.nextLine();
        LocalDate deathDate;
        if (ziv.equals("NO")) {
            System.out.println("Введите дату смерти в формате (год-месяц-дата) :");
            String deathDateStr = scanner.nextLine();
            deathDate = LocalDate.parse(deathDateStr);
        }
        else deathDate = null;
        System.out.println("Введите '1', если мужчина или '2', если женщина:");
        String genderStr = scanner.nextLine();
        Gender gender;
        if (genderStr.equals("1"))gender = Gender.MALE;
        else gender=Gender.FEMALE;
        System.out.println("");

        Service service = new Service();
        if (deathDate==null) {
            presenter.addHuman(name, birthDate, gender);
            System.out.println(presenter.getFamilyTree());
        }
        else {
            presenter.addHuman(name, birthDate, deathDate, gender);
            System.out.println(presenter.getFamilyTree());
        }
        System.out.println("");

    }

    public void addChild() {  //добавить ребёнка

        System.out.println("Введите id , кому добавить ребёнка:");
        String nameHuman=scanner.nextLine();
        System.out.println("Введите id ребёнка:");
        String nameChild=scanner.nextLine();

        presenter.addChild(presenter.getById(Integer.parseInt(nameHuman)),presenter.getById(Integer.parseInt(nameChild)));
    }

    @Override
    public void printAnswer(int answer) {
        System.out.println(answer);
    }

    public void saveFamilyTree() throws IOException {
        System.out.println("Введите имя файла: ");
        String nameFile = scanner.nextLine();
        presenter.saveFamilyTree(nameFile);
    }

    public void readFamilyTree() throws IOException, ClassNotFoundException {
        System.out.println("Введите имя файла: ");
        String nameFile = scanner.nextLine();
        presenter.readFamilyTree(nameFile);
    }
}
