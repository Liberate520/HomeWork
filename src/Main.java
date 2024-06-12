
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args){

        FamilyTree<Human> familyTree = new FamilyTree<>();
        FileHandler fileHandler = new FileHandler();
        String filename = "familyTree.dat";

        Human john = new Human("John", LocalDate.of(1980, 5, 15), Gender.Male);
        Human jane = new Human("Jane", LocalDate.of(1982, 7, 10), Gender.Female);
        Human mary = new Human("Mary", LocalDate.of(2010, 3, 25), Gender.Female);
        Human anna = new Human("Anna", LocalDate.of(1955, 2, 17), LocalDate.of(2020, 1, 20), Gender.Female);

        john.addChild(mary);
        jane.addChild(mary);
        anna.addChild(john);

        familyTree.addMember(john);
        familyTree.addMember(jane);
        familyTree.addMember(mary);
        familyTree.addMember(anna);

       // Запись в файл объекта Annа
       try {
           //fileHandler.writeToFile(filename, (Serializable) familyTree.getPeople());
           fileHandler.writeToFile(filename, familyTree);
           System.out.println("Данные успешно записаны в файл " + filename);
       } catch (IOException e) {
           e.printStackTrace();
       }

       // Чтение из файла
       try {
           @SuppressWarnings("unchecked")
           FamilyTree<Human> loadedTree = (FamilyTree<Human>) fileHandler.readFromFile(filename);
           System.out.println("Данные успешно считаны из файла " + filename);
           List<String> memberDescriptions = loadedTree.getMemberDescriptions();
           for (String description : memberDescriptions) {
               System.out.println(description);
           }
       } catch (IOException | ClassNotFoundException e) {
           e.printStackTrace();
       }

       // Проводим исследование: находим детей Anna
       Human targetHuman = (Human) familyTree.getHumanByName("Anna");
       if (targetHuman != null) {
           List<TreeMember> children = familyTree.getChildrenOf(targetHuman);
           System.out.println("Дети " + targetHuman.getName() + ": " + children);
       } else {
           System.out.println("Человек не найден");
       }

        // Сортировка по имени
        familyTree.sortByName();

        List<String> sortedByNameDescriptions = familyTree.getMemberDescriptions();
        System.out.println("Семья, отсортированная по имени:");
        for (String description : sortedByNameDescriptions) {
            System.out.println(description);
        }

        // Сортировка по дате рождения
        familyTree.sortByBirthDate();

        List<String> sortedByBirthDateDescriptions = familyTree.getMemberDescriptions();
        System.out.println("Семья, отсортированная по дате рождения:");
        for (String description : sortedByBirthDateDescriptions) {
            System.out.println(description);
        }

        
    }
}

