import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String firstName;
    private String secondName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human spouse;
    private Human mother;
    private Human father;
    private List<Human> children = new ArrayList<>();

    public Human(String firstName, String secondName, LocalDate birthDate, LocalDate deathDate, Gender gender,
                 Human spouse, Human mother, Human father) {
        this.id = -1;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.spouse = spouse;
        this.mother = mother;
        this.father = father;
    }

    public Human(String firstName, String secondName, LocalDate birthDate, Gender gender, Human mother, Human father) {
        this(firstName, secondName, birthDate, null, gender, null, mother, father);
    }

    public Human(String firstName, String secondName, LocalDate birthDate, Gender gender) {
        this(firstName, secondName, birthDate, null, gender, null, null, null);
    }

    public Human(String firstName, String secondName, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this(firstName, secondName, birthDate, deathDate, gender, null, null, null);
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setParent(Human parent) {
        if (parent.gender == Gender.female) {
            this.mother = parent;
        } else {
            this.father = parent;
        }
    }

    public void setParents(Human parent1, Human parent2) {
        this.setParent(parent1);
        this.setParent(parent2);
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public String infoParents() {
        String string1 = "mother: ";
        String string2 = "father: ";
        if (mother == null)
            string1 = string1 + "no data found";
        else string1 = string1 + mother.getName();
        if (father == null)
            string2 = string2 + "no data found";
        else string2 = string2 + father.getName();
        return string1 + "\n" + string2;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public String infoSpouse() {
        String res = "spouse: ";
        if (spouse == null)
            res = res + "single";
        else res = res + spouse.getName();
        return res;
    }

    public void addChildren(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public List<Human> getChildren() {
        return children;
    }

    public String infoChildren() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("children: ");
        if (!children.isEmpty()) {
            for (Human child : children) {
                stringBuilder.append(child.getName()).append(", ");
            }
        } else stringBuilder.append("no children found");
        return stringBuilder.toString();
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public String infoDeathDate() {
        String res;
        if (deathDate == null)
            res = "is alive";
        else res = "death date: " + deathDate.toString();
        return res;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getName() {
        return firstName + " " + secondName;
    }

    public String infoBirthDate() {
        return "birth date: " + birthDate.toString();
    }

    public String infoAge() {
        Integer age;
        String res;
        if (deathDate == null) {
            age = Period.between(birthDate, LocalDate.now()).getYears();
            res = age.toString() + " years";
        } else {
            age = Period.between(birthDate, deathDate).getYears();
            res = "died at " + age.toString() + " years";
        }
        return res;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("======\n").append("id ").append(getId()).append(",\n");
        info.append(getName()).append(", \n");
        info.append(infoBirthDate()).append(", \n");
        if (deathDate != null) info.append(infoDeathDate()).append(", \n");
        info.append(infoParents()).append(", \n");
        info.append(infoSpouse()).append(", \n");
        info.append(infoChildren());

        return info.toString();
    }
}
