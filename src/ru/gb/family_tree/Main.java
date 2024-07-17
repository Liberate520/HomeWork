package ru.gb.family_tree;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        fillingFamilyTree(familyTree);
        System.out.println(familyTree.toString());
    }

    public static void fillingFamilyTree(FamilyTree familyTree) {
        Human grandfather1 = new Human("Герман", Gender.Male, 1935, 1, 1);
        Human grandmother1 = new Human("Валентина", Gender.Female, 1934, 9, 25);

        grandfather1.setSpouse(grandmother1);
        grandmother1.setSpouse(grandfather1);

        Human grandfather2 = new Human("Павел", Gender.Male, 1940, 10, 12);
        Human grandmother2 = new Human("Мария", Gender.Female, 1939, 7, 21);

        grandfather2.setSpouse(grandmother2);
        grandmother2.setSpouse(grandfather2);

        Human father = new Human("Николай", Gender.Male, 1963, 3, 23);
        father.setParents(grandfather1, grandmother1);

        grandfather1.setChild(father);
        grandmother1.setChild(father);

        Human mother = new Human("Надежда", Gender.Female, 1961, 11, 11);
        mother.setParents(grandfather2, grandmother2);

        grandfather2.setChild(mother);
        grandmother2.setChild(mother);

        father.setSpouse(mother);
        mother.setSpouse(father);

        Human child = new Human("Антон", Gender.Male, 1985, 7, 21);
        child.setParents(father, mother);

        father.setChild(child);
        mother.setChild(child);

        familyTree.addHuman(grandfather1);
        familyTree.addHuman(grandmother1);
        familyTree.addHuman(grandfather2);
        familyTree.addHuman(grandmother2);
        familyTree.addHuman(father);
        familyTree.addHuman(mother);
        familyTree.addHuman(child);
    }
}
