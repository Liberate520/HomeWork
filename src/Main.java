package family;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Human h1 = new Human("Сергей", 1964, Gender.Male);
        Human h2 = new Human("Светлана", 1964, Gender.Female);
        Human h3 = new Human("Алексей", 1985, Gender.Male);
        Human h4 = new Human("Никита", 1993, Gender.Male);

        familyTree.addHuman(h1);
        familyTree.addHuman(h2);
        familyTree.addHuman(h3);
        familyTree.addHuman(h4);

        // Set parent-child relationships
        h1.setFather(h1);
        h3.setMother(h2);
        h4.setFather(h1);
        h4.setMother(h2);

        System.out.println("Генеалогическое древо:");
        System.out.println(familyTree);
    }
}
