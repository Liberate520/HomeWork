package Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private long id;
    private String name;
    private Sex sex;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Person mother;
    private Person father;
    private List<Person> children;
    private Person spouse;

    public Person (String name, Sex sex, LocalDate birthDate, LocalDate deathDate,
                 Person father, Person mother) {
        id = -1;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }
    public Person (String name, Sex sex, LocalDate birthDate) {
        this(name, sex, birthDate, null, null, null);
    }

    public Person(String name, Sex sex, LocalDate birthDate,
                 Person father, Person mother) {
        this(name, sex, birthDate, null, father, mother);
    }
    public boolean addChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }
    public boolean addParent(Person parent) {
        if (parent.getSex().equals(Sex.Male)) {
            setFather(parent);
        } else if (parent.getSex().equals(Sex.Female)) {
            setMother(parent);
        }
        return true;
    }
    public void setGender(Sex sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getParents() {
        List<Person> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }

    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }
    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Sex getSex() {
        return sex;
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
        sb.append(", пол: ");
        sb.append(getSex());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        //TODO добавить информацию о том жив ли человек
        return sb.toString();
    }

    public String getSpouseInfo() {
        String res = "супруг(а): ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        Person mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Person father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!children.isEmpty()) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Person person) {
            return person.getId() == getId();
        }
        return false;
    }

}
