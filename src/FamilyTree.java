public class FamilyTree {

    public static void main(String[] args) {
        Human human = new Human("Edvard Hichichickoy","11.07.1886","24.05.1920",Gender.MAN,FamilyStatus.HUSBAND);

        Human human1 = new Human("Elena Hichichickoy","20.04.1890","05.08.1930",Gender.WOMAN,FamilyStatus.WIFE);

        human.setDateOfMarriage("07.07.1907");
        human1.setDateOfMarriage("07.07.1907");
        human.setWhoSpouse(human1);
        human1.setWhoSpouse(human);

        Human human2 = new Human("Betsy Hichichickoy","09.10.1908","12.11.1960",Gender.WOMAN,FamilyStatus.WIFE);
        Human human3 = new Human("Rebecca Hichichickoy", "05.01.1910", "12.02.1990",Gender.WOMAN,FamilyStatus.WIFE);
        human2.addParents(human);
        human2.addParents(human1);
        human3.addParents(human);

        human3.addParents(human1);
        human.addChildren(human2);
        human.addChildren(human3);

        human1.addChildren(human2);
        human1.addChildren(human3);

        System.out.println(human.toString());
        human.printChildren();
        System.out.println(human1.toString());
        human1.printChildren();

        System.out.println(human2.toString());
        human2.printParents();

        System.out.println(human3.toString());
        human3.printParents();
    }
}
