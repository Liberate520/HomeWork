package View;

import Presenter.DatabasePresenter.DatabasePresenter;
import View.BaseClass.UI;
import View.Interface.DatabaseView;

import java.util.Scanner;

public class DatabaseUI extends UI implements DatabaseView {
    private DatabasePresenter databasePresenter;

    public DatabaseUI(String CONSOLE_NAME, Scanner scanner) {
        super(CONSOLE_NAME, scanner);
    }

    public void setPresenter(DatabasePresenter databasePresenter) {
        this.databasePresenter = databasePresenter;
    }

    @Override
    public void mainLoop(){
        while (this.runApp){
            println(String.format("%s: ", this.CONSOLE_NAME));

            this.databasePresenter.acceptInput(scanner.nextLine());
        }
    }

    public void exit() {
        super.exit();
    }

    public String nextLine(){
        return scanner.nextLine();
    }

    public void println(String string) {
        super.println(string);
    }

    public void printMessage(String name, String message) {
        super.printMessage(message);
    }

    public void printSignedMessage(String name, String message) {
        super.printSignedMessage(name, message);
    }
}
