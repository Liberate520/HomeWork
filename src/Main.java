import pack.Family_Tree;
import pack.Gender;
import pack.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        try {
//
//            Writable fileHandler = new FileHandler();
            Family_Tree familyTree = new Family_Tree();
            Human human = new Human();

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

//        System.out.println(human1.getInfo());
//        System.out.println(human2.getInfo());
//        System.out.println(human3.getInfo());
            human1.setSpouse(human2);
//        System.out.println(human1.getInfo());
//        System.out.println(human2.getInfo());
//        System.out.println(human3.getInfo());
            human4.getBrothers();
            human4.getSisters();
//        System.out.println(human1.getInfo());
//        System.out.println(human2.getInfo());
//          System.out.println(human3.getInfo());
//        System.out.println(human4.getInfo());
//        System.out.println(human5.getInfo());


        familyTree.printFamilyTree();




//            fileHandler.writeObjectToFile(human1);
//            System.out.println("Объект " + human1.getName() + " сериализован в файл");
//
//
//            Human deserializedHuman1 = (Human) fileHandler.recoverObjectFromFile();
//            System.out.println("Объект десериализован из файла: ");
//            deserializedHuman1.getInfo();
//
//            fileHandler.serializeObjectToByteArray(human2);
//            System.out.println("Объект " + human2.getName() + " сериализован в байтовый массив");
//
//
//            Human deserializedHuman2 = (Human) fileHandler.recoverObjectFromByteArray();
//            System.out.println("Объект десериализован из байтового массива: ");
//            deserializedHuman2.getInfo();
//
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }


    }
}

