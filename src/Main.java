import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Human h1 = new Human("Andrey", Gender.Male , LocalDate.of(1971, 10, 7));
        Human h2 = new Human("Irina", Gender.Female, LocalDate.of(1975, 3, 29));
        Human h3 = new Human("Ekaterina", Gender.Female, LocalDate.of(1994, 3, 2));
        Human h4 = new Human("Ilya", Gender.Male, LocalDate.of(2000, 6, 5));
        h3.setMother(h2);
        h3.setFather(h1);
        h4.setMother(h2);
        h4.setFather(h1);


        FamilyTree family = new FamilyTree();
        family.addMember(h1);
        family.addMember(h2);
        family.addMember(h3);
        family.addMember(h4);

        System.out.println(family.allMembers());
        System.out.println(family.allChildren("Irina"));

    }
}
