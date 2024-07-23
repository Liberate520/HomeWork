import java.time.LocalDate;

public class FamilyTree {
        public static void main(String[] args) {
                Town Tula = new Town(13, "Lenina", "Tulskaya", "Russia", 301200, "Tula");
                Human Father = new Human("Ivan", "Ivanov", "Ivanovich", LocalDate.of(1970, 5, 15), null, Gender.MALE,
                                null, Tula, null);
                Human Mother = new Human("Maria", "Ivanova", "Ivanovna", LocalDate.of(1965, 10, 20), Gender.FEMALE,
                                "Russian");
                Human Child = new Human("Ilya", "Ivanov", "Ivanovich", LocalDate.of(1990, 3, 10), Gender.MALE,
                                "Russian");

                // Father.setSpouse(Mother);
                // Mother.setSpouse(Father);
                // Father.addChild(Child);
                // Mother.addChild(Child);
                System.out.println(Tula);
                System.out.println(Father);
                System.out.println(Mother);
                System.out.println(Child);
                System.out.println(Father.getAge());
        }
}