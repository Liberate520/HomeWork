import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person ivanovM = new Person("Иванов", "Михаил", "Дмитриевич", Person.Gender.MALE, LocalDate.of(1980, 1, 1));
        Person kuznetzovaLiza = new Person("Кузнецова", "Елизавета", "Сергеевна", Person.Gender.FEMALE, LocalDate.of(1982, 3, 5));
        Person kuznetzovaMary = new Person("Кузнецова", "Мария", "Михайловна", Person.Gender.FEMALE, LocalDate.of(2005, 7, 20));
        Person kuznetzovAl = new Person("Кузнецов", "Александр", "Михайлович", Person.Gender.MALE, LocalDate.of(2007, 11, 15));

        familyTree.addPerson(ivanovM);
        familyTree.addPerson(kuznetzovaLiza);
        familyTree.addPerson(kuznetzovaMary);
        familyTree.addPerson(kuznetzovAl);

        familyTree.addParentChildRelationship("Иванов", "Михаил", "Дмитриевич", "Кузнецова", "Мария", "Михайловна");
        familyTree.addParentChildRelationship("Кузнецова", "Елизавета", "Сергеевна", "Кузнецова", "Мария", "Михайловна");
        familyTree.addParentChildRelationship("Иванов", "Михаил", "Дмитриевич", "Кузнецов", "Александр", "Михайлович");
        familyTree.addParentChildRelationship("Кузнецова", "Елизавета", "Сергеевна", "Кузнецов", "Александр", "Михайлович");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите фамилию:");
        String familyName = scanner.nextLine();

        System.out.println("Введите имя:");
        String firstName = scanner.nextLine();

        System.out.println("Введите отчество:");
        String fatherName = scanner.nextLine();

        List<Person> children = familyTree.findChildrenByFullName(familyName, firstName, fatherName);

        System.out.println("Дети у " + familyName + " " + firstName + " " + fatherName + ":");
        for (Person child : children) {
            System.out.println("\t" + child);
        }
    }
}
