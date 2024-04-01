package src.family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        firstAdd();
    }

    public static void firstAdd() {
        Human ivan = new Human();
        ivan.setName("Ivan");
        ivan.setDob(LocalDate.of(1945, 5, 28));
        ivan.setDod(LocalDate.of(2021, 8, 22));
        ivan.setGender(Gender.Male);


        Human zoia = new Human();
        zoia.setName("Zoia");
        zoia.setDob(LocalDate.of(1950, 1, 1));
        zoia.setDod(LocalDate.of(2021, 2, 19));
        zoia.setGender(Gender.Female);

        Human kostia = new Human();
        kostia.setName("Kostia");
        kostia.setDob(LocalDate.of(1973, 12, 13));
        kostia.setGender(Gender.Male);
        kostia.setMother(zoia);
        zoia.setFather(ivan);

        ivan.setChildren(kostia);
        zoia.setChildren(kostia);

        System.out.println(ivan.getDod().getYear() - ivan.getDob().getYear());
        System.out.println(kostia);
    }
}