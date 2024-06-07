import Organisms.Mammals.Persons.Enums.Gender;
import Organisms.Mammals.Persons.Person;
import PersonsTree.FamilyTree;

public class Service {
    private final FamilyTree familyTree;

    //конструктор
    public Service() {
        familyTree = new FamilyTree();
    }

    public void addPerson(String name, Gender gender, String birthDate, String deathDate) {
        Person person = new Person(name, gender, birthDate, deathDate);
        familyTree.addPers(person);
    }
    public void addPerson(String name, Gender gender, String birthDate) {
        Person person = new Person(name, gender, birthDate);
        familyTree.addPers(person);
    }
    public void addPerson(String name, Gender gender) {
        Person person = new Person(name, gender);
        familyTree.addPers(person);
    }

    public void addParent(String name, String nameParent) {
        Person chield = null,
                parent = null;
        for (Object person : familyTree) {
            if(((Person) person).getName() == name)
                chield = ((Person) person);
            if(((Person) person).getName() == nameParent)
                parent = ((Person) person);
            if(chield != null && parent != null)
                chield.addParent(parent);
        }

    }
    public void addChield(String name, String nameChield) {
        Person parent = null,
                chield = null;
        for (Object person : familyTree) {
            if(((Person) person).getName() == name)
                parent = ((Person) person);
            if(((Person) person).getName() == nameChield)
                chield = ((Person) person);
            if(parent != null && chield != null)
                parent.addParent(chield);
        }
    }
    public void getAllFamily() {
        System.out.println(familyTree.getAllFamily());
    }
    public void getFullPerson(String name) {
        System.out.println(familyTree.getFullPerson(name).toString());
    }
    public void getPersonOnSurname(String name) {
        System.out.println(familyTree.getPersonOnSurname(name).toString());
    }
    public void sortedByName() {
        familyTree.sortByName();
    }
    public void sortByBirthday() {
        familyTree.sortByBirthday();
    }

    public void getFullFamily() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person: familyTree)
            stringBuilder.append(person);
        System.out.println(stringBuilder);
    }
}