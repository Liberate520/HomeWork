import family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = makeTree();
//        saveTree(tree);
        System.out.println(tree);
        tree.sortByName();
        System.out.println(tree);
        tree.sortByAge();
        System.out.println(tree);

//        System.out.println(readTree());
    }

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

        public static FamilyTree makeTree() {
            FamilyTree tree = new FamilyTree();

            Human ivan = new Human("Иван", Gender.male, LocalDate.of(2000, 02, 20));
            Human maria = new Human("Мария", Gender.female, LocalDate.of(1999, 01, 02));
            Human elena = new Human("Елена",Gender.female,LocalDate.of(1985,10,11));
            Human stepan = new Human("Степан",Gender.male,LocalDate.of(1955,11,11));
            Human alexey = new Human("Алексей",Gender.male,LocalDate.of(1988,12,12));
            Human roman = new Human("Роман",Gender.male,LocalDate.of(1989,05,18));
            Human irina = new Human("Ирина",Gender.female,LocalDate.of(1958,03,14));
            Human olga = new Human("Ольга",Gender.female,LocalDate.of(1990,06,10),irina,stepan);
            Human vera = new Human("Вера",Gender.female,LocalDate.of(1992,07,12),irina,stepan);



            tree.add(ivan);
            tree.add(maria);
            tree.add(elena);
            tree.add(stepan);
            tree.add(roman);
            tree.add(irina);
            tree.add(olga);
            tree.add(vera);


//        tree.setWedding(ivan,maria);
            return tree;

        }

}





