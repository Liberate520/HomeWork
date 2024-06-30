import Formating.Gender;
import Formating.MyDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human Lilia = new Human("Lilia", "Kornaval", Gender.Female, new MyDate(2000, 9, 15));
        Human Nastya = new Human("Nastya", "Kornaval", Gender.Female, new MyDate(2022, 4, 30));
        Human Nicolay = new Human("Nicolay", "Kornaval", Gender.Male, new MyDate(1999,12, 3));
        Human Kiril = new Human("Kiril", "Kornaval", Gender.Male, new MyDate(2023, 5, 13));
        Human Olga = new Human("Olga", "Burnova", Gender.Female, new MyDate(1980, 8, 19));

        Nicolay.setDataOfDeath(new MyDate(2024, 1, 9));

        Nicolay.addChildren(Nastya);

        Lilia.setSpouse(Nicolay);

        Lilia.addChildren(Kiril);

        familyTree.addHuman(Nastya);

        System.out.println(familyTree);

        System.out.println("-------------------------------------------------------------------");

        Lilia.setMather(Olga);

        System.out.println(familyTree);
    }
}
