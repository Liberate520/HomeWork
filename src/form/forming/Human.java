package form.forming;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable, Create<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;

    public Human (String name, Gender gender, String birthDate, String deathDate) {
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate);
        if (deathDate != null) {
            this.deathDate = LocalDate.parse(deathDate);
        } else {
            this.deathDate = null;
        }
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, birthDate, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, (LocalDate) null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(name, gender, null, null, null, null);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParents(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
        }
        return false;
    }

//    public Human getFather() {
//        for (Human parent : parents) {
//            {
//                return parent;
//            }
//        }
//        return null;
//    }

//    public Human getMother() {
//        for (Human parent : parents) {
//            {
//                return parent;
//            }
//        }
//        return null;
//    }

    public int getAge() {
        return getPeriod(birthDate, Objects.requireNonNullElseGet(deathDate, LocalDate::now));
    }
//    public int getAge() {
//        if (deathDate == null) {
//            LocalDate today = LocalDate.now();
//            return Period.between(birthDate, today).getYears();
//        }
//        return Period.between(birthDate, deathDate).getYears();
//    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getSpouse() {
        return null;
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

    public List<Human> getParents() {
        return parents;
    }

    @Override
    public List<Human> getGrandparents() {
        return null;
    }

    @Override
    public List<Human> getGrandsons() {
        return null;
    }

    @Override
    public boolean alive() {
        return false;
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

    @Override
    public void setParents(Human mother, Human father) {

    }

    @Override
    public void setChildren(Human child) {

    }

    public String getInfo() {
        return "id: " +
                id +
                ", имя: " +
                name +
                ", пол: " +
                getGender() +
                ", возраст: " +
                getAge() +
                ", " +
                getSpouseInfo() +
                ", "
                +
                getChildrenInfo();
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

//    public String getMotherInfo() {
//        String res = "мать: ";
//        Human mother = getMother();
//        if (mother != null) {
//            res += mother.getName();
//        } else {
//            res += "неизвестна";
//        }
//        return res;
//    }

//    public String getFatherInfo() {
//        String res = "отец: ";
//        Human father = getFather();
//        if (father != null) {
//            res += father.getName();
//        } else {
//            res += "неизвестен";
//        }
//        return res;
//    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
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
        if (!(obj instanceof Human human)) {
            return false;
        }
        return human.getId() == getId();
    }

}
