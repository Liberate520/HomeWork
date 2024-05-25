package OOP.SemDZ.homeWork;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree tree = new FamilyTree();

        Human human1 = new Human("Adam", Gender.Male, LocalDate.of(1975, 10, 21));
        Human human2 = new Human("Eva", Gender.Female, LocalDate.of(1980,11,10));
        Human human3 = new Human("Masha", Gender.Female, LocalDate.of(1998, 04, 15), human1, human2);

        tree.add(human1);
        tree.add(human2);
        tree.add(human3);

        System.out.println(human3.getMather());
        System.out.println(human3.getName());
        System.out.println(human3.getId());
        System.out.println(human1.getSpouse());

        tree.wedding(human1, human2);

        System.out.println(human1.getSpouse().getName());
    }
}
