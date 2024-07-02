package Humans;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    // private int ID;
    private String name;
    private LocalDate dateOfBorn, dateOfDeath;
    private Gender gender;
    private Human father, mother;
    private Human grandFather, grandMother;
    private List<Human> children;
    private List<Human> grandchildren; 

    public Human(String name, LocalDate dateOfBorn, LocalDate dateOfDeath, Gender gender, Human father, Human mother,
            Human grandFather, Human grandMother) {
        // ID = -1;
        this.name = name;
        this.dateOfBorn = dateOfBorn;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.grandFather = grandFather;
        this.grandMother = grandMother;
        children = new ArrayList<>();
        grandchildren = new ArrayList<>();
    }

    public Human(String name, LocalDate dateOfBorn, LocalDate dateOfDeath, Gender gender) {
        this(name, dateOfBorn, dateOfDeath, gender, null, null, null, null);
    }

    public Human(String name, LocalDate dateOfBorn, LocalDate dateOfDeath, Gender gender, Human father, Human mother) {
        this(name, dateOfBorn, dateOfDeath, gender, father, mother, null, null);
    }

    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addGrandChild(Human grandChild){
        if(!grandchildren.contains(grandChild)){
            grandchildren.add(grandChild);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public boolean addGrandParent(Human grandParent){
        if (grandParent.getGender().equals(Gender.Male)) {
            setGrandFather(grandParent);
        } else if (grandParent.getGender().equals(Gender.Female)) {
            setGrandMother(grandParent);
        }
        return true;
    }

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

    public List<Human> getGrandParents(){
        List<Human> list = new ArrayList<>(2);
        if (grandFather != null) {
            list.add(grandFather);
        }
        if (grandMother != null) {
            list.add(grandMother);
        }
        return list;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDateOfBorn() {
        return dateOfBorn;
    }
    public void setDateOfBorn(LocalDate dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }
    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }
    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Human getFather() {
        return father;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public Human getMother() {
        return mother;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Human getGrandFather() {
        return grandFather;
    }
    public void setGrandFather(Human grandFather) {
        this.grandFather = grandFather;
    }
    public Human getGrandMother() {
        return grandMother;
    }
    public void setGrandMother(Human grandMother) {
        this.grandMother = grandMother;
    }
    public List<Human> getChildren() {
        return children;
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }
    public List<Human> getGrandchildren() {
        return grandchildren;
    }
    public void setGrandchildren(List<Human> grandchildren) {
        
        this.grandchildren = grandchildren;
    }
    // public int getID() {
    //     return ID;
    // }
    // public void setID(int iD) {
    //     this.ID = iD;
    // }

    // @Override
    // public String toString() {
    //     return "Human [name=" + name + ", dateOfBorn=" + dateOfBorn + ", dateOfDeath=" + dateOfDeath + ", gender="
    //             + gender + ", father=" + father + ", mother=" + mother + ", grandFather=" + grandFather
    //             + ", grandMother=" + grandMother + ", children=" + children + ", grandchildren=" + grandchildren + "]";
    // }
    
    // @Override
    // public String toString() {
    //     return "Name: " + name + System.lineSeparator()
    //     + "Date of born: " + dateOfBorn + System.lineSeparator()
    //     + "Date of death: " + dateOfDeath + System.lineSeparator()
    //     + "Gender: " + gender + System.lineSeparator();
    // }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("name: ");
        sb.append(name);
        sb.append(", gender: ");
        sb.append(gender + ";");
        sb.append(" " + getDateOfBorn() + " ");
        sb.append(" " + getDateOfDeath() + " ");
        sb.append(getGender() + ";");
        sb.append(getFatherInfo());
        sb.append(getMotherInfo());
        sb.append(getGrandFatherInfo());
        sb.append(getGrandMotherInfo());
        sb.append(getChildrenInfo());
        sb.append(getGrandChildrenInfo());
        return sb.toString();
    }

    public String getFatherInfo(){
        String res = " папа: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += " нет данных; ";
        }
        return res;
    }

    public String getMotherInfo(){
        String res = " мама: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += " нет данных; ";
        }
        return res;
    }

    public String getGrandFatherInfo(){
        String res = " дедушка: ";
        Human grandfather = getGrandFather();
        if (grandfather != null) {
            res += grandfather.getName();
        } else {
            res += " нет данных; ";
        }
        return res;
    }

    public String getGrandMotherInfo(){
        String res = " бабушка: ";
        Human grandmother = getGrandMother();
        if (grandmother != null) {
            res += grandmother.getName();
        } else {
            res += " нет данных; ";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append(" дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 0; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append(" детей нет; ");
        }
        return res.toString();
    }

    public String getGrandChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append(" внуки: ");
        if (grandchildren.size() != 0) {
            res.append(grandchildren.get(0).getName());
            for (int i = 0; i < grandchildren.size(); i++) {
                res.append(", ");
                res.append(grandchildren.get(i).getName());
            }
        } else {
            res.append(" внуков нет. ");
        }
        return res.toString();
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj) {
    //         return true;
    //     }
    //     if (!(obj instanceof Human)) {
    //         return false;
    //     }
    //     Human human = (Human) obj;
    //     return human.getID() == getID();
    // }

}
