import model.Human.*;
import model.familyTree.FamilyTree;
import model.service.Service;
import view.ConsoleUi;
import view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        View view = new ConsoleUi();
        view.start();

    }
}