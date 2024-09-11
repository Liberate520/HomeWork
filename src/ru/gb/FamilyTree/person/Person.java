package ru.gb.FamilyTree.person;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private long id;
    private String name, surname, patronymicName; // Имя, Фамилия, Отчество (задается, когда устанавливается отец)
    private LocalDate dateOfBirth, dateOfDeath; // Даты рождения и смерти
    private Person father, mother;  // Отец и мать
    private ArrayList<Person> children; //Массив с детьми
    private Gender gender; // Пол
    private Person spouse;
//    private int age; // Возраст

    public Person(String surname, String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Person father, Person mother) {
        id = -1;
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.dateOfDeath = dateOfDeath;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Person(String surname, String name, Gender gender, LocalDate dateOfBirth) {
        this(surname, name, gender, dateOfBirth, null, null, null);
    }

    public Person(String surname, String name, Gender gender, LocalDate dateOfBirth, Person father, Person mother) {
        this(surname, name, gender, dateOfBirth, null, father, mother);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender.toString();
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public int getAge() {
        return getPeriod(dateOfBirth, Objects.requireNonNullElseGet(dateOfDeath, LocalDate::now));
    }

    private int getPeriod(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period diff = Period.between(dateOfBirth, dateOfDeath);
        return diff.getYears();
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public ArrayList<Person> getParents() {
        ArrayList<Person> parents = new ArrayList<>();
        if (this.getFather() != null) {
            parents.add(this.getFather());
        }
        if (this.getMother() != null) {
            parents.add(this.getMother());
        }
        return parents;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public boolean addChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;

    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", фамилия: ");
        sb.append(surname);
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        sb.append(", ");
        sb.append(getSpounseInfo());
        return sb.toString();

    }

    public String getSpounseInfo() {
        String info = "супруг(а): ";
        Person spouse = getSpouse();
        if (spouse == null) {
            info += "нет.";
        } else {
            info += spouse.getName();
        }
        return info;
    }

    public String getFatherInfo() {
        String info = "отец: ";
        Person father = getFather();
        if (father == null) {
            info += "не известен";
        } else {
            info += father.getName();
        }
        return info;
    }

    public String getMotherInfo() {
        String info = "мать: ";
        Person mother = getMother();
        if (mother == null) {
            info += "не известна.";
        } else {
            info += mother.getName();
        }
        return info;
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("дети: ");
        if (!children.isEmpty()) {
            sb.append(children.getFirst().getName());
            for (int i = 1; i < children.size(); i++) {
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
        } else {
            sb.append("отсутствуют");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
        return other.getId() == this.getId();
    }
}
