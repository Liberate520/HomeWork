package View.BaseClass;

import java.util.Scanner;

public abstract class UI {
    protected final Scanner scanner;
    protected final String CONSOLE_NAME;
    protected boolean runApp = true;

    public UI(String CONSOLE_NAME, Scanner scanner){
        this.CONSOLE_NAME = CONSOLE_NAME;
        this.scanner = scanner;
    }

    public abstract void mainLoop();

    public void exit(){
        this.runApp = false;
    }

    public void println(String string){
        System.out.print("\n" + string);
    }

    public void printMessage(String message){
        System.out.printf("\n\t%s\n", message);
    }

    public void printSignedMessage(String nameERROR, String message) {
        System.out.printf("\n\t%s: %s\n", nameERROR, message);
    }
}
