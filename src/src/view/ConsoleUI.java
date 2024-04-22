package src.view;

import java.util.Scanner;

import src.presenter.Presenter;

public class ConsoleUI implements View {

    private String ERROR_ENTER = "ВЫ ввели не допустимое значение";
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
    public void start() {
        while (work) {
            
        }
    }

    @Override
    public void printAnswer(String txt) {
        System.err.println(txt);
    }



}
