package ru.gb.family_tree.view;

import ru.gb.family_tree.view.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        String filePath = "data.txt"; // путь к файлу
        ConsoleUI ui = new ConsoleUI(filePath);
        ui.start();
    }
}

