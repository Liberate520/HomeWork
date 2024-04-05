package FamilyTree.HomeWork.src;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public class Human {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private  Human father;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father){
        this(name, gender, birthDate, null, mother, father);
    }
    public void addChildren(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public void addParents(Human parent) {
        if(parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if(parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
    }

    public void setName(String name) {
        this.name = name;
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

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (father!= null){
            list.add(father);
        } else if (mother!= null){
            list.add(mother);
        }
        return list;
    }

    private int getAge(){
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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Gender getGender() {
        return gender;
    }
    @Override
    public  String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ");
        stringBuilder.append(id);
        stringBuilder.append(", name: ");
        stringBuilder.append(name);
        stringBuilder.append(", gender: ");
        stringBuilder.append(getGender());
        stringBuilder.append(", возраст: ");
        stringBuilder.append(getAge());
        stringBuilder.append(", ");
        stringBuilder.append(getMotherInfo());
        stringBuilder.append(",  ");
        stringBuilder.append(getFatherInfo());
        stringBuilder.append(",  ");
        stringBuilder.append(getChildrenInfo());
        stringBuilder.append(",  ");
        return stringBuilder.toString();
    }

    public String getMotherInfo(){
        String rez = " мать: ";
        Human mother = getMother();
        if (mother == null) {
            rez += "нет";
        } else {
            rez += mother.getName();
        }
        return rez;
    }

    public String getFatherInfo(){
        String rez = " отец: ";
        Human father = getFather();
        if (father == null) {
            rez += "нет";
        } else {
            rez += father.getName();
        }
        return rez;
    }

    public String getChildrenInfo() {
        StringBuilder rez = new StringBuilder();
        rez.append("дети: ");
        if(children.isEmpty()) {
            rez.append(" нет");
        } else {
            rez.append(children.get(0).getName());
            for (int i = 1; i< children.size(); i++) {
                rez.append(", ");
                rez.append(children.get(i).getName());
            }
        }
        return rez.toString();
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