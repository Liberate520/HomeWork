import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human petr = new Human("Petr", "Petrov", LocalDate.of(1990, 1, 1), Gender.male);
        Human elena = new Human("Elena", "Ivanova", LocalDate.of(1990, 2, 25), Gender.female);
        Human polina = new Human("Polina", "Petrova", LocalDate.of(2010, 3, 15), Gender.female);
        Human igor = new Human("Igor", "Petrov", LocalDate.of(1950, 10, 13), LocalDate.of(2010, 8, 18), Gender.male);


        elena.addChildren(polina);
        petr.addChildren(polina);
        petr.setParent(igor);

        familyTree.addHuman(petr);
        familyTree.addHuman(elena);
        familyTree.addHuman(polina);
        familyTree.addHuman(igor);
        familyTree.setWedding(petr, elena);

        System.out.println(familyTree);


    }
}
