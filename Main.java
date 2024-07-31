package Seminars.Seminars_1.HomeWork.homeWork;

public class Main {
    public static void main(String[] args) {
        Family_tree family_tree = new Family_tree();
        Family_ties familyTies = new Family_ties(family_tree);

        Human human1 = new Human("Мария", "Ж", 67);
        Human human2 = new Human("Василий", "М", 71);
        Human human3 = new Human("Ольга", "Ж", 42);
        Human human4 = new Human("Алексей", "М", 43);
        Human human5 = new Human("Александра", "Ж", 20);
        Human human6 = new Human("Олег", "М", 20);
        Human human7 = new Human("Фатима", "Ж", 1);

        family_tree.addHuman(human1);
        family_tree.addHuman(human2);
        family_tree.addHuman(human3);
        family_tree.addHuman(human4);
        family_tree.addHuman(human5);
        family_tree.addHuman(human6);
        family_tree.addHuman(human7);

        familyTies.addParentChildRelation("Мария", "Ольга");
        familyTies.addParentChildRelation("Василий", "Ольга");
        familyTies.addParentChildRelation("Ольга", "Олег");
        familyTies.addParentChildRelation("Олег", "Фатима");

        for (Human human : family_tree.getPeople()) {
            System.out.println(human.getFamilyInfo());
        }
    }
}
