import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;
    private Human spouse;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate,
                Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
     }

     public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
     }

     public Human(String name, Gender gender, LocalDate birthDate, 
                Human father, Human mother) {
        this(name, gender, birthDate, null, father, mother);
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

     public void setGender(Gender gender) {this.gender = gender;}

     public void setName(String name) {this.name = name;}

     public void setMother(Human mother) {this.mother = mother;}

     public void setFather(Human father) {this.father = father;}

     public Human getMother() {return mother;}

     public Human getFatehr () {return father;}

     public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);            
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
     }

     public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        }else {
            return getPeriod(birthDate, deathDate);
        }
     }

     private int getPeriod(LocalDate birDate, LocalDate deathDate){
        Period diff = Period.between(birDate, deathDate);
        return diff.getYears();
    }

    public void setSpouse(Human spouse) { this.spouse = spouse; }

    public Human getSpouse() {return spouse; }

    public String getName() {return name; }

    public long getId() {return id; }

    public void setId(long id) {this.id = id; }

    public LocalDate getBirthDate() {return birthDate; }

    public LocalDate getDeathDate() {return deathDate; }

    public List<Human> getChildren() {return children; }

    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate; }

    public void setDeathDate(LocalDate deathDate) {this.deathDate = deathDate; }

    public Gender getGender() {return gender; }


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
        sb.append(getFatehr());
        sb.append(", ");
        sb.append(getChildrenInfo());
        //TODO добавить информацию о том жив ли человек
        return sb.toString();
    }

    public String getSpouseInfo(){
        String res = "супруг(а): ";
        if (spouse == null){
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        Human father = getFatehr();
        if (mother != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;

    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!children.isEmpty()) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствует");
        }
        return res.toString();
        }


        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Human human) {
                return human.getId() == getId();
            }
            return false;
        }
}
