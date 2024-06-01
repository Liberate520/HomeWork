import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args){

        FamilyTree familyTree = new FamilyTree();
        FileHandler fileHandler = new FileHandler();
        String filename = "familyTree.dat";

        Human john = new Human("John", LocalDate.of(1980, 5, 15), Gender.Male);
        Human jane = new Human("Jane", LocalDate.of(1982, 7, 10), Gender.Female);
        Human mary = new Human("Mary", LocalDate.of(2010, 3, 25), Gender.Female);
        Human anna = new Human("Anna", LocalDate.of(1955, 2, 17), LocalDate.of(2020, 1, 20), Gender.Female);

        john.addChild(mary);
        jane.addChild(mary);
        anna.addChild(john);

        familyTree.addHuman(john);
        familyTree.addHuman(jane);
        familyTree.addHuman(mary);
        familyTree.addHuman(anna);

        // Запись в файл
        try {
            fileHandler.writeToFile(filename, familyTree.getPeople());
            System.out.println("Данные успешно записаны в файл " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение из файла
        try {
            List<Human> peopleFromFile = fileHandler.readFromFile(filename);
            familyTree.setPeople(peopleFromFile);
            System.out.println("Данные успешно считаны из файла " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Проводим исследование: находим детей Anna
        Human targetHuman = familyTree.getHumanByName("Anna");
        if (targetHuman != null) {
            List<Human> children = familyTree.getChildrenOf(targetHuman);
            System.out.println("Дети " + targetHuman.getName() + ": " + children);
        } else {
            System.out.println("Человек не найден");
        }

        
    }
}

