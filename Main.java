import java.time.LocalDate;

import model.family_tree.FamilyTree;
import model.family_tree.FamilyTreeService;
import model.human.Gender;
import model.human.Human;
import model.places.Place;
import model.places.PlaceBuilder;
import model.writers.FileHandler;
import view.ConsoleUI;
import view.View;

public class Main {
        public static void main(String[] args) {
                View view = new ConsoleUI();
                view.start();
                // FamilyTreeService service = new FamilyTreeService();
                // PlaceBuilder placeBuilder = new PlaceBuilder();
                // Place ttt = placeBuilder.setHomeNumber(15)
                // .setStreet("Ленина")
                // .setRegion("Тульская")
                // .setCountry("Россия")
                // .setPostalCode(301200)
                // .setLocality("Тула")
                // .build();

                // Place tula = placeBuilder.setHomeNumber(
                // 15)
                // .setStreet("Ленина")
                // .setRegion("Тульская")
                // .setCountry("Россия")
                // .setPostalCode(301200)
                // .setLocality("Тула")
                // .build();

                // service.addPlace(ttt.getHomeNumber(), ttt.getStreet(), ttt.getRegion(),
                // ttt.getCountry(),
                // ttt.getPostalCode(), ttt.getLocality());
                // service.addPlace(tula.getHomeNumber(), tula.getStreet(), tula.getRegion(),
                // tula.getCountry(),
                // tula.getPostalCode(), tula.getLocality());

                // service.addHuman("Иван", "Иванов", "Иванович", LocalDate.of(1970, 5, 10),
                // null, Gender.MALE, "Русский",
                // null, null, null, null, tula);
                // service.addHuman("Мария", "Иванова", "Ивановна", LocalDate.of(1975, 3, 15),
                // null, Gender.FEMALE,
                // "Русский", null, null, null, null, tula);
                // service.addHuman("Петр", "Иванов", "Иванович", LocalDate.of(2000, 1, 1),
                // null, Gender.MALE, "Русский",
                // null, null, null, null, tula);
                // service.addHuman("Аня", "Иванова", "Ивановна", LocalDate.of(2005, 6, 20),
                // null, Gender.FEMALE,
                // "Русский", null, null, null, null, tula);
                // service.addHuman("Владимир", "Петров", "Иванович", LocalDate.of(1947, 12,
                // 31), null, Gender.MALE, null,
                // null, null, null, null, tula);
                // service.addHuman("Елена", "Петрова", "Ивановна", LocalDate.of(1950, 8, 5),
                // null, Gender.FEMALE, null,
                // null, null, null, null, tula);

                // System.out.println(service.getFamilyTreeInfo());
                // service.sortByLastName();
                // System.out.println(service.getFamilyTreeInfo());
                // service.sortByBirthDate();
                // System.out.println(service.getFamilyTreeInfo());

        }
}
