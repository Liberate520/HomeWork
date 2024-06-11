package FamilyTree;


import FamilyTree.model.element.Gender;
import FamilyTree.model.element.Human;
import FamilyTree.view.ConsoleUI;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();
    }
}