package ru.gb.famaly_tree.view;

import ru.gb.famaly_tree.model.ft.Famaly_tree;
import ru.gb.famaly_tree.model.human.Gender;
import ru.gb.famaly_tree.model.human.Human;
import ru.gb.famaly_tree.presenter.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Ошибка ввода";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        helloWorld();
        while (work){
            printMenu();
            execute();
        }
    }


    public void finish(){
        System.out.println("Bye, world");
        work=false;
    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }

    public void helloWorld(){
        System.out.println("Hello world");
    }

    public void printMenu(){
        System.out.println(mainMenu.outputMenuInfo());
    }

    public Human searchByName(String name){
        return presenter.searchByName(name);
    }

    public void addHuman(){
        if(!presenter.isFirstHumanInFamalyTree()){
            System.out.println("введите ch, чтобы к существующему родителю добавить нового ребенка; pr, чтобы к существующему ребенку добавить нового родителя");
            String choise = scanner.nextLine();
            if(choise.equals("ch")) {
                //к существующему родителю добавляется новый человек - ребенок
                System.out.println("Заполните информацию о ребенке");
                Human h1 = createHuman();
                System.out.println("Введите имя родителя");
                String name = scanner.nextLine();
                Human h2 = searchByName(name);
                presenter.addPersonInFamalyTree(h1, h2);
            }
            else if (choise.equals("pr")){
                //к существующему ребенку добавляется новый человек - родитель
                System.out.println("Заполните информацию о родителе");
                Human h2 = createHuman();
                System.out.println("Введите имя ребенка");
                String name = scanner.nextLine();
                Human h1 = searchByName(name);
                presenter.addPersonInFamalyTree(h1, h2);
            }
            else {
                inputError();
            }
        }
        else{
            Human h1 = createHuman();
            presenter.addPersonInFamalyTree(h1);
        }
    }

    private Human createHuman(){
        while (true){
            System.out.println("введите имя");
            String name = scanner.nextLine();
            System.out.println("введите пол");
            String temp = scanner.nextLine();
            Gender gender;
            if (temp.equals(Gender.male.toString()) || temp.equals(Gender.female.toString())){
                gender = Gender.valueOf(temp);
            }
            else {
                inputError();
                continue;
            }
            System.out.println("введите дату рождения");
            LocalDate birthDate;
            String tempBirth = scanner.nextLine();
            if(ifThisADate(tempBirth)){
                birthDate = LocalDate.parse(tempBirth);
            }
            else {
                inputError();
                continue;
            }
            System.out.println("введите дату смерти");

            String temporary = scanner.nextLine();
            LocalDate deathDate = null;
            if(!temporary.equals("нет")) {
                if(ifThisADate(temporary)){
                    deathDate = LocalDate.parse(temporary);
                }
                else {
                    inputError();
                    continue;
                }
            }
            return presenter.createHuman(name,gender,birthDate,deathDate);
        }
    }

    private boolean ifThisADate(String date){
        try {
            LocalDate.parse(date);
            return true;
        }
        catch (DateTimeParseException e){
            return false;
        }
    }

    public void sortByName(){
        System.out.println("включить почивших членов семьи?");
        String answer = scanner.nextLine();
        boolean ans = true;
        if (answer.equals("да")){
            System.out.println(presenter.outputHumanListSortByName(ans));
        }
        else if(answer.equals("нет")){
            ans = false;
            System.out.println(presenter.outputHumanListSortByName(ans));
        }
        else {
            inputError();
        }
        System.out.println();
    }

    public void sortByAge(){
        System.out.println("включить почивших членов семьи?");
        String answer = scanner.nextLine();
        boolean ans = true;
        if (answer.equals("да")){
            System.out.println(presenter.outputHumanListSortByAge(ans));
        }
        else if(answer.equals("нет")){
            ans = false;
            System.out.println(presenter.outputHumanListSortByAge(ans));
        }
        else {
            inputError();
        }
        System.out.println();
    }

    public void sortByChildrenCount(){
        System.out.println("включить почивших членов семьи?");
        String answer = scanner.nextLine();
        boolean ans = true;
        if (answer.equals("да")){
            System.out.println(presenter.outputHumanListSortByChildrenCount(ans));
        }
        else if(answer.equals("нет")){
            ans = false;
            System.out.println(presenter.outputHumanListSortByChildrenCount(ans));
        }
        else {
            inputError();
        }
        System.out.println();
    }

    public void info(){
        System.out.println("введите имя");
        String name = scanner.nextLine();
        if(searchByName(name)!=null){
            System.out.println(presenter.outputHumanInfo(searchByName(name)));
        }
        else{
            inputError();
        }
        System.out.println();
    }

    public void addCouple(){
        //к существующему человеку добавить в пару нового человека
        System.out.println("Введите имя человека, к которому добавить нового человека");
        String name = scanner.nextLine();
        Human h1 = searchByName(name);
        if (h1==null){
            inputError();
        }
        else{
            Human h2 = createHuman();
            presenter.addCoupl(h1, h2);
        }

    }

    public void printHumanList(){
        System.out.println(presenter.outputHumanList());
        System.out.println();
    }

    public void printHumanTree(){
        System.out.println("введите ключевое имя");
        String name = scanner.nextLine();
        if (name.isEmpty()){
            //System.out.println("))))))))))))))))))))");
            System.out.println(presenter.outputFamalyTree());
        }
        else{
            System.out.println(presenter.outputFamalyTree(searchByName(name)));
        }
    }

    private void execute() throws IOException, ClassNotFoundException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
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
        if (numCommand <= mainMenu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void save() throws IOException {
        presenter.save();
    }

    public void download() throws IOException, ClassNotFoundException {
        presenter.download();
    }
}