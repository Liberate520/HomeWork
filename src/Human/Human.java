package Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private LocalDate dateBrith;
    private LocalDate dateDeath;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;
    private long id;

    public Human(String name, LocalDate dateBrith, LocalDate dateDeath, Gender gender,
                 Human father, Human mother) {
        this.name = name;
        this.dateBrith = dateBrith;
        this.dateDeath = dateDeath;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        id = -1;
        children = new ArrayList<>();
    }

    public Human(String name, LocalDate dateBrith, Gender gender) {
        this(name, dateBrith, null, gender, null, null);
    }

    public Human(String name, LocalDate dateBrith, Gender gender, Human father, Human mother) {
        this(name, dateBrith, null, gender, father, mother);
    }

    public String getName() {
        return name;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public long getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateBrith() {
        return dateBrith;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDateDeath(LocalDate dateDeath) {
        this.dateDeath = dateDeath;
    }

    public boolean addParent(Human parent){
        if(parent.getGender().equals(Gender.Male)) {
            if(father != null){
                return false;
            } else {
                setFather(parent);
            }
        } else if(parent.getGender().equals(Gender.Female)){
            if(mother != null) {
                return false;
            } else {
                setMother(parent);
            }
        }
        return true;
    }

    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public List<Human> getParents(){
        List<Human> parents = new ArrayList<>();
        if(father != null){
            parents.add(father);
        }
        if(mother != null){
            parents.add(mother);
        }
        return parents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", Имя: ");
        sb.append(name);
        sb.append(", Пол: ");
        sb.append(getGender());
        sb.append(", Дата рождения: ");
        sb.append(getDateBrith());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getMotherInfo() {
        String result = "Мама: ";
        if (mother != null){
            result += mother.getName();
        } else {
            result += "отсутствует";
        }
        return result;
    }

    public String getFatherInfo() {
        String result = "Отец: ";
        if (father != null){
            result += father.getName();
        } else {
            result += "отсутствует";
        }
        return result;
    }

    public String getChildrenInfo() {
        StringBuilder result = new StringBuilder();
        result.append("Дети: ");
        if (!children.isEmpty()){
            result.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                result.append(", ");
                result.append(children.get(i).getName());
            }
        } else {
            result.append("отсутствуют");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (! (obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
