import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Human sergey = new Human("Sergey", null, null, Gender.Male, LocalDate.of(1981, 7, 17), null);
        System.out.println(sergey.getAge());
        System.out.println(sergey);

        Human maria = new Human("Maria", null, null, Gender.Female, LocalDate.of(1981, 9, 1), null);
        Human ksenia = new Human("Ksenia", null, null, Gender.Female, LocalDate.of(2007, 9,1), null);
        Human julia = new Human("Julia", sergey, maria, Gender.Female, LocalDate.of(2010, 7, 18), null);

        sergey.addChild(ksenia);
        sergey.addChild(julia);
        maria.addChild(ksenia);
        maria.addChild(julia);
        System.out.println(sergey.getChildren());

        ksenia.addParent(maria);
        ksenia.addParent(sergey);
        System.out.println(ksenia.getParents());
        System.out.println(ksenia.getSistersAndBrothers());

        Human nadya = new Human("Nadya", null, null, Gender.Female, LocalDate.of(1950, 2,5), null);
        sergey.addParent(nadya);
        System.out.println(nadya.getBirthDate());
        System.out.println(nadya.getGender());

        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(sergey);
        familyTree.addHuman(maria);
        familyTree.addHuman(ksenia);
        familyTree.addHuman(julia);
        familyTree.addHuman(nadya);
        System.out.println(familyTree);

        Human nadejda = new Human("Nadya", null, null, Gender.Female, LocalDate.of(2012, 12,12), null);
        familyTree.addHuman(nadejda);
        System.out.println( familyTree.findHumansByName("Nadya") );


    }
}