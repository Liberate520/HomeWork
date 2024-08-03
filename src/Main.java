import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree);
    }
    private static FamilyTree testTree(){
        FamilyTree familyTree = new FamilyTree();
        Human lesha = new Human("Алексей", Gender.Male, LocalDate.of(1978, 9, 23));
        Human lena = new Human("Елена", Gender.Female, LocalDate.of(1981, 6, 15));
        familyTree.addHuman(lesha);
        familyTree.addHuman(lena);
        Human maria = new Human("Мария", Gender.Female, LocalDate.of(2003, 5, 23), null,  lesha, lena);
        Human sasha = new Human("Александр", Gender.Male, LocalDate.of(2001, 11, 17), null, lesha, lena);
        familyTree.addHuman(maria);
        familyTree.addHuman(sasha);
        Human raisa = new Human("Раиса", Gender.Female, LocalDate.of(1954, 8, 4));
        raisa.addChild(lena);
        familyTree.addHuman(raisa);

        return familyTree;

    }
}
