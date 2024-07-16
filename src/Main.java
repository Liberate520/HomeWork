import Model.family_tree.FamilyTree;
import Model.family_tree.Servise;
import Model.family_tree.human.Gender;
import View.View;
import View.ConsoleUI;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        View view = new ConsoleUI();
        Servise servise = new Servise();
        view.start();

        servise.addHuman("Aнна", "ж", LocalDate.of(1913, 12, 6));
        servise.addHuman("Афанасий", "м", LocalDate.of(1923, 5, 18));
        servise.addHuman("Чучуня", "ж", LocalDate.of(1943, 4, 30));


    }
    }

