import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Person {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Person> children;
    private List<Relationship> relationships;

    public Person(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.children = new ArrayList<>();
        this.relationships = new ArrayList<>();
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return deathDate != null ? deathDate.getYear() - birthDate.getYear() : currentDate.getYear() - birthDate.getYear();
    }

    public int getYearsSinceDeath() {
        if (deathDate != null) {
            LocalDate currentDate = LocalDate.now();
            return currentDate.getYear() - deathDate.getYear();
        }
        return 0;
    }

    public boolean isAlive() {
        return deathDate == null;
    }

    public void addRelationship(Person person, RelationshipType type) {
        relationships.add(new Relationship(this, person, type));
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }
    public void addParent(Person parent, RelationshipType type) {
        parent.addChild(this);
        this.addRelationship(parent, type);
    }

    public void addSpouse(Person spouse) {
        this.addRelationship(spouse, RelationshipType.SPOUSE);
        spouse.addRelationship(this, RelationshipType.SPOUSE);
    }

    public String getDeathYear() {
        if (deathDate != null) {
            return String.valueOf(deathDate.getYear());
        } else {
            return "N/A"; // Или любое другое значение, указывающее на отсутствие данных о смерти
        }
    }

}