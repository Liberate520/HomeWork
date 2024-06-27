package ru.gb.family_tree;

import ru.gb.family_tree.model.FT.FamilyTree;
import ru.gb.family_tree.model.FT.FamilyTreeItem;
import ru.gb.family_tree.model.FT.FileHandler;
import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.model.Human.Human;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static <T extends FamilyTreeItem<T>> void main(String[] args) {

        View view = new ConsoleUI();
        view.start();

//        service.addHuman("Шульга", "Анастасия", Gender.Female, LocalDate.of(1991,3,16));
//        service.addHuman("Похабов", "Андрей", Gender.Male, LocalDate.of(1993,3,14));
//        service.addHuman("Похабов", "Дмитрий", Gender.Male, LocalDate.of(2021,12,23));
//        service.addHuman("Шульга", "Наталья", Gender.Female, LocalDate.of(1961,5,12));
//        service.addHuman("Шульга", "Алексей", Gender.Male, LocalDate.of(1956,5,8));
//        service.addHuman("Похабова","Елена", Gender.Female, LocalDate.of(1972, 9, 1));
//        service.addHuman("Похабов","Дмитрий", Gender.Male, LocalDate.of(1972, 8, 5));
//

    }
}

