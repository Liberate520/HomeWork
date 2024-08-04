package ru.gb2.family_tree7;

import ru.gb2.family_tree7.view.ConsoleUI;
import ru.gb2.family_tree7.view.View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}
