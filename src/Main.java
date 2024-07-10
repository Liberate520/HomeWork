import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.writer.FileHandler;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //FamilyTree tree =  testTree();
       FamilyTree tree = readTree();
       //saveTree(tree);
        System.out.println(tree);
    }

    private static FamilyTree readTree () {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read();
    }
    private static void saveTree (FamilyTree tree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);}

    private static FamilyTree testTree;{
        FamilyTree tree = new FamilyTree();


        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963, 12, 10));
        Human maria = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15));

        tree.add(vasya);
        tree.add(maria);
        tree.setWedding(vasya, maria);

        Human cristina = new Human("Кристина", Gender.Female, LocalDate.of(1998, 7, 5));
        Human simyon = new Human("Семён", Gender.Male, LocalDate.of(1991, 1, 25));

        tree.add(cristina);
        tree.add(simyon);

        Human grandMother = new Human("Лариса", Gender.Female, LocalDate.of(1945, 9, 1));
        grandMother.addChild(vasya);

        tree.add(grandMother);

        return tree;


      //  System.out.println(tree);


    }
}
