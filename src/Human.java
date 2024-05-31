import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    private List<Human> children;

    private Human spouse;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother, List<Human> children, Human spouse) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = new ArrayList<>();
        if(father != null){
            parents.add(father);
        }
        if(mother != null){
            parents.add(mother);
        }
        this.children = children;
        this.spouse = spouse;
    }

    public boolean addChild(Human child){
        if(children == null){
            List<Human> children = new ArrayList<>();
            children.add(child);
            setChildren(children);
        }
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParents(Human parent){
        if(!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getSpouse() {
        return spouse;
    }

    public String getSpouseInfo() {
        return getSpouse().getName();
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getMotherInfo(){
        for (Human human : parents){
            if (human.getGender() == Gender.Female){
                return human.getName();
            }
        }
        return null;
    }

    public String getFatherInfo(){
        for (Human human : parents){
            if (human.getGender() == Gender.Male){
                return human.getName();
            }
        }
        return null;
    }

    public StringBuilder getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        if(children != null) {
            for (Human human : children) {
                sb.append(human.getName());
                sb.append("\n");
            }
        } else {
            return sb.append("Нет детей.");
        }
        return sb;
    }

    public int getAge() {
        return Period.between(birthDate, Objects.requireNonNullElseGet(deathDate, LocalDate::now)).getYears();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ");
        stringBuilder.append(id);
        stringBuilder.append("\nИмя: ");
        stringBuilder.append(name);
        stringBuilder.append("\nПол: ");
        stringBuilder.append(getGender());
        stringBuilder.append("\nВозраст: ");
        stringBuilder.append(getAge());
        stringBuilder.append("\nДата рождения: ");
        stringBuilder.append(birthDate);
        if(deathDate != null){
            stringBuilder.append("\nДата смерти: ");
            stringBuilder.append(deathDate);
        }
        if(spouse != null){
            stringBuilder.append("\nСупруг: ");
            stringBuilder.append(getSpouseInfo());
        } else {
            stringBuilder.append("\nСтатус: Нет супруга.");
        }
        stringBuilder.append("\nДети: ");
        stringBuilder.append(getChildrenInfo());
        stringBuilder.append("\nМама: ");
        stringBuilder.append(getMotherInfo());
        stringBuilder.append("\nОтец: ");
        stringBuilder.append(getFatherInfo());
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}

