package ru.gb.family_tree;



public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Dima", Gender.Male);
        Human human2 = new Human("Katya", Gender.Female);
        Human human3 = new Human("Ivan", Gender.Male);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);

        human1.addChildren(human2);

        System.out.println(human1.getChildren());
    }
}
