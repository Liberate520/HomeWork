//Lyalin Ilya
package ru.gb.family_tree;

import ru.gb.family_tree.humans.Human;
import ru.gb.family_tree.tree.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;

import static ru.gb.family_tree.humans.Gender.Female;
import static ru.gb.family_tree.humans.Gender.Male;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/ru/gb/family_tree/tree.txt";
        FamilyTree tree = testTree();
//        FamilyTree tree = load(filePath);
        System.out.println(tree);
        System.out.println("============sortByName===========");
        tree.sortByName();
        System.out.println(tree);
        System.out.println("===========sortByBirthDate============");
        tree.sortByBirthDate();
        System.out.println(tree);
        System.out.println("===========sortByGender============");
        tree.sortByGender();
        System.out.println(tree);

        save(tree, filePath);
    }

    private static FamilyTree load(String filePath) {
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read(filePath);
    }

    private static void save(FamilyTree tree, String filePath) {
        Writable writable = new FileHandler();
        writable.save(tree, filePath);
    }

    private static FamilyTree testTree () {
        FamilyTree tree = new FamilyTree();
        Human hum1 = new Human("Pavel", Male, LocalDate.of(1973, 11, 3));
        Human hum2 = new Human("Olga", Female, LocalDate.of(1980, 9, 12));

        tree.add(hum1);
        tree.add(hum2);
        tree.setWedding(hum1.getId(), hum2.getId());

        Human hum3 = new Human("Nastya", Female, LocalDate.of(2000, 8, 5), hum1, hum2);
        Human hum4 = new Human("Gleb", Male, LocalDate.of(1998, 3, 15), hum1, hum2);

        tree.add(hum3);
        tree.add(hum4);

        Human hum5 = new Human("Veronika", Female, LocalDate.of(1960, 11, 26));
        hum5.addChild(hum1);
        tree.add(hum5);
        //System.out.println(familyTree);
        return tree;
    }
}




