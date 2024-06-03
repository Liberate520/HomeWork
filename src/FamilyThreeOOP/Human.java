package FamilyThreeOOP;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public class Human implements Serializable {
    private long id;
    private String name;
    private LocalDate birthday;
    private LocalDate dateOfDeath;
    private List<Human> children;
    private Gender gender;
    private List<Human> parents;
    private Human spouse;


    public Human(String name, Gender gender, LocalDate birthday, LocalDate dateOfDeath, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.dateOfDeath = dateOfDeath;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }


    public Human(String name, Gender gender, LocalDate birthday) {
        this(name, gender, birthday, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthday, Human father, Human mother) {
        this(name, gender, birthday, null, father, mother);
    }

    public Human(String name, Gender gender, LocalDate birthday, LocalDate dateOfDeath) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.dateOfDeath = dateOfDeath;
    }


    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public int getAge() {
        if (dateOfDeath == null) {
            return getPeriod(birthday, LocalDate.now());
        } else {
            return getPeriod(birthday, dateOfDeath);
        }
    }

    private int getPeriod(LocalDate birthday, LocalDate dateOfDeath) {
        Period diff = Period.between(birthday, dateOfDeath);
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

    public long getId() {
        return id;
    }

    public void setId(long l) {
        this.id = id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Gender getGender() {
        return gender;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
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

    public String getSpouseInfo(){
        String res = "супруг(а): ";
        if(spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        Human mother = getMother();
        if (mother == null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        Human father = getFather();
        if (father == null) {
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
        if (obj instanceof Human human) {
            return human.getId() == getId();
        }
        return false;
    }

    public Human[] getParents() {
        return null;
    }
}
