import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Human {
    private final String firstName;
    private final String lastName;
    private Human mother, father;
    private List<Human> childrens;
    private final Gender gender;
    private final Date dob;
    private Date dod = null;

    public Human(String firstName, String lastName, Gender gender, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.childrens = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return childrens;
    }

    public Date getDob() {
        return dob;
    }

    public Date getDod() {
        return dod;
    }

    public void setChildren(Human children) {
        this.childrens.add(children);
    }

    public void setDod(Date dod) {
        this.dod = dod;
    }

    public void setMother(Human mother) {
        this.mother = mother;
        for (Human human: this.mother.childrens){
            if (equals(human, this)){
                return;
            }
        }
        mother.setChildren(this);
    }
    public boolean equals(Human human1, Human human2){
        return human1.firstName.equals(human2.firstName) &&
                human1.lastName.equals(human2.lastName) &&
                human1.dob.equals(human2.dob);
    }

    public void setFather(Human father) {
        this.father = father;
        for (Human human: this.father.childrens){
            if (equals(human, this)){
                return;
            }
        }
        father.setChildren(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name:\n");
        stringBuilder.append(firstName);
        stringBuilder.append("\nLast Name:\n");
        stringBuilder.append(lastName);
        stringBuilder.append("\nDate of birthday:\n");
        stringBuilder.append(dob);
        if (dod != null){
            stringBuilder.append("\nDate of death:\n");
            stringBuilder.append(dod);
        }
        return stringBuilder.toString();
    }
}
