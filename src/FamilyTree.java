import java.time.LocalDate;

public class FamilyTree {

    public static void main(String[] args) {
        Human human = new Human("Edvard Hichichickoy", LocalDate.of(1886,11,7), LocalDate.of(1920,5,25),Gender.MAN,FamilyStatus.HUSBAND);

        Human human1 = new Human("Elena Hichichickoy",LocalDate.of(1890,4,20),LocalDate.of(1930,8,5),Gender.WOMAN,FamilyStatus.WIFE);

        human.setDateOfMarriage(LocalDate.of(1907,7,7));
        human1.setDateOfMarriage(LocalDate.of(1907,7,7));
        human.setWhoSpouse(human1);
        human1.setWhoSpouse(human);

        Human human2 = new Human("Betsy Hichichickoy",LocalDate.of(1908,10,9), LocalDate.of(1960,11,12),Gender.WOMAN,FamilyStatus.WIFE);
        Human human3 = new Human("Rebecca Hichichickoy", LocalDate.of(1910,1,5), LocalDate.of(1990,2,12),Gender.WOMAN,FamilyStatus.WIFE);
        human2.addParents(human);
        human2.addParents(human1);
        human3.addParents(human);

        human3.addParents(human1);
        human.addChildren(human2);
        human.addChildren(human3);

        human1.addChildren(human2);
        human1.addChildren(human3);

        System.out.println(human);
        human.printChildren();
        System.out.println(human1);
        human1.printChildren();

        System.out.println(human2);
        human2.printParents();

        System.out.println(human3);
        human3.printParents();

        System.out.println();
        human2.writeHuman(human2);
        human2.readHuman();
        human3.writeHuman(human3);
        human3.readHuman();
    }
}
