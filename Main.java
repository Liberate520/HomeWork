import java.time.LocalDate;

import family_tree.FamilyTree;
import family_tree.FamilyTreeService;
import human.Gender;
import human.Human;
import places.Place;
import writers.FileHandler;

public class Main {
        public static void main(String[] args) {
                FamilyTreeService service = new FamilyTreeService();
                Place tula = new Place(13, "Ленина", "Тульская", "Россия", 301200, "Тула");
                service.addPlace(tula.getHomeNumber(), tula.getStreet(), tula.getRegion(), tula.getCountry(),
                                tula.getPostalCode(), tula.getLocality());
                service.addHuman("Иван", "Иванов", "Иванович", LocalDate.of(1970, 5, 10), null, Gender.MALE, "Русский",
                                null, null, null, null, tula);
                service.addHuman("Мария", "Иванова", "Ивановна", LocalDate.of(1975, 3, 15), null, Gender.FEMALE,
                                "Русский", null, null, null, null, tula);
                service.addHuman("Петр", "Иванов", "Иванович", LocalDate.of(2000, 1, 1), null, Gender.MALE, "Русский",
                                null, null, null, null, tula);
                service.addHuman("Аня", "Иванова", "Ивановна", LocalDate.of(2005, 6, 20), null, Gender.FEMALE,
                                "Русский", null, null, null, null, tula);
                service.addHuman("Владимир", "Петров", "Иванович", LocalDate.of(1947, 12, 31), null, Gender.MALE, null,
                                null, null, null, null, tula);
                service.addHuman("Елена", "Петрова", "Ивановна", LocalDate.of(1950, 8, 5), null, Gender.FEMALE, null,
                                null, null, null, null, tula);

                System.out.println(service.getFamilyTreeInfo());
                service.sortByLastName();
                System.out.println(service.getFamilyTreeInfo());
                service.sortByBirthDate();
                System.out.println(service.getFamilyTreeInfo());

                // FamilyTree tree = russianTree();
                // // System.out.println(tree);
                // FileHandler fileHandler = new FileHandler();
                // fileHandler.write(tree);
                // Object readObject = fileHandler.read();
                // if (readObject instanceof FamilyTree) {
                // System.out.println((FamilyTree) readObject);
                // } else {
                // System.out.println("Ошибка: Не удалось загрузить семейное дерево.");
                // }
                // }

                // private static FamilyTree russianTree() {
                // FamilyTree tree = new FamilyTree();
                // Town Tula = new Town(5, "Ленина", "Тульская", "Россия", 301200, "Тула");
                // Human vanya = new Human("Иван", "Иванов", "Иванович", LocalDate.of(1970, 5,
                // 10), null, Gender.MALE,
                // null, Tula,
                // null);
                // Human masha = new Human("Мария", "Иванова", "Ивановна", LocalDate.of(1975, 3,
                // 15), null, Gender.FEMALE,
                // null,
                // Tula, null);
                // Human petya = new Human("Петр", "Иванов", "Иванович", LocalDate.of(2000, 1,
                // 1), null, Gender.MALE,
                // "Русский",
                // vanya, masha, null, null, Tula, null);
                // Human anya = new Human("Аня", "Иванова", "Ивановна", LocalDate.of(2005, 6,
                // 20), null, Gender.FEMALE,
                // "Русский",
                // vanya, masha, null, null, Tula, null);
                // Human vladimir = new Human("Владимир", "Иванов", "Иванович",
                // LocalDate.of(1947, 12, 31), null,
                // Gender.MALE,
                // null, Tula, null);
                // tree.addHuman(vanya);
                // tree.addHuman(masha);
                // tree.addHuman(petya);
                // tree.addHuman(anya);
                // tree.addHuman(vladimir);
                // tree.setWeeding(vanya, masha);
                // vladimir.addChild(vanya);
                // return tree;
        }
}
