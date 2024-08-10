import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
public class Human implements Serializable {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mom;
    private Human dad;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human dad, Human mom) {
        children = new ArrayList<>();
        this.dad = dad;
        this.mom = mom;
        this.deathDate = deathDate;
        this.birthDate = birthDate;
        this.gender = gender;
        this.name = name;
        id = -1;
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public  boolean addParent(Human parent){
        if (parent.getGender().equals(Gender.Male)){
            setDad(parent);
        }else if(parent.getGender().equals(Gender.Female)){
            setMom(parent);
        }
        return true;
    }
    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if(dad != null){
            list.add(dad);
            if(mom != null) {
                list.add(mom);
            }
        }
        return list;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human getMom() {
        return mom;
    }

    public void setMom(Human mom) {
        this.mom = mom;
    }

    public Human getDad() {
        return dad;
    }

    public void setDad(Human dad) {
        this.dad = dad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    public String getMomInfo() {
        String res = "";
        if (mom != null) {
            res += mom.getName();
        } else {
            res += "нет";
        }
        return res;
    }

    public String getDadInfo() {
        String res = "";
        if (dad != null) {
            res += dad.getName();
        } else {
            res += "нет";
        }
        return res;
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", мать: ");
        sb.append(getMomInfo());
        sb.append(", отец: ");
        sb.append(getDadInfo());
        sb.append(", дети: ");
        sb.append(getInfoChild());
        return sb.toString();
    }

    public String getInfoChild(){
        StringBuilder sb = new StringBuilder();
        if (children.size() != 0){
            for (int i = 0; i < children.size(); i++) {
                sb.append(children.get(i).getName());
                sb.append(" ");
            }
        }else{
            sb.append("нет");
        }
        return sb.toString();
    }
}
