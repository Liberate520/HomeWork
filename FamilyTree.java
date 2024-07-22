import java.time.LocalDate;

public class FamilyTree {
    public static void main(String[] args) {
        Town Tula = new Town(13, "Lenina", "Tulskaya", "Russia", 301200, "Tula");
        Parent Father = new Parent("Ivan", "Ivanov", "Ivanovich", LocalDate.of(1960, 5, 15), null, Gender.MALE,
                "Russian", null, Tula, null);
        Parent Mother = new Parent("Maria", "Ivanova", "Ivanovna", LocalDate.of(1965, 10, 20), null, Gender.FEMALE,
                "Russian", null, Tula, null);
        Human Child = new Human("Ilya", "Ivanov", "Ivanovich", LocalDate.of(1990, 3, 10), null, Gender.MALE, "Russian",
                Father,
                Mother, null, Tula, null);
        System.out.println(Tula);
        System.out.println(Father);
        System.out.println(Mother);
        System.out.println(Child);
    }
}