package Family;

import Family.pack.Family_Tree.Family_Tree;
import Family.pack.Human.Gender;
import Family.pack.Human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        try {

//            Writable fileHandler = new FileHandler();
        Family_Tree familyTree = new Family_Tree();
        Human human = new Human();
//            String filePath = "src/Family/test.txt";

        Human human1 = new Human("Jack", LocalDate.of(2000, 10, 3), Gender.Male);
        Human human2 = new Human("Alisa", LocalDate.of(1998, 5, 20), Gender.Female);
        Human human3 = new Human("Artur", LocalDate.of(2023, 1, 21), Gender.Male);
        Human human4 = new Human("Fedya", LocalDate.of(2022, 1, 21), Gender.Male);
        Human human5 = new Human("Nina", LocalDate.of(2023, 1, 21), Gender.Female);


        human1.setDeathDate(LocalDate.of(2021, 10, 2));
        System.out.println(human1.getAge());
        human2.addChild(human3);
        human2.addChild(human4);
        human2.addChild(human5);

        familyTree.sortByName();
        familyTree.printFamilyTree();


//            fileHandler.writeObjectToFile(human1);
//            System.out.println("Объект " + human1.getName() + " сериализован в файл");
//
//
//            Human deserializedHuman1 = (Human) fileHandler.recoverObjectFromFile();
//            System.out.println("Объект десериализован из файла: ");
//            deserializedHuman1.getInfo();

//            fileHandler.writeObjectToFile(familyTree, filePath);
//            Family_Tree deserializedFamilyTree = (Family_Tree) fileHandler.recoverObjectFromFile(filePath);
//            deserializedFamilyTree.printFamilyTree();
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//}

    }
}