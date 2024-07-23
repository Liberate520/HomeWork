package familyTree.main;

import familyTree.FileHandler.FileHandler;
import familyTree.familyTree.FamilyTree;
import familyTree.human.Gender;
import familyTree.human.Human;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    final static String fileName = "src/familyTree/main/file.txt";

    public static void main(String[] args) throws IOException {
        Human human1 = new Human("Петров", "Валентин", "Петрович", Gender.Male,
                LocalDate.of(1944, 4, 12), "г.Уфа");
        Human human2 = new Human("Петрова", "Галина", "Николаеына", Gender.Female,
                LocalDate.of(1949, 8, 6), "Сибирь");
        Human human3 = new Human("Петров", "Дмитрий", "Валентинович", Gender.Male,
                LocalDate.of(1970, 11, 6), "Сибирь");
        Human human4 = new Human("Смирнова", "Татьяна", "Валентиновна", Gender.Female,
                LocalDate.of(1974, 3, 23), "Сибирь");
        Human human5 = new Human("Петров", "Олег", "Дмитриевич", Gender.Male,
                LocalDate.of(1991, 10, 19), "Сибирь");
        Human human6 = new Human("Петрова", "Марина", "Сергеевна", Gender.Female,
                LocalDate.of(1969, 8, 23), "г. Казань");
        human6.setDayBirth(LocalDate.of(1996, 11, 11));
        Human human7 = new Human("Петров", "Виталий", "Дмитриевич", Gender.Male,
                LocalDate.of(1993, 3, 7), "Сибирь");

        human1.addChild(human3);
        human1.addChild(human4);
        human2.addChild(human3);
        human2.addChild(human4);
        human3.addChild(human5);
        human3.addChild(human7);
        human6.addChild(human5);
        human6.addChild(human7);

        FamilyTree familyTree = new FamilyTree();

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);


        System.out.println(familyTree);

        saveFile(familyTree);

        FamilyTree newFamily = openFile();
        System.out.println(newFamily);
    }

    private static FamilyTree openFile() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setFileName(fileName);
        return (FamilyTree) fileHandler.openFile();
    }

    private static void saveFile(FamilyTree familyTree) {
       FileHandler fileHandler = new FileHandler();
        fileHandler.setFileName(fileName);
        fileHandler.saveFile(familyTree);
    }
}
