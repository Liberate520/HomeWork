import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Олеся", Gender.FEMALE, LocalDate.of(1978, 4, 1), null);
        Human human2 = new Human("Тимофей", Gender.MALE, LocalDate.of(2012, 2, 4), null);
        Human human3 = new Human("Татьяна", Gender.FEMALE, LocalDate.of(1959, 8, 16), null);
        Human human4 = new Human("Валера", Gender.MALE, LocalDate.of(1958, 4, 20), null);
        Human human5 = new Human("Маргарита", Gender.FEMALE, LocalDate.of(1933, 5, 18), LocalDate.of(2012, 7, 30));
        Human human6 = new Human("Владимир", Gender.MALE, LocalDate.of(1934, 3, 7), LocalDate.of(2012, 7, 30));

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);

        familyTree.setParentChildRelationship(human3, human1); // мать Олеси
        familyTree.setParentChildRelationship(human4, human1); // отец Олеси
        familyTree.setParentChildRelationship(human1, human2); // мать Тимофея
        familyTree.setParentChildRelationship(human5, human3); // мать Татьяны
        familyTree.setParentChildRelationship(human6, human3); // отец Татьяны

        familyTree.printFamilyRelationships();
    }
}