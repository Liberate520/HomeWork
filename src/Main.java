import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree romanovFamilyTree = new FamilyTree();

        Human human1 = new Human("Иван", LocalDate.of(1985,5,14), Gender.Male);
        Human human2 = new HumanWithSpouse("Мария", LocalDate.of(1986,8,5), Gender.Female, human1);
        Human human3 = new HumanWithParents("Павел",LocalDate.of(2015, 1, 2), Gender.Male, human1, human2);

        romanovFamilyTree.addHuman(human1);
        romanovFamilyTree.addHuman(human2);
        romanovFamilyTree.addHuman(human3);

        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);

        System.out.println(romanovFamilyTree);
    }
}