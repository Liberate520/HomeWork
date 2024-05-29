package ru.gb.family_tree;



public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Human dima = new Human("Dima", "11.11.1950", Gender.Male);
        Human anna = new Human("Anna", "03.06.1954", Gender.Female);
        Human katya = new Human("Katya","20.03.1980", Gender.Female);
        Human ivan= new Human("Ivan","06.06.1976", Gender.Male);

        familyTree.addHuman(dima);
        familyTree.addHuman(katya);
        familyTree.addHuman(ivan);
        familyTree.addHuman(anna);

        dima.addChildren(katya);
        dima.addChildren(ivan);
        anna.addChildren(katya);
        anna.addChildren(ivan);
        dima.addSpouse(anna);

        //System.out.println(dima.getChildren());
        //System.out.println(katya.getParents());
        //System.out.println(ivan.getParents());
        //System.out.println(anna);
        //System.out.println(dima);
        System.out.println(familyTree);


    }
}
