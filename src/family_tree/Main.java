package family_tree;

import family_tree.model.writer.Writable;
import family_tree.view.ConsoleUI;
import family_tree.model.writer.FileHandler;


public class Main {
    public static void main(String[] args) {
        Writable<?> fileHandler = new FileHandler("src/family_tree/model/writer/family.txt");
        ConsoleUI consoleUI = new ConsoleUI(fileHandler);
        consoleUI.start();
    }
}