package ru.gb.family_tree.view;

import ru.gb.family_tree.model.dataHandler.Readable;
import ru.gb.family_tree.model.dataHandler.Writeble;
import ru.gb.family_tree.model.member.descriptionFormation.MemberDescription;
import ru.gb.family_tree.presenter.Presenter;
import ru.gb.family_tree.view.descriptionFormation.*;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    private MemberDescription descriptionFormation;

    public ConsoleUI(Writeble writeble, Readable readable){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this, writeble, readable);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    private void execute() throws IOException, ClassNotFoundException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommang = Integer.parseInt(line);
            if (checkCommand(numCommang)){
                menu.execute(numCommang);
            }
        }
    }

    private boolean checkCommand(int numCommang) {
        if (numCommang <= menu.getSize()){
            return true;
        }
        else {
            inputError();
            return false;
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
    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void hello() {
        HelloHandler hello = new Hello();
        hello.hello();

    }
    public void addMember(){
        AddMember am = new AddMember();
        am.addMember(scanner, presenter);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void getFullTree() {
        System.out.println(presenter.getFullTree());
    }

    public void writeFile() throws IOException {
        WritableData wd = new FileWriteData();
        wd.writeFile(scanner, presenter);
    }
    public void readData() throws IOException, ClassNotFoundException {
        ReadableData rd = new FileReadData();
        rd.readData(scanner, presenter);
    }

}
