package family_tree;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a human in the family tree with various attributes and relationships.
 */
public class Human {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human spouse;

    /**
     * Constructs a Human with the specified attributes.
     *
     * @param name      the name of the human
     * @param gender    the gender of the human
     * @param birthDate the birth date of the human
     * @param deathDate the death date of the human, or null if still alive
     * @param father    the father of the human, or null if unknown
     * @param mother    the mother of the human, or null if unknown
     */
    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate,
                 Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    /**
     * Constructs a Human with the specified name, gender, and birth date.
     *
     * @param name      the name of the human
     * @param gender    the gender of the human
     * @param birthDate the birth date of the human
     */
    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    /**
     * Constructs a Human with the specified name, gender, birth date, father, and mother.
     *
     * @param name      the name of the human
     * @param gender    the gender of the human
     * @param birthDate the birth date of the human
     * @param father    the father of the human, or null if unknown
     * @param mother    the mother of the human, or null if unknown
     */
    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, birthDate, null, father, mother);
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    /**
     * Adds a child to the human's list of children.
     *
     * @param child the child to add
     * @return true if the child was added, false otherwise
     */
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    /**
     * Adds a parent to the human's list of parents.
     *
     * @param parent the parent to add
     * @return true if the parent was added, false otherwise
     */
    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    /**
     * Gets a list of the human's parents.
     *
     * @return a list of the human's parents
     */
    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }

    /**
     * Gets the age of the human based on their birth and death dates.
     *
     * @return the age of the human
     */
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

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
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

    public List<Human> getChildren() {
        return children;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    /**
     * Gets information about the human.
     *
     * @return a string containing information about the human
     */
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
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

        return sb.toString();
    }

    /**
     * Gets information about the human's spouse.
     *
     * @return a string containing information about the human's spouse
     */
    public String getSpouseInfo() {
        String res = "супруг(а): ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    /**
     * Gets information about the human's mother.
     *
     * @return a string containing information about the human's mother
     */
    public String getMotherInfo() {
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    /**
     * Gets information about the human's father.
     *
     * @return a string containing information about the human's father
     */
    public String getFatherInfo() {
        String res = "отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    /**
     * Gets information about the human's children.
     *
     * @return a string containing information about the human's children
     */
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
        if (obj instanceof Human) {
            Human human = (Human) obj;
            return human.getId() == getId();
        }
        return false;
    }

}