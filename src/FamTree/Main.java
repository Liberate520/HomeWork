package FamTree;

import java.time.LocalDate;
import java.util.Scanner;

import FamTree.model.ft.FamilyTree;
import FamTree.model.ft.Gender;
import FamTree.model.ft.human.Human;
import FamTree.model.ft.writer.FileHandler;
import FamTree.view.ConsoleUI;
import FamTree.view.View;


public class Main {

    public static void main(String[] args) {

        View view = new ConsoleUI();
        view.start();
    }
}
