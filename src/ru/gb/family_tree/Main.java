package ru.gb.family_tree;

import ru.gb.family_tree.model.dataHandler.ReadFile;
import ru.gb.family_tree.model.dataHandler.WriteFile;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI(new WriteFile(), new ReadFile());
        view.start();
    }
}
