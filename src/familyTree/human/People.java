package familyTree.human;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class People implements Serializable {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthday;
    private LocalDate die;
    private People mother;
    private People father;
    private People spouse;
    private List<People> children;

    public People(String name, Gender gender, LocalDate birthday, LocalDate die, People mother, People father, People spouse) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.die = die;
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
        children = new ArrayList<>();
    }

    public People(String name, Gender gender, LocalDate birthday, People mother, People father) {
       this(name, gender, birthday, null, mother, father, null);
    }

    public People(String name, Gender gender, LocalDate birthday) {
        this(name, gender, birthday, null, null);
    }

    public boolean addParent(People parent){
        if (parent.getGender()==Gender.Male){
            father = parent;
        } else if (parent.getGender()==Gender.Female) {
            mother = parent;
        }
        return true;
    }

    public boolean addChildren(People child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMother(People mother) {
        this.mother = mother;
    }

    public void setFather(People father) {
        this.father = father;
    }

    public void setSpouse(People spouse) {
        this.spouse = spouse;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setDie(LocalDate die) {
        this.die = die;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public People getSpouse() {
        return spouse;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getDie() {
        return die;
    }

    public People getMother() {
        return mother;
    }

    public People getFather() {
        return father;
    }

    public int getAge(){
        if (die == null){
            return LocalDate.now().getYear() - birthday.getYear();
        }
        return birthday.getYear() - die.getYear();
    }

    public List<People> getParents(){
        List<People> parents = new ArrayList<>(2);
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        return  parents;
    }

    public List<People> getChildren(){
        return children;
    }

    @Override
    public String toString() {
        return toInfo();
    }

    private String toInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ");
        sb.append(id);
        sb.append("; имя: ");
        sb.append(name);
        sb.append("; возраст: ");
        sb.append(getAge());
        sb.append("; пол: ");
        sb.append(getGenderInfo());
        sb.append("; родители: ");
        sb.append(getParentsInfo());
        sb.append(", супруг(а): ");
        sb.append(getSpouseInfo());
        sb.append("; дети: ");
        sb.append(getChildrenInfo());
        sb.append(".");

        return sb.toString();
    }

    private String getSpouseInfo(){
        if(spouse == null) {
            return "нет";
        } else if (spouse.getGender().equals(Gender.Male)) {
            System.out.print("муж ");
        }
        System.out.print("жена ");
        return spouse.getName();
    }

    private String getGenderInfo(){
        if(getGender().equals(Gender.Male)){
            return "мужской";
        }
        return "женский";
    }

    private String getParentsInfo(){
        String str = "мама ";
        if(mother != null){
            str += getMother().getName();
        }
        str += "нет";

        str += " / отец ";
        if(father != null){
            str += getFather().getName();;
        }
        str += "нет";
        return str;
    }

    private String getChildrenInfo(){
        StringBuilder sb = new StringBuilder();
        if(children.size() != 0){
            sb.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
        }else {
            sb.append("нет");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof People)) {
            return false;
        }
        People people = (People) obj;
        return people.getId() == getId();
        }
}
