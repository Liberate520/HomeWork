package family_tree.model.human;

import family_tree.model.family_tree.ItemFamilyTree;
import family_tree.model.human.enum_for_human.Gender;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.lang.Object;


public class Human implements Comparable<Human>, ItemFamilyTree<Human>{
    private long id;
    private String firstName;
    private String patronymic;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;


    public Human(long id,String firstName,String patronymic,String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        this.id = id;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(Long id,String firstName,String patronymic,String lastName, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(id, firstName,patronymic,lastName, gender, birthDate, null, mother, father);
    }

    public Human(Long id,String firstName,String patronymic,String lastName,  Gender gender, LocalDate birthDate) {
        this(id,firstName,patronymic,lastName, gender, birthDate, null, null, null);
    }

    //Id

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //First Name

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Patronymic

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    //Last Name

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Gender

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    //Birth Date

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    //Death Date

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    //Mother

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }

    //Father

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    //Children

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    // Add Children or Parents

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

    //Age

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

    //Info Human for String

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Human ID: ");
        info.append(id);
        info.append(", ");
        info.append(firstName);
        info.append(" ");
        info.append(lastName);
        info.append(" ");
        info.append(patronymic);
        info.append(", пол: ");
        info.append(getGender());
        info.append(", возрост: ");
        info.append(getAge());
        info.append(getMotherInfo());
        info.append(getFatherInfo());
        info.append(getChildrenInfo());
        return info.toString();
    }

    public  String getFatherInfo(){
        String res = "";
        Human father = getFather();
        if (father != null){
            res = ", отец: " +father.getFirstName()+" "+ father.getLastName()+" "+father.getPatronymic();
        }
        return res;
    }

    public  String getMotherInfo(){
        String res = "";
        Human mother = getMother();
        if (mother != null){
            res += ", мать: " + mother.getFirstName()+" "+ mother.getLastName()+" "+mother.getPatronymic();
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append(", дети: ");
        if (!children.isEmpty()){
            res.append(children.get(0).getFirstName());
            for (int i = 1; i< children.size();i++){
                res.append(", ");
                res.append(children.get(i).getFirstName());
            }
        }else {
            res = new StringBuilder();
        }
        return res.toString();
    }

    //default
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

    @Override
    public int compareTo(Human o) {
        return 0;
    }
}
