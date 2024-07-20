package View;

import Presenter.FamilyTreePresenter.FamilyTreePresenter;
import View.BaseClass.UI;
import View.Interface.FamilyTreeView;

import java.util.Scanner;

public class FamilyTreeUI extends UI implements FamilyTreeView {
    private FamilyTreePresenter presenter;

    public FamilyTreeUI(String CONSOLE_NAME, Scanner scanner) {
        super(CONSOLE_NAME, scanner);
    }

    @Override
    public void setPresenter(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void mainLoop(){
        while (this.runApp){
            println(String.format("%s: ", this.CONSOLE_NAME));

            this.presenter.acceptInput(nextLine());
        }
    }

    public String nextLine(){
        return scanner.nextLine();
    }

    public void exit() {
        super.exit();
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
