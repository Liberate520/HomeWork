package ru.gd.family_tree.view;

import ru.gd.family_tree.view.commands.MainMenu;
import ru.gd.family_tree.model.servis.Servis;
import ru.gd.family_tree.model.gender.Gender;
import ru.gd.family_tree.model.human.Human;
import ru.gd.family_tree.presenter.Presenter;

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
        System.out.println("Приветствую тебя пользователь!");
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
        presenter.printNameFamiliTree();
    }

   public void sortByName() {
        presenter.sortByName();
        presenter.printNameFamiliTree();
    }

    public void getFamiliTree() {
        System.out.println(presenter.getFamilyTree());
    }

    public void printNameFamiliTree() {
        presenter.printNameFamiliTree();
    }

    public void getSiblings() {
        System.out.println("введите id , кого нужны братья и сёстры");
        String nameId=scanner.nextLine();
        System.out.println(presenter.getSiblings(Integer.parseInt(nameId)));
    }


    public void getAge(){
        System.out.println("введите id , чей нужен возраст:");
        String nameAge=scanner.nextLine();
        Human human=presenter.getById(Integer.parseInt(nameAge));
        presenter.getAge(human);
    }

    public void addSpouse() {
        System.out.println("введите id , кому добавить супруга(супругу):");
        String nameHuman=scanner.nextLine();
        System.out.println("введите id супруга(супруги):");
        String nameSpouse=scanner.nextLine();
        Human human=presenter.getById(Integer.parseInt(nameHuman));
        Human spouse=presenter.getById(Integer.parseInt(nameSpouse));
        presenter.addSpouse(human,spouse);
    }

    public void addFather() {
        System.out.println("введите id , кому добавить отца:");
        String nameHuman=scanner.nextLine();
        System.out.println("введите id отца:");
        String nameFather=scanner.nextLine();
        Human human=presenter.getById(Integer.parseInt(nameHuman));
        Human father=presenter.getById(Integer.parseInt(nameFather));
        presenter.addFather(human,father);
    }

    public void addMother() {

        System.out.println("введите id , кому добавить мать:");
        String nameHuman=scanner.nextLine();
        System.out.println("введите id матери:");
        String nameMather=scanner.nextLine();
        Human human=presenter.getById(Integer.parseInt(nameHuman));
        Human mother=presenter.getById(Integer.parseInt(nameMather));
        presenter.addMother(human,mother);
    }

    public void addHuman() {
        System.out.println("введите имя :");
        String name=scanner.nextLine();
        System.out.println("введите дату рождения в формате (год-месяц-дата) :");
        String birghDateStr =scanner.nextLine();
        LocalDate birghDate= LocalDate.parse(birghDateStr);
        System.out.println("если человек живой введите yes , если нет введите no");
        String ziv=scanner.nextLine();
        LocalDate deathDate;
        if (ziv.equals("no")) {
            System.out.println("введите дату смерти в формате (год-месяц-дата) :");
            String deathDatestr = scanner.nextLine();
            deathDate = LocalDate.parse(deathDatestr);
        }
        else deathDate=null;
        System.out.println("введите 1 , если мужчина или 2 , если женщина:");
        String genderStr=scanner.nextLine();
        Gender gender;
        if (genderStr.equals("1"))gender=Gender.MALE;
        else gender=Gender.FEMALE;

        Servis servis=new Servis();
        if (deathDate==null) {
            presenter.addHuman(name, birghDate, gender);
            System.out.println(presenter.getFamilyTree());
        }
        else {
            presenter.addHuman(name, birghDate,deathDate, gender);
            System.out.println(presenter.getFamilyTree());
        }

    }
    public void addChild() {  //добавить ребёнка

        System.out.println("введите id , кому добавить ребёнка:");
        String nameHuman=scanner.nextLine();
        System.out.println("введите id ребёнка:");
        String nameChild=scanner.nextLine();

        presenter.addChild(presenter.getById(Integer.parseInt(nameHuman)),presenter.getById(Integer.parseInt(nameChild)));
    }
    @Override
    public void printAnswer(int answer) {
        System.out.println(answer);
    }
    public void saveFamilyTree() throws IOException {
        System.out.println("введите имя файла , куда сохранить:");
        String nameFile=scanner.nextLine();
        presenter.saveFamilyTree(nameFile);
    }
    public void readFamilyTree() throws IOException, ClassNotFoundException {
        System.out.println("введите имя файла :");
        String nameFile=scanner.nextLine();
        presenter.readFamilyTree(nameFile);
    }
}
