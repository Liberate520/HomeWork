package src;

import java.io.FileNotFoundException;
import java.io.IOException;

import src.View.ConsoleUI;
import src.View.View;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        view.start();        
    }
}
