import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Human h1 = new Human("Nikolai", Gender.Male , LocalDate.of(1957, 12, 22));
        Human h2 = new Human("Irina", Gender.Female, LocalDate.of(1959, 11, 16));
        Human h3 = new Human("Anna", Gender.Female, LocalDate.of(1985, 5, 14));
        Human h4 = new Human("ALeksandr", Gender.Male, LocalDate.of(1988, 6, 6));
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
        System.out.println(family.allChildren(h2));

    }
}