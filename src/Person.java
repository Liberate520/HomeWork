import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private FullName fullName;
    private String gender;
    private LocalDate dateOfBirth;
    private List<Person> parents;
    private List<Person> children;

    public Person(String familyName, String firstName, String fatherName, String gender, LocalDate dateOfBirth) {
        this.fullName = new FullName(familyName, firstName, fatherName);
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public FullName getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addParent(Person parent) {
        this.parents.add(parent);
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName=" + fullName +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}