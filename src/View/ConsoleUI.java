package View;

import Presenter.Recipient;

import java.util.Scanner;

public class ConsoleUI implements View {
    private final Scanner scanner = new Scanner(System.in);
    private String consoleName;
    private Recipient presenter = null;
    private boolean runApp = true;

    public void setPresenter(Recipient presenter){
        this.presenter = presenter;
    }

    public void mainLoop(){
        while (this.runApp){
            println(String.format("%s: ", this.consoleName));

            this.presenter.acceptInput(nextLine());
        }
    }

    public void exit(){
        this.runApp = false;
    }

    public void setConsoleName(String consoleName){
        this.consoleName = consoleName;
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public void println(String string){
        System.out.print("\n" + string);
    }

    public void printMessage(String nameERROR, String message) {
        System.out.printf("\n\t%s: %s\n", nameERROR, message);
    }
}
