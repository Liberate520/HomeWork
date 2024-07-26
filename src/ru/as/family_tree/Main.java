package ru.as.family_tree;

import ru.as.family_tree.generation_tree.FamilyTree;
import ru.as.family_tree.human.Gender;
import ru.as.family_tree.human.Human;
import ru.as.family_tree.human.Parents;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree= new FamilyTree();

        Human human1 = new Human("Александр",LocalDate.of(2000,2,1), Gender.Male);
        Human human2 = new Parents("Наталья",LocalDate.of(1977,6,23), Gender.Female,"Mother");
        Human human3 = new Parents("Сергей",LocalDate.of(1976,5,7), Gender.Male, "Father");
        Human human4 = new Parents("Мария",LocalDate.of(1938,6,23), Gender.Female,"Grandmother");
        Human human5 = new Parents("Павел",LocalDate.of(1935,1,1), Gender.Male, "Grandfather");
        Human human6 = new Parents("Ольга",LocalDate.of(1936,11,8), Gender.Female, "Grandmother");
        Human human7 = new Parents("Вячеслав",LocalDate.of(1936,7,25), Gender.Male, "Grandfather");

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);


        System.out.println(familyTree);
    }
}