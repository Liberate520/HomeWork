package ru.gb.family_tree;



public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Dima", "11.11.1950", Gender.Male);
        Human human2 = new Human("Katya","20.03.1980", Gender.Female);
        Human human3 = new Human("Ivan","06.06.1976", Gender.Male);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);

        human1.addChildren(human2);
        human1.addChildren(human3);

        System.out.println(human1.getChildren());
        System.out.println(human2.getParents());
    }
}
