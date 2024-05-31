package ru.gb.family;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main implements Serializable {
    public static void main(String[] args)  {
        String saveFilePath = "src/ru/gb/family/data/FamilyTree.txt";
        System.out.println(saveFilePath);
        //FamilyTree familyTre = generatFamalyTree();
        FamilyTree familyTre = read(saveFilePath);
        Human humanSearch = new Human("Васильев Николай Михайлович",LocalDate.of(1954,1, 15),LocalDate.of(2010,5, 1),Gender.Male);
        System.out.println(familyTre);
        System.out.println(familyTre.findHuman(humanSearch));
        save(familyTre,saveFilePath);

    }
    public static void save(FamilyTree familyTree, String filePath){
        Writable writable = new FileHandler();
        writable.save( familyTree,filePath);
    }
    public static FamilyTree read(String filePath){
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read(filePath);

    }


    public static FamilyTree generatFamalyTree(){
        FamilyTree familyTree = new FamilyTree();
        List<Human> children1 = new ArrayList<>();
        Human human1 = new Human("Васильев Роман Максимович",LocalDate.of(2015,5, 6),null,Gender.Male);
        Human human2 = new Human("Васильев Максим Николаевич",LocalDate.of(1986,6, 21),null,Gender.Male);
        Human human3 = new Human("Васильева Татьяна Владимировна",LocalDate.of(1987,10, 17),null,Gender.Female);

        Human human4 = new Human("Васильева Алина Андреевна",LocalDate.of(2018,3, 8),null,Gender.Female);
        Human human5 = new Human("Васильев Андрей Николаевич",LocalDate.of(1990,8, 1),null,Gender.Male);
        Human human6 = new Human("Васильева Наталья Николаевна",LocalDate.of(1988,7, 11),null,Gender.Female);

        Human human7 = new Human("Васильев Николай Михайлович",LocalDate.of(1954,1, 15),LocalDate.of(2010,5, 1),Gender.Male);
        Human human8 = new Human("Васильева Надежда Николаевна",LocalDate.of(1954,1, 28),null,Gender.Female);

        human1.addCParent(human2);
        human1.addCParent(human3);
        human2.addChildren(human1);
        human3.addChildren(human1);

        human4.addCParent(human5);
        human4.addCParent(human6);
        human5.addChildren(human4);
        human6.addChildren(human4);

        human2.addCParent(human7);
        human2.addCParent(human8);

        human5.addCParent(human7);
        human5.addCParent(human8);

        human7.addChildren(human2);
        human7.addChildren(human5);

        human8.addChildren(human2);
        human8.addChildren(human5);
        familyTree.addHumanInTree(human1);
        familyTree.addHumanInTree(human2);
        familyTree.addHumanInTree(human3);
        familyTree.addHumanInTree(human4);
        familyTree.addHumanInTree(human5);
        familyTree.addHumanInTree(human6);
        familyTree.addHumanInTree(human7);
        familyTree.addHumanInTree(human8);
        return familyTree;
    }

}