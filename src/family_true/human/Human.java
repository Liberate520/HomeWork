/**
 * @author Ostrovskiy Dmitriy
 * @created 19.05.2024
 * class Human
 * @version v1.0
 */

package family_true.human;

import family_true.api.BuildId;
import family_true.api.Entity;
import family_true.api.IndexId;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static family_true.human.Gender.FEMALE;
import static family_true.human.Gender.MALE;

public class Human implements Serializable, IndexId, BuildId, Entity<Human> {

    private static final long serialVersionUID = 1054756843591674776L;

    private long id;
    private String name;
    private String patronymic;
    private String lastName;
    private Gender gender;
    private LocalDate birthDay, deathDay;
    private Human mother, father;
    private List<Human> children;
    private Human spouse; // супруг/супруга

    public Human() {
        this(null, null, null, null, null);
    }

    public Human(String name, String patronymic, String lastName, Gender gender, LocalDate birthDay) {
        this(name, patronymic, lastName, gender, birthDay, null, null, null);
    }

    public Human(String name, String patronymic, String lastName, Gender gender, LocalDate birthDay, Human mother, Human father) {
        this(name, patronymic, lastName, gender, birthDay, null, mother, father, new ArrayList<>());
    }

    public Human(String name, String patronymic, String lastName, Gender gender, LocalDate birthDay, LocalDate deathDay, Human mother, Human father) {
        this(name, patronymic, lastName, gender, birthDay, deathDay, mother, father, new ArrayList<>());
    }

    public Human(String name, String patronymic, String lastName, Gender gender, LocalDate birthDay,
                 LocalDate deathDay, Human mother, Human father, List<Human> children) {

        this(-1, name, patronymic, lastName, gender, birthDay, deathDay, mother, father, children);
    }

    public Human(long id, String name, String patronymic, String lastName, Gender gender, LocalDate birthDay,
                 LocalDate deathDay, Human mother, Human father, List<Human> children) {
        this.id = id;
        this.name = name;
        this.patronymic = patronymic;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        if (mother != null) {
            if (FEMALE == mother.getGender()) {
                mother.addChild(this);
                this.mother = mother;
            } else {
                System.out.println("Mother have FEMALE Gender!");
            }
        }
        if (father != null) {
            if (MALE == father.getGender()) {
                father.addChild(this);
                this.father = father;
            } else {
                System.out.println("Father have MALE Gender!");
            }
        }
        this.children = children;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public int getIndexId() {
        return Math.toIntExact(getId());
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getAge() {
        LocalDate currentDate = deathDay == null ? LocalDate.now() : deathDay;
        if ((birthDay != null) && (currentDate != null)) {
            return Period.between(birthDay, currentDate).getYears();
        } else {
            return 0;
        }
    }

    @Override
    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public LocalDate getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(LocalDate deathDay) {
        this.deathDay = deathDay;
    }

    @Override
    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        if (FEMALE != mother.getGender()) {
            System.out.println("Mother have FEMALE Gender!");
            return;
        }
        if (this.equals(mother)) {
            System.out.println("Mothers has not equals!");
            return;
        }
        mother.addChild(this);
        this.mother = mother;
    }

    @Override
    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        if (MALE != father.getGender()) {
            System.out.println("Father have MALE Gender!");
            return;
        }
        if (this.equals(father)) {
            System.out.println("Fathers has not equals!");
            return;
        }
        father.addChild(this);
        this.father = father;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human human) {
        this.spouse = human;
        if (human.getSpouse() == null) {
            human.setSpouse(this);
        }
    }

    public Human addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        } else {
            System.out.printf("Already add! Child:[ id:%s, name: %s, patronymic: %s, lastName: %s\n]",
                    id, name, patronymic, lastName);
        }
        return this;
    }

    public boolean isAddChild(Human child) {
        int size = this.getChildren().size();
        addChild(child);
        return this.getChildren().size() > size;
    }

    @Override
    public boolean isParent(Human human) {
        return this.getMother().equals(human) || this.getFather().equals(human);
    }

    public StringBuilder getHumanInfo(StringBuilder sb, Human human) {
        sb.append("     ");
        getHumanInfoWithoutChildren(sb, human);
        if (human.getChildren().size() > 0) {
            sb.append(",\n       children: ");
            sb.append("[");
            Iterator<Human> children = human.getChildren().iterator();
            while (children.hasNext()) {
                sb.append("     \n");
                sb.append("             ");
                Human child = children.next();
                getHumanInfoWithoutParents(sb, child);
                sb.append("]");
                if (children.hasNext()) {
                    sb.append(",");
                } else {
                    sb.append("\n       ]");
                }
            }
        }
        return sb;
    }

    public StringBuilder getHumanInfoWithoutChildren(StringBuilder sb, Human human) {
        getHumanInfoWithoutParents(sb, human);
        if (human.getMother() != null) {
            sb.append(",\n       mother: ");
            getHumanInfoWithoutParents(sb, human.getMother());
            sb.append("]");
        }
        if (human.getFather() != null) {
            sb.append(",\n       father: ");
            getHumanInfoWithoutParents(sb, human.getFather());
            sb.append("]");
        }
        return sb;
    }

    public StringBuilder getHumanInfoWithoutParents(StringBuilder sb, Human human) {
        sb.append("[id: ");
        sb.append(human.getId());
        sb.append(", name: ");
        sb.append(human.getName());
        sb.append(", patronymic: ");
        sb.append(human.getPatronymic());
        sb.append(", lastName: ");
        sb.append(human.getLastName());
        sb.append(", gender: ");
        sb.append(human.getGender().getGenderValue());
        sb.append(", birthDay: ");
        sb.append(human.getBirthDay().toString());
        if (human.getDeathDay() != null) {
            sb.append(", deathDay: ");
            sb.append(human.getDeathDay().toString());
        }
        return sb;
    }

    public String getChildrenInfo() {
        StringBuilder children = new StringBuilder();
        if (getChildren().size() > 0) {
            for (Human child : getChildren()) {
                children.append("\n[");
                getHumanInfo(children, child);
                children.append("]");
            }
        } else {
            children.append("отсутствуют");
        }
        return children.toString();
    }

    public String getInfo() {
        StringBuilder gt = new StringBuilder();
        gt.append("\n");
        getHumanInfo(gt, this);
        gt.append("\n]");
        return gt.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(id, human.id)
                && Objects.equals(name, human.name)
                && Objects.equals(patronymic, human.patronymic)
                && Objects.equals(lastName, human.lastName)
                && gender == human.gender
                && Objects.equals(birthDay, human.birthDay)
                && Objects.equals(deathDay, human.deathDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, patronymic, lastName, gender, birthDay, deathDay);
    }
}
