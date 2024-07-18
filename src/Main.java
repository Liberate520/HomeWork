import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person male_1 = new Person("Jack", 60, Gender.MALE);
        male_1.setBirthDate(LocalDate.of(1964,6,14));

        Person female_1 = new Person("Jane", 58, Gender.FEMALE);
        female_1.setBirthDate(LocalDate.of(1966,6,14));

        Person male_2 = new Person("Ted", 60, Gender.MALE);
        male_2.setBirthDate(LocalDate.of(1964,4,24));

        Person female_2 = new Person("Anna", 58, Gender.FEMALE);
        female_2.setBirthDate(LocalDate.of(1966,10,10));

        Person male_3 = new Person("Fred", 40, Gender.MALE);
        male_3.setBirthDate(LocalDate.of(1984,5,17));

        Person female_3 = new Person("Kate", 38, Gender.FEMALE);
        female_3.setBirthDate(LocalDate.of(1986,2,1));

        Person male_4 = new Person("Andrew", 20, Gender.MALE);
        male_4.setBirthDate(LocalDate.of(2004,5,17));

        male_1.addChild(male_3);
        female_1.addChild(male_3);

        male_2.addChild(female_3);
        female_2.addChild(female_3);

        male_3.addChild(male_4);
        female_3.addChild(male_4);

        familyTree.addPerson(male_1);
        familyTree.addPerson(female_1);
        familyTree.addPerson(male_2);
        familyTree.addPerson(female_2);
        familyTree.addPerson(male_3);
        familyTree.addPerson(female_3);
        familyTree.addPerson(male_4);

        System.out.println("Children of Jack (male_1) & Jane (female_1): " + familyTree.getChildren("Jack"));
//        System.out.println("Children of Jane (female_1): " + familyTree.getChildren("Jane"));

        System.out.println("Children of Ted (male_2) & Anna (female_2): " + familyTree.getChildren("Ted"));
//        System.out.println("Children of Anna (female_2): " + familyTree.getChildren("Anna"));

        System.out.println("Children of Fred (male_3) & Kate (female_3): " + familyTree.getChildren("Fred"));
//        System.out.println("Children of Kate (female_3): " + familyTree.getChildren("Kate"));
    }
}