import java.io.FileNotFoundException;
import java.io.IOException;

import src.view.ConsoleUI;
import src.view.View;

public class main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        View view = new ConsoleUI();

        view.start();

    }
}
