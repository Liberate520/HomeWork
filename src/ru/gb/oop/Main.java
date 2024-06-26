package ru.gb.oop;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Main {
    public final static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        logger.info("App started");
        FamilyTree familyTree = new FamilyTree();
        Human ivan = new Human("Ivan", Sex.Male, new Date(2000, 1, 1), new Date(2020, 1, 1), null, null);
        Human olga = new Human("Olga", Sex.Female, new Date(2000, 1, 1), new Date(2020, 1, 1), null, null);
        Human roman = new Human("Roman", Sex.Male, new Date(2000, 1, 1), new Date(2020, 1, 1), List.of(ivan, olga), null);
        ivan.addChild(roman);
        olga.addChild(roman);

        familyTree.addHuman(roman);
        familyTree.addHuman(ivan);
        familyTree.addHuman(olga);
        Human petr = new Human("Petr", Sex.Male, new Date(2000, 1, 1), new Date(2020, 1, 1), List.of(ivan, olga), null);
        ivan.addChild(petr);
        olga.addChild(petr);

        familyTree.addHuman(petr);
        Human misha = new Human("Misha", Sex.Male, new Date(2000, 1, 1), new Date(2020, 1, 1), null, List.of(olga));
        familyTree.addHuman(misha);
        Human vika = new Human("Vika", Sex.Female, new Date(2000, 1, 1), new Date(2020, 1, 1), null, List.of(olga));
        familyTree.addHuman(vika);
        olga.setParents(List.of(misha, vika));
        System.out.print(familyTree);

        System.out.println("Демонстраций поиска: ищем Vika\n" + familyTree.findHumanByName("Vika"));

        System.out.println("Демонстрация работы поиска всех предков Petr");
        for (Map.Entry<Human, Integer> entry : familyTree.getAllGenerationsBefore("Petr")) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue());
        }

        System.out.println("Демонстрация работы поиска братьев и сестёр у Petr");
        for (Human human : familyTree.getSistersAndBrothers("Petr")) {
            System.out.println(human.getName());
        }

        logger.info("App finished");
    }
}
