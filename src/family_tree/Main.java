package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        //family_tree.family_tree.FamilyTree tree = readTree();
        saveTree(tree);

        System.out.println(tree);

        tree.sortByName();
        System.out.println(tree);

        tree.sortByBirthDate();
        System.out.println(tree);

    }
        private static void saveTree (FamilyTree romanovFamilyTree){
            FileHandler fh = new FileHandler();
            fh.save(romanovFamilyTree);
        }

        private static FamilyTree readTree(){
            FileHandler fh = new FileHandler();
            return (FamilyTree) fh.read();
        }

        private static FamilyTree testTree(){
            FamilyTree romanovFamilyTree = new FamilyTree();

            Human ivan = new Human("Иван", Gender.Male, LocalDate.of(1940, 5, 14));
            Human mariya = new Human("Мария", Gender.Female, LocalDate.of(1940, 8, 5));

            romanovFamilyTree.addHuman(ivan);
            romanovFamilyTree.addHuman(mariya);

            romanovFamilyTree.setWedding(ivan, mariya);

            Human pavel = new Human("Павел", Gender.Male, LocalDate.of(1970, 1, 2), ivan, mariya);
            Human aleksei = new Human("Алексей", Gender.Male, LocalDate.of(1972, 7, 4), ivan, mariya);
            Human anna = new Human("Анна", Gender.Female, LocalDate.of(1974, 5, 3), ivan, mariya);

            romanovFamilyTree.addHuman(pavel);
            romanovFamilyTree.addHuman(aleksei);
            romanovFamilyTree.addHuman(anna);

            Human ekaterina = new Human("Екатерина", Gender.Female, LocalDate.of(1972, 8, 5));
            romanovFamilyTree.addHuman(ekaterina);
            romanovFamilyTree.setWedding(ekaterina, pavel);

            Human elena = new Human("Елена", Gender.Female, LocalDate.of(1972, 9, 5));
            romanovFamilyTree.addHuman(elena);
            romanovFamilyTree.setWedding(elena, aleksei);

            Human petr = new Human("Петр", Gender.Male, LocalDate.of(1972, 1, 5));
            romanovFamilyTree.addHuman(petr);
            romanovFamilyTree.setWedding(petr, anna);

            Human mihail = new Human("Михаил", Gender.Male, LocalDate.of(1995, 5, 3), pavel, ekaterina);
            romanovFamilyTree.addHuman(mihail);

            Human aleksandra = new Human("Александра", Gender.Female, LocalDate.of(1995, 5, 3));
            romanovFamilyTree.addHuman(aleksandra);
            romanovFamilyTree.setWedding(mihail, aleksandra);

            Human anastasiya = new Human("Анастасия", Gender.Female, LocalDate.of(2020, 5, 3), mihail, aleksandra);
            romanovFamilyTree.addHuman(anastasiya);

            romanovFamilyTree.setDivorce(3, 6);
            romanovFamilyTree.remove(6);

            Human dmitriy = new Human("Дмитрий", Gender.Male, LocalDate.of(2004, 5,4));
            romanovFamilyTree.addHuman(dmitriy);
            romanovFamilyTree.setFatherChild(petr,dmitriy); // Внесение данных об отце
            romanovFamilyTree.setMotherChild(anna,dmitriy); // Внесение данных о матери


           // System.out.println(romanovFamilyTree.getByName("Мария")); // поиск человека по имени
          //  System.out.println(romanovFamilyTree.getSiblings(2)); // поиск братьев/сестер

           // System.out.println(pavel.getParents()); // поиск родителей
           // System.out.println(pavel.getChildren()); // поиск детей

           // System.out.println(anastasiya.getFather().getFather().getFather()); // поиск прадеда


           // System.out.println(romanovFamilyTree); // Показать всех членов семьи

            return romanovFamilyTree;
        }


}

