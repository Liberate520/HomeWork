package family_tree;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private String surname;
    private String lastname;
    private Gender gender;
    private LocalDate birthdate;
    private LocalDate deathdate;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human spouse;
    private int generation;
    private boolean married;

    public Human(String name, String surname, String lastname, Gender gender,
                 LocalDate birthdate, LocalDate deathdate, Human mother, Human father, int generation) {

        id = -1;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthdate = birthdate;
        this.deathdate = deathdate;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.generation = generation;
        this.married = false;

    }

    public Human(String name, String surname, String lastname, Gender gender,
                 LocalDate birthdate, Human mother, Human father, int generation) {
        this(name, surname, lastname, gender, birthdate, null, null, null, generation);
    }


    public void setId(int id) {
        this.id = id;
    }

    public boolean getMarriedOrNot() {
        return married;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public int getGeneration() {
        return generation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.MALE)) setFather(parent);
        else if (parent.getGender().equals(Gender.FEMALE)) setMother(parent);
        return true;
    }

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (father != null) list.add(father);
        if (mother != null) list.add(mother);
        return list;
    }

    public int getAge() {
        if (deathdate == null) return Period.between(birthdate, LocalDate.now()).getYears();
        else return Period.between(birthdate, deathdate).getYears();
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Дети:");
        if (!children.isEmpty()) {
            sb.append(children.get(0).name);
            sb.append(" ");
            sb.append(children.get(0).surname);
            sb.append(" ");
            sb.append(children.get(0).lastname);
            for (int i = 1; i < children.size(); i++) {
                sb.append(", ");
                sb.append(children.get(i).name);
                sb.append(" ");
                sb.append(children.get(i).surname);
                sb.append(" ");
                sb.append(children.get(i).lastname);

            }
        }
        return sb.toString();
    }

    @Override

    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя = ");
        sb.append(name);
        sb.append(", отчество = ");
        sb.append(surname);
        sb.append(", фамилия = ");
        sb.append(lastname);
        sb.append(", пол = ");
        sb.append(getGender());
        sb.append(", возраст = ");
        sb.append(getAge());
        sb.append(", отец = ");
        if (father != null) sb.append(getFather());
        else sb.append("неизвестен");
        sb.append(", мать = ");
        if (mother != null) sb.append(getMother());
        else sb.append("неизвестна");
        sb.append(", поколение = ");
        sb.append(getGeneration());
        sb.append(", семейное положение = ");
        sb.append(getMarriedOrNot());
        sb.append(getChildren());

        return sb.toString();

    }
}


