package ru.gb.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree ft = new FamilyTree();

        Human Adam = new Human("Adam", null, null, LocalDate.of(2000, 1, 1 ), LocalDate.of(3000, 12, 30 ), Gender.M);
        ft.addHuman(Adam);
        Human Eve = new Human("Eve", null, null, LocalDate.of(2000, 1, 1 ), LocalDate.of(3000, 12, 30 ), Gender.F);
        ft.addHuman(Eve);
        Human Son1 = new Human("Son1", Eve, Adam, LocalDate.of(2005, 2, 22 ), LocalDate.of(3022, 7, 7 ), Gender.M);
        ft.addHuman(Son1);
        //кровосмешение Евы со своим сыном
        Human Gdau1 = new Human("Gdau1", Eve, Son1, LocalDate.of(2055, 3, 3 ), null, Gender.F);
        ft.addHuman(Gdau1);

        System.out.println(Eve);

        System.out.println(Son1.getParents());

        System.out.println(ft.getFullTree());
    }
}
