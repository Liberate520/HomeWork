package familyTree;

import familyTree.familyTree.FamilyTree;
import familyTree.human.Gender;
import familyTree.human.People;
import familyTree.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String nameFile = "familyTree.txt";
        FamilyTree ivanov = new FamilyTree();
        People ivan = new People("Иван", Gender.Male, LocalDate.of(1966, 02, 25));
        People masha = new People("Маша", Gender.Female, LocalDate.of(1970, 11, 10));
        ivanov.add(ivan);
        ivanov.add(masha);

        People dmitriy = new People("Дмитрий", Gender.Male, LocalDate.of(1988, 07, 15), masha, ivan);
        ivanov.add(dmitriy);
        System.out.println(ivanov);
        System.out.println("=============================");
        FileHandler fileHandler = new FileHandler();
        fileHandler.saveFamilyTree(nameFile, ivanov.getTree());
        System.out.println(fileHandler.loadFamilyTree(nameFile));

    }
}
