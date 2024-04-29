import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import view.ConsoleUI;
import view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        View view = new ConsoleUI();
        view.start();
    }
}
