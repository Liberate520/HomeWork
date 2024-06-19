package lv.homeWork;

import lv.homeWork.view.ConsoleUI;
import lv.homeWork.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();




    }
//        FamilyTree tree = onlyForTesting();
//        String pathToFile = "src/testTree.txt";
//        System.out.println(onlyForTesting());
//        //save(tree, pathToFile);
    }


//
//
//    public static FamilyTree Load(String pathToFile){
//        Writable writable = new FileHandler();
//        return (FamilyTree) writable.read(pathToFile);
//    }
//
//    public static void save(FamilyTree tree, String pathToFile){
//        Writable writable = new FileHandler();
//        writable.save(tree,pathToFile);
//    }
//
//    public static FamilyTree onlyForTesting(){
//
//        FamilyTree tree = new FamilyTree<>();
//
//        Human glory1 = new Human(123321,"Glory Smith", Gender.Female,LocalDate.of(1961,1,23));
//
//        Human michael1 = new Human(111243, "Michael Smith", Gender.Male, LocalDate.of(1988, 3, 12));
//
//        Human victoria1 = new Human(123243, "Victoria Smith", Gender.Female, LocalDate.of(1990, 2, 19));
//
//        Human lory1 = new Human(123243, "Lory Smith", Gender.Female, LocalDate.of(2002, 10, 22), victoria1, michael1);
//
//        Human jack1 = new Human(156243, "Jack Smith", Gender.Female, LocalDate.of(2000, 10, 22), victoria1, michael1);
//
//        Human samuel1 = new Human(184321, "Samuel Atkinson",Gender.Male,LocalDate.of(1958,6,22));
//
//        Human sam1 = new Human(345123, "Sam Smith", Gender.Male,LocalDate.of(1960,4,14));
//
//        Human samantha1 = new Human(234123, "Samantha Atkinson", Gender.Female, LocalDate.of(1965,3,27));
//
//
//        tree.addHuman(samuel1);
//        tree.addHuman(glory1);
//        tree.addHuman(michael1);
//        tree.addHuman(victoria1);
//        tree.addHuman(lory1);
//        tree.addHuman(jack1);
//        tree.addHuman(sam1);
//        tree.addHuman(samantha1);
//
//        samuel1.addChild(victoria1);
//        samantha1.addChild(victoria1);
//        glory1.addChild(michael1);
//        sam1.addChild(michael1);
//        michael1.addChild(lory1);
//        michael1.addChild(jack1);
//        victoria1.setMarried(michael1);
//        victoria1.addChild(lory1);
//        victoria1.addChild(jack1);
//
//        tree.sortByGen();
//
//        sam1.setDateOfDeath(LocalDate.of(2022,2,26));
//
//        System.out.println(sam1.getDateOfDeath());
//
////        tree.sortByBrith();
//
//
//            return tree;
//
//        }
//    }





