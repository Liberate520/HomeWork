import java.util.*;

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
        this.childrens = new LinkedList<>();
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
        boolean flag = true;
        for (Human human : this.childrens) {
            if (children == human) {
                flag = false;
            }
        }
            if (flag) this.childrens.add(children);
        }


    public void setDod(Date dod) {
        this.dod = dod;
    }

    public void setMother(Human mother) {
        this.mother = mother;
        mother.setChildren(this);
    }

    public void setFather(Human father) {
        this.father = father;
        father.setChildren(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nName:\n");
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
