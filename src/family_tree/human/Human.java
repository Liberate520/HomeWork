package family_tree.human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.lang.Object;


public class Human {
    private long id;
    private String firstName;
    //TODO  добавить Фамилию и Отчество
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;


    public Human(String firstName, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        this.id = -1;
        this.firstName = firstName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String firstName, Gender gender, LocalDate birthDate) {
        this(firstName, gender, birthDate, null, null, null);
    }

    public Human(String firstName, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(firstName, gender, birthDate, null, mother, father);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        } else if (mother != null) {
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

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Human ID: ");
        info.append(id);
        info.append(", имя: ");
        info.append(firstName);
        info.append(", пол: ");
        info.append(getGender());
        info.append(", возрост: ");
        info.append(getAge());
        info.append(", ");
        info.append(getMotherInfo());
        info.append(", ");
        info.append(getFatherInfo());
        info.append(", ");
        info.append(getChildrenInfo());
        return info.toString();
    }
    public  String getFatherInfo(){
        String res = "отец: ";
        Human father = getFather();
        if (father != null){
            res += father.getFirstName();
        } else {
            res += "запись отсутствует";
        }
        return res;
    }

    public  String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getFirstName();
        } else {
            res += "запись отсутствует";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!children.isEmpty()){
            res.append(children.get(0).getFirstName());
            for (int i = 1; i< children.size();i++){
                res.append(", ");
                res.append(children.get(i).getFirstName());
            }
        }else {
            res.append("Отсутствует");
        }
        return res.toString();
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
}
