package family_tree;

import family_tree.model.Human.Gender;
import family_tree.model.Human.Human;
import family_tree.model.service.Service;
import family_tree.view.ConsoleUI;
import family_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        View view = new ConsoleUI();
        view.start();

    }

}