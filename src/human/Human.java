package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate deathDay;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDay, LocalDate deathDay,
                 Human mother, Human father) {
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDay) {
        this(name,gender,birthDay,null,null,null);
    }

    public Human(String name, Gender gender, LocalDate birthDay, Human mother, Human father) {
        this(name,gender,birthDay,null,mother,father);
    }

    public boolean addChildren(Human human) {
        if (!children.contains(human)) {
            children.add(human);
            return true;
        }
        return false;
    }

    public void addParent(Human human) {
        if (human.getGender().equals(gender.Male)) {
            setFather(human);
        } else if (human.getGender().equals(gender.Female)) {
            setMather(human);
        }
    }

    public Human setMather(Human mother) {
        return this.mother = mother;
    }

    public Human setFather(Human father) {
        return this.father = father;
    }

    public List<Human> getParrent() {
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }
    public int getAge(){
        if(deathDay == null){
            return getPeriod(birthDay, LocalDate.now());
        }
        else{
            return getPeriod(birthDay,deathDay);
        }
    }

    private int getPeriod(LocalDate birthDay, LocalDate deathDay) {
        Period res = Period.between(birthDay,deathDay);
        return res.getYears();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ");
        sb.append(name);
        sb.append(", id: ");
        sb.append(id);
        sb.append(", Age: ");
        sb.append(getAge());
        sb.append(", Mother: ");
        sb.append(getMotherInfo());
        sb.append(", Father: ");
        sb.append(getFatherInfo());
        sb.append(", Children: ");
        sb.append(getChildrenInfo());

        return sb.toString();
    }

    public String getMotherInfo() {
        String res = "";
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестно";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "";
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестно";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        if (!children.isEmpty()) {
            sb.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
        } else {
            sb.append("Отсутствуют");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

}