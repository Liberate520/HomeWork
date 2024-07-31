package ru.gb.family_tree;

import ru.gb.family_tree.familly_tree.FamilyTree;
import ru.gb.family_tree.service.Service;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {
//        int genId = 0;
        FamilyTree familyTree = testTree();
//        FamilyTree familyTree = readTree();
        saveTree(familyTree);
        System.out.println(familyTree); // смотрим, что введено в Базу

        Service service = new Service();
        service.addHuman("Шурин", Gender.Male, LocalDate.of(1984, 6, 19));
        service.addHuman("Шафер", Gender.Male, LocalDate.of(1995, 3, 31));

        System.out.println(familyTree);
        familyTree.sortByName();
        System.out.println(familyTree);
        familyTree.sortByBirthDate();
        System.out.println(familyTree);

    }

    public static FamilyTree readTree() {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read();
    }

    private static void saveTree(FamilyTree familyTree){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree);
    }

    private static FamilyTree testTree(){
        FamilyTree familyTree = new FamilyTree();

        Human maksim = new Human("Максим", LocalDate.of(1972, 11, 22), Gender.Female, null, null);
        Human nataly = new Human("Наталья", LocalDate.of(1972, 4, 9), Gender.Female,null, null);
        familyTree.add(maksim);
        familyTree.add(nataly);
        familyTree.setWedding(maksim, nataly); // женимся

        Human sasha = new Human("Александр", LocalDate.of(1994, 2, 24), Gender.Male, maksim, nataly);
        familyTree.add(sasha);
        sasha.setFather(maksim);
        sasha.setMother(nataly);

        Human vova = new Human("Владимир", LocalDate.of(1994, 2, 24), Gender.Male, maksim, nataly);
        familyTree.add(vova);
        vova.setFather(maksim);
        vova.setMother(nataly);

        Human grandMother = new Human("Людмила", LocalDate.of(1939, 12, 25), Gender.Female, null, null);
        familyTree.add(grandMother);
        maksim.setMother(grandMother); //

        Human sosed = new Human("Алекс", LocalDate.of(1990, 1, 1), Gender.Male, null, null);
        Human sosedka = new Human("Света", LocalDate.of(1991, 10, 10), Gender.Female, null, null);
        familyTree.add(sosed);
        familyTree.add(sosedka);
        familyTree.setWedding(sosed, sosedka); // женимся
        familyTree.setDivorce(sosed, sosedka); // соседи разводятся
        familyTree.remove(5); // соседи удаляются из дерева
        familyTree.remove(6);

        return familyTree;
    }
}
