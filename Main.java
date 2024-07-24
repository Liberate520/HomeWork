import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();

        System.out.println(tree);
    }

    private static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();
        Town Tula = new Town(5, "Ленина", "Тульская", "Россия", 301200, "Тула");
        Human vanya = new Human("Иван", "Иванов", "Иванович", LocalDate.of(1970, 5, 10), null, Gender.MALE, null, Tula,
                null);
        Human masha = new Human("Мария", "Иванова", "Ивановна", LocalDate.of(1975, 3, 15), null, Gender.FEMALE, null,
                Tula, null);
        Human petya = new Human("Петр", "Иванов", "Иванович", LocalDate.of(2000, 1, 1), null, Gender.MALE, "Русский",
                vanya, masha, null, null, Tula, null);
        Human anya = new Human("Аня", "Иванова", "Ивановна", LocalDate.of(2005, 6, 20), null, Gender.FEMALE, "Русский",
                vanya, masha, null, null, Tula, null);
        Human vladimir = new Human("Владимир", "Иванов", "Иванович", LocalDate.of(1947, 12, 31), null, Gender.MALE,
                null, Tula, null);
        tree.addHuman(vanya);
        tree.addHuman(masha);
        tree.addHuman(petya);
        tree.addHuman(anya);
        tree.addHuman(vladimir);
        tree.setWeeding(vanya, masha);
        vladimir.addChild(vanya);
        return tree;
    }
}
