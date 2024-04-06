import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Human {
    private int id;
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private Human father, mother;

    private Human spouse;

    private List<Human> childrenList;
    private List<Human> parentsList;

    public Human(String name, Gender gender, LocalDate dob, LocalDate dod, Object father, Object mother) {

    }
    public Human(String name, Gender gender, LocalDate dob){
        this(name, gender, dob, null, null, null);
    }

    public Human() {
        childrenList = new ArrayList<>();
        parentsList = new ArrayList<>();
        NumerateHuman numerateHuman = new NumerateHuman();
        id = numerateHuman.gethumanId();

    }




    public void addChildren (Human child){
        if(!childrenList.contains(child)){
            childrenList.add(child);
        }
    }

    public boolean addParents(Human parent) {
        if (parentsList.contains(parent)) {
            return false;
        }
        else if (parent.getGender().equals(Gender.Мужской)) {
            setFather(parent);
        }
        else if (parent.getGender().equals(Gender.Женский)) {
            setMother(parent);
        }
        parentsList.add(parent);
        return true;
    }
    public List<Human> getParents(){
        return this.parentsList;
    }

    public List<Human> getChildrenList () {
        return this.childrenList;
    }
    public void addSpouse (Human human) {
        spouse=human;
    }

    public Human getSpouse () {
        return this.spouse;
    }

    public int getId(){
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
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

    @Override

    public boolean equals(Object obj) {
        if (this==obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Human other = (Human) obj;
        return Objects.equals(this.getId(), other.getId());

    }

    @Override

    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ");
        sb.append(id).append("\n");
        if (name != null) {
            sb.append(name).append("\n");
        }
        else {
            sb.append("____").append("\n");
        }
        sb.append("Пол: ");
        if (gender != null) {
            sb.append(gender).append("\n");
        }
        else {
            sb.append("____").append("\n");
        }
        sb.append("Дата рождения: ");
        if (dob != null) {
            sb.append(dob).append("\n");
        }
        else {
            sb.append("____").append("\n");
        }
        sb.append("Дата смерти: ");
        if (dod != null) {
            sb.append(dod).append("\n");
        }
        else {
            sb.append("____").append("\n");
        }
        sb.append("Отец: ");
        if (getFather() != null && getFather().getName()!=null) {
            sb.append(getFather().getName()).append("\n");
        }
        else {
            sb.append("____").append("\n");
        }
        sb.append("Мать: ");
        if (getMother() != null && getMother().getName()!=null) {
            sb.append(getMother().getName()).append("\n");
        }
        else {
            sb.append("____").append("\n");
        }
        sb.append("Супруг(а): ");
        if (getSpouse() != null && getSpouse().getName()!=null) {
            sb.append(getSpouse().getName()).append("\n");
        }
        else {
            sb.append("____").append("\n");
        }


        sb.append("Дети: ");
        if (childrenList != null && !childrenList.isEmpty()) {
            for (Human human : childrenList) {
                sb.append(human.getName());
            }
        }
        else{
            sb.append("____").append("\n");
        }
        return sb.toString();
    }


}
