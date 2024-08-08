import family_tree.FamilyTree;
import family_tree.presenter.Presenter;
import family_tree.view.ConsoleUI;
import family_tree.view.View;
import human.Gender;
import human.Human;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static family_tree.view.ConsoleUI.parse;

public class Main {




    public  static void main (String[] args) throws IOException, ClassNotFoundException {

//  1      FamilyTree tree = makeTree();
////        saveTree(tree);
//  1      System.out.println(tree);
//  1      tree.sortByName();
//   1     System.out.println(tree);
//  1      tree.sortByAge();
//   1     System.out.println(tree);

//
        
//1    }

//    private static FamilyTree readTree() throws IOException, ClassNotFoundException {
//        FileHandler fileHandler = new FileHandler();
//        return (FamilyTree) fileHandler.read();
//    }
//
//    private static void saveTree (FamilyTree tree) throws IOException {
//        FileHandler fileHandler = new FileHandler();
//        fileHandler.save(tree);
//
//    }


        //    1    public static FamilyTree makeTree() {
// 1           FamilyTree tree = new FamilyTree();
//1
//  1          Human ivan = new Human("Иван", Gender.male, LocalDate.of(2000, 02, 20));
//  1          Human maria = new Human("Мария", Gender.female, LocalDate.of(1999, 01, 02));
// 1           Human elena = new Human("Елена",Gender.female,LocalDate.of(1985,10,11));
//  1          Human stepan = new Human("Степан",Gender.male,LocalDate.of(1955,11,11));
//   1         Human alexey = new Human("Алексей",Gender.male,LocalDate.of(1988,12,12));
//  1          Human roman = new Human("Роман",Gender.male,LocalDate.of(1989,05,18));
//  1          Human irina = new Human("Ирина",Gender.female,LocalDate.of(1958,03,14));
//  1          Human olga = new Human("Ольга",Gender.female,LocalDate.of(1990,06,10),irina,stepan);
//  1          Human vera = new Human("Вера",Gender.female,LocalDate.of(1992,07,12),irina,stepan);
//
//
//
// 1           tree.add(ivan);
//  1          tree.add(maria);
//  1          tree.add(elena);
// 1           tree.add(stepan);
//  1          tree.add(roman);
//  1          tree.add(irina);
//  1          tree.add(olga);
//  1          tree.add(vera);
//
//
////        tree.setWedding(ivan,maria);
//  1          return tree;
//
//  1
//
//  }


        View view = new ConsoleUI();
        view.start();





    }

}





