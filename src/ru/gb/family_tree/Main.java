package ru.gb.family_tree;

import ru.gb.family_tree.model.member.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        view.start();
    }
}
