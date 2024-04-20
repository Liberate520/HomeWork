import Human.Human;
import Human.Gender;
import FamilyTree.FamilyTree;
import Writer.FileHandler;

import java.time.format.DateTimeFormatter;
import java.time.Period;

import java.time.LocalDate;
public class Main {

    public static void main(String[] args) {
        String filePath = "src\\familyTree.txt";
        Human dima = new Human("Dmitry",
                "Yermoshin",
                Gender.male,
                LocalDate.of(2012, 12, 23));
        Human daniil = new Human("Daniil",
                "Yermoshin", Gender.male,
                LocalDate.of(1984, 8, 28));
        daniil.setChildren(dima);
        dima.addParent(daniil);
        System.out.println(dima.getInfo());
        System.out.println(daniil.getInfo());
        System.out.println(daniil.getChildren());
        Human alina = new Human("Alina",
                "Yermoshina",
                Gender.female,
                LocalDate.of(1986, 10, 8));
        Human yulia = new Human("Yulia", "Yermoshina",
                Gender.female, LocalDate.of(2018, 2, 7));
        daniil.setChildren(yulia);
        alina.setChildren(yulia);
        dima.addParent(alina);
        FamilyTree familyTree = new FamilyTree();
        Human tatyana1 = new Human("Tatyana", "Yermoshina",
                Gender.female, LocalDate.of(1950, 7, 24));
        Human tatyana2 = new Human("Tatyana", "Kuznetsova",
                Gender.female, LocalDate.of(1961, 7, 14));
        Human fedor = new Human("Fedor", "Yermoshin",
                Gender.male, LocalDate.of(1946, 6, 3));
        Human alexander = new Human("Alexander", "Kuznetsov",
                Gender.male, LocalDate.of(1965, 10, 11));
        Human alexey = new Human("Alexey", "Yermoshin",
                Gender.male, LocalDate.of(1989, 1, 31));
        Human kirill = new Human("Kirill", "Yermoshin",
                Gender.male, LocalDate.of(1982, 3, 29));
        Human pavel = new Human("Pavel", "Yermoshin",
                Gender.male, LocalDate.of(1979, 11, 15));
        tatyana1.setChildren(daniil);
        fedor.setChildren(daniil);
        tatyana1.setChildren(alexey);
        fedor.setChildren(alexey);
        tatyana1.setChildren(kirill);
        fedor.setChildren(kirill);
        tatyana1.setChildren(pavel);
        fedor.setChildren(pavel);
        tatyana2.setChildren(alina);
        alexander.setChildren(alina);
        familyTree.addHuman(dima);
        familyTree.addHuman(yulia);
        familyTree.addHuman(alina);
        familyTree.addHuman(daniil);
        familyTree.addHuman(kirill);
        familyTree.addHuman(pavel);
        familyTree.addHuman(alexey);
        familyTree.addHuman(fedor);
        familyTree.addHuman(tatyana1);
        familyTree.addHuman(tatyana2);
        familyTree.addHuman(alexander);
        familyTree.setWedding(daniil, alina);
        familyTree.setWedding(tatyana1, fedor);
        familyTree.setWedding(tatyana2, alexander);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        saveTree(familyTree, filePath);
        for (Object human: familyTree){
            System.out.println(human);
        }
        familyTree.sortByAge();
        System.out.println();
        System.out.println(familyTree);
        familyTree.sortByAgeRevers();
        System.out.println();
        System.out.println(familyTree);
    }
    static void saveTree(FamilyTree tree, String filePath){
        FileHandler handler = new FileHandler();
        handler.save(tree, filePath);
    }
    static FamilyTree read(String filePath){
        FileHandler handler = new FileHandler();
        return (FamilyTree) handler.read(filePath);
    }
}