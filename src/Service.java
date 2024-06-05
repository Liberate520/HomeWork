import Persons.Enums.Gender;
import Persons.Person;
import Persons.PersonBuilder;
import PersonsTree.FamilyTree;

public class Service {
    private FamilyTree familyTree;
    private PersonBuilder personBuild;

    public Service() {
        familyTree = new FamilyTree();
        personBuild = new PersonBuilder();
    }

    public void addPerson(String name, Gender gender, String birthDate, String deathDate) {
        Person person = personBuild.build(name, gender, birthDate, deathDate);
        familyTree.addPers(person);
    }
    public void addPerson(String name, Gender gender, String birthDate) {
        Person person = personBuild.build(name, gender, birthDate);
        familyTree.addPers(person);
    }
    public void addPerson(String name, Gender gender) {
        Person person = personBuild.build(name, gender);
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
        familyTree.getAllFamily();
    }
    public void getFullPerson(String name) {
        familyTree.getFullPerson(name);
    }
    public void getPersonOnSurname(String name) {
        familyTree.getPersonOnSurname(name);
    }
    public void getFullFamily() {
        familyTree.getFullFamily();
    }
    public void sortedByName() {
        familyTree.sortByName();
        familyTree.getFullFamily();
    }
    public void sortByBirthday() {
        familyTree.sortByBirthday();
        familyTree.getFullFamily();
    }

}