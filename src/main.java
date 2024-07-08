import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Иванов Алексей Васильевич", Gender.Male, LocalDate.of(1957, 6, 30));
        Human human2 = new Human("Иванова Маргарита Степановна", Gender.Female, LocalDate.of(1958, 3, 10));
        Human human3 = new Human("Иванова Светлана Алексеевна", Gender.Female, LocalDate.of(1992, 2, 21));
        Human human4 = new Human("Иванов Матвей Алексеевич", Gender.Male, LocalDate.of(1993, 4, 12));

        human1.setDateOfDeath(LocalDate.of(2000, 8, 5));
        human1.setChildren(human3);
        human1.setChildren(human4);

        human2.setChildren(human3);
        human2.setChildren(human4);

        human3.setFather(human1);
        human3.setMother(human2);
        
        human4.setFather(human1);
        human4.setMother(human2);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);

        System.out.println("Семейное древо: " + "\n" + human4);
        System.out.println();
        System.out.println("Мать: " + "\n" + human4.getMother());
        System.out.println();
        System.out.println("Отец: " + "\n" + human4.getFather());
        System.out.println();
        System.out.println("Дети: " + "\n" + human4.getChildren());
        System.out.println();
        System.out.println(familyTree);

    }

}
