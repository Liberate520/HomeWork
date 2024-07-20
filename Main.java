
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        fillingFamilyTree(familyTree);
        System.out.println(familyTree.toString());
    }

    public static void fillingFamilyTree(FamilyTree familyTree) {
        Human grandfather1 = new Human("Константин", Gender.Male, 1940, 7, 25);
        Human grandmother1 = new Human("Валентина", Gender.Female, 1942, 11, 5);

        grandfather1.setSpouse(grandmother1);
        grandmother1.setSpouse(grandfather1);

        Human grandfather2 = new Human("Андрей", Gender.Male, 1943, 2, 24);
        Human grandmother2 = new Human("Анастасия", Gender.Female, 1943, 8, 16);

        grandfather2.setSpouse(grandmother2);
        grandmother2.setSpouse(grandfather2);

        Human father = new Human("Александр", Gender.Male, 1963, 3, 17);
        father.setParents(grandfather1, grandmother1);

        grandfather1.setChild(father);
        grandmother1.setChild(father);

        Human mother = new Human("Наталья", Gender.Female, 1964, 8, 24);
        mother.setParents(grandfather2, grandmother2);

        grandfather2.setChild(mother);
        grandmother2.setChild(mother);

        father.setSpouse(mother);
        mother.setSpouse(father);

        Human child = new Human("Алексей", Gender.Male, 1985, 6, 11);
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