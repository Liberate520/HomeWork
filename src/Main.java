import model.FamilyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;

import java.io.IOException;
import java.time.LocalDate;
import model.writer.FileHandler;
import presenter.Presenter;
import view.ConsoleUI;
import view.MainMenu;
import view.View;
import model.service.Service;





public class Main {


    public static void main(String[] args) throws IOException {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();

    }

}