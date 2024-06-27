package ru.gb.family_tree;

import ru.gb.family_tree.model.FT.FamilyTreeItem;

import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;


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

