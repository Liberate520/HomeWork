package homeWork;

import java.time.LocalDate;
import homeWork.model.familyTree.FamilyTree;
import homeWork.model.familyTree.FamilyTreeSorter;
import homeWork.model.familyTree.TreePrinter;
import homeWork.model.gender.Gender;
import homeWork.model.human.Human;

public class Main {
    public static void main(String[] args) {
        // Создаем объект FamilyTree
        FamilyTree<Human> familyTree = new FamilyTree<>();
        
        // Добавляем людей в дерево
        Human mother = new Human("Мать", LocalDate.of(1970, 5, 15), Gender.Female);
        Human father = new Human("Отец", LocalDate.of(1965, 8, 20), Gender.Male);
        familyTree.addHuman(new Human("Ребенок2", LocalDate.of(2010, 3, 10), Gender.Male, mother, father));
        familyTree.addHuman(new Human("Ребенок4", LocalDate.of(2000, 7, 25), Gender.Female, mother, father));
        familyTree.addHuman(new Human("Ребенок3", LocalDate.of(1995, 9, 5), Gender.Male, mother, father));

        TreePrinter<Human> printer = new TreePrinter<>(familyTree);
        System.out.println(printer.printTree());

        FamilyTreeSorter<Human> sorted = new FamilyTreeSorter<>(familyTree);
        sorted.sortbyName();
        System.out.println(printer.printTree());
        sorted.sortbyDate();
        System.out.println(printer.printTree());
        
    }
}
