package ru.gb.familytree;

import ru.gb.familytree.FamilyTree.FamilyTree;
import ru.gb.familytree.FamilyTree.Human.Gender;
import ru.gb.familytree.FamilyTree.Human.Human;
import ru.gb.familytree.writer.Filehandler;

import java.time.LocalDate;
import java.util.*;

public class Main {
    final static String filePath = "src/ru/gb/familytree/writer/tree.txt";
    public static void main(String[] args) {
        Human person1 = new Human();
        person1.setName("Иван Иванович Петров");
        person1.setGender(Gender.Male);
        person1.setBirthDate(LocalDate.of(1980, 1, 12));
        person1.setDeathDate(LocalDate.of(2012, 4, 28));

        Human person2 = new Human();
        person2.setName("Людмила Георгевна Маслова");
        person2.setGender(Gender.Female);
        person2.setBirthDate(LocalDate.of(1985, 5, 6));

        Human person3 = new Human();
        person3.setName("Василий Иванович Петров");
        person3.setGender(Gender.Male);
        person3.setBirthDate(LocalDate.of(2004, 3, 3));

        Human person4 = new Human();
        person4.setName("Леона Марковна Алабель");
        person4.setGender(Gender.Female);
        person4.setBirthDate(LocalDate.of(2006, 3, 10));

        Human person5 = new Human();
        person5.setName("Иван Васильевич Петров");
        person5.setGender(Gender.Male);
        person5.setBirthDate(LocalDate.of(2024, 1, 1));

        person1.addChild(person3);
        person2.addChild(person3);

        List<Human> parents3 = new ArrayList<Human>();
        parents3.add(person1);
        parents3.add(person2);
        person3.setParents(parents3);
        person3.addChild(person5);

        person4.addChild(person5);

        List<Human> parents5 = new ArrayList<Human>();
        parents3.add(person3);
        parents3.add(person4);
        person5.setParents(parents5);

        FamilyTree familyTree = new FamilyTree();
        familyTree.setRelative(person1);
        familyTree.setRelative(person2);
        familyTree.setRelative(person3);
        familyTree.setRelative(person4);
        familyTree.setRelative(person5);

        List<Human> person5_grandParents = familyTree.getParentsForHuman(person5).get(0).getParents();
        List<Human> person2_grandChildren = familyTree.getChildrenForHuman(person2).get(0).getChildren();

        Filehandler fileHandler = new Filehandler();
        fileHandler.setPath(filePath);
        fileHandler.save(familyTree);
        familyTree = (FamilyTree) fileHandler.read();

        for (Human human: familyTree) {
            human.setName("123");
        }
    }
    
}
