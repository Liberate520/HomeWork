package my_fam_tree;

import my_fam_tree.structure.FamilyTree;
import my_fam_tree.structure.Human;
import my_fam_tree.structure.IPlant;
import my_fam_tree.structure.Plant;
import my_fam_tree.treeService.FileHandler;
import my_fam_tree.treeService.Writer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main (String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human vladimir = new Human("Владимир", "Мужской", LocalDate.of(1950, 9, 4));
        Human larisa = new Human("Лариса", "Женский", LocalDate.of(1969, 5, 17));
        Human alyona = new Human("Алёна", "Женский", LocalDate.of(1989, 2, 10));
        Human oksana = new Human("Оксана", "Женский", LocalDate.of(1991, 3, 23));
        Human semen = new Human("Семён", "Мужской", LocalDate.of(2017, 6, 9));
        Human timur = new Human("Тимур", "Мужской", LocalDate.of(2018,6,2));

        alyona.setMother(larisa);
        alyona.setFather(vladimir);
        oksana.setFather(vladimir);
        timur.setMother(oksana);
        semen.setMother(alyona);

        vladimir.addChild(alyona);
        vladimir.addChild(oksana);
        oksana.addChild(timur);
        larisa.addChild(oksana);

        familyTree.addHuman(vladimir);
        familyTree.addHuman(larisa);
        familyTree.addHuman(alyona);
        familyTree.addHuman(oksana);
        familyTree.addHuman(timur);
        familyTree.addHuman(semen);

        IPlant plant = new Plant(familyTree);

        System.out.println("Дети Владимира: " + plant.getChildren("Владимир"));
        System.out.println("Родители Алёны: " + java.util.Arrays.toString(plant.getParents("Алёна")));
        System.out.println("Братья и сестры Оксаны: " + plant.getSiblings("Оксана"));
        System.out.println("Пол Владимира: " + vladimir.getGender());
        System.out.println("Пол Ларисы: " + larisa.getGender());
        System.out.println("Информация о Владимире: " + vladimir);
        System.out.println("Информация о Семёне: " + semen);
        System.out.println("Возраст Оксаны: " + calculateAge(oksana.getDateOfBirth()) + " лет");
        System.out.println("Возраст Тимура: " + calculateAge(timur.getDateOfBirth()) + " лет" );

        System.out.println("\nСортировка по имени: ");
        familyTree.sortName();
        for (Human human : familyTree){
            System.out.println(human);
        }
        System.out.println("\nСортировка по дате рождения: ");
        familyTree.sortBirthDate();
        for (Human human : familyTree){
            System.out.println(human);
        }
        Writer writer = new FileHandler();

        try {
            writer.saveToFile("MyFamilyTree.ser", familyTree);
            System.out.println("\nСохранено");

            FamilyTree lTree = writer.loadFromFile("MyFamilyTree.ser");
            System.out.println("Загружено");

            FamilyTree loadTree;
            IPlant loadPlant = new Plant(lTree);
            System.out.println("\nПроверка данных: ");
            System.out.println("Дети Владимира: " + loadPlant.getChildren("Владимир"));
            System.out.println("Родители Алёны: " + java.util.Arrays.toString(loadPlant.getParents("Алёна")));
            System.out.println("Братья и сёстры Оксаны: " + loadPlant.getSiblings("Оксана"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static int calculateAge(LocalDate birthDate){
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}