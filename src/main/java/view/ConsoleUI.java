package view;

import Presenter.Presenter;
import view.commands.CreateTree;
import view.menu.HomMenu;
import view.menu.Path;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Ошибка Ввода";

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private HomMenu homMenu;
    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        homMenu = new HomMenu(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        Hello();
        while (work){
            printMenu();
            execute();
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    private void Hello(){
        int h = new Date().getHours();
        String str = new String();
        if(h > 22 || h < 5 ) str = Message.GOODNIGHT.getMessage();
        if (h > 4 && h < 11) str = Message.GOODMORNING.getMessage();
        if (h > 10 && h < 18) str = Message.GOODDAY.getMessage();
        if (h > 17 && h < 23) str = Message.GOODEVENING.getMessage();
        System.out.println(str + " выберите действие:");
    }

    public void CreateTree(){
        presenter.CreateTree();
    }

    public void LoadTree() throws IOException, ClassNotFoundException {
        presenter.LoadTree(Path.PATH.getPath());
    }

    private void printMenu(){
        System.out.println(homMenu.menu());
    }

    private void execute() throws IOException, ClassNotFoundException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                homMenu.execute(numCommand);
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
        if (numCommand <= homMenu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

}
