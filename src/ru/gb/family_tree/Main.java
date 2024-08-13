package ru.gb.family_tree;

import ru.gb.family_tree.view.View;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.model.familly_tree.FamilyTree;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        view.startWork();
    }
}

