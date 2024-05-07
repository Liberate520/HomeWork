package re.zip.famely_tree.model.human;
// import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import re.zip.famely_tree.model.famely_tree.FamelyTreeElement;

// public class Human implements Comparable<Human>, FamelyTreeElement<Human>{
public class Human implements Comparable<Human>, FamelyTreeElement<Human>{
    private long idNo;
    private String firstName;
    private String famelyName;
    private LocalDate dateOfBirsday;
    private LocalDate dateOfDead;
    private Gender gender;
    private List<Human> children;
    private List<Human> parents;
    private Human mother, father, parentNoHuman, spouse;
    // private Human child;

    public Human(String firstName, String famelyName, LocalDate dateOfBirsday, LocalDate dateOfDead, Gender gender, Human mother, Human father) {
        idNo = -1;
        this.firstName = firstName;
        this.famelyName = famelyName;
        this.dateOfBirsday = dateOfBirsday;
        this.dateOfDead = dateOfDead;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.mother = mother;
        this.father = father;

    }

    public Human(String firstName, String lastName, LocalDate dateOfBirsday, Gender gender, Human mother, Human father) {
        this(firstName, lastName, dateOfBirsday, null, gender, mother, father);
    }

    public Human(String firstName, String lastName, LocalDate dateOfBirsday, Gender gender) {
        this(firstName, lastName, dateOfBirsday, null, gender, null, null);
    }

    // public Human(long id, String firstName, String lastName, LocalDate dateOfBirsday, Gender gender) {
    //     idNo = id;
    //     this(firstName, lastName, dateOfBirsday, null, gender, null, null);
    // }

    @Override
    public boolean addACild(Human child) {
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    // @Override
    // public String getFatherName() {
    //     HashMap <String, String> fatherNames = new HashMap<String, String> ();
    //     fatherNames.put("Павел", "Павлов");
    //     fatherNames.put("Андрей", "Андреев");
    //     fatherNames.put("Евгений", "Евгеньев");
    //     fatherNames.put("Лев", "Львов");
    //     fatherNames.put("Мордух", "Мордухов");
    //     fatherNames.put("Авраам", "Авраамов");
    //     fatherNames.put("Абрам", "Абрамов");
    //     fatherNames.put("Виктор", "Викторов");
    //     if (this.father == null){
    //         return "";
    //     }
    //     if (this.getGender().equals(Gender.Male)){
    //         return fatherNames.get(this.father.firstName) + "ич";
    //     }
    //     else if (this.getGender().equals(Gender.Female)){
    //         return fatherNames.get(this.father.firstName) + "на";
    //     }
    //     return fatherNames.get(this.father.firstName) + "но";
    // }

    @Override
    public LocalDate getDateOfBirsday() {
        return dateOfBirsday;
    }

    public int getAge() {
        if (dateOfBirsday == null){
            return 0;
        }
        if (dateOfDead == null){
            return getLivePeriod(dateOfBirsday, LocalDate.now());
        }
        else {
            return getLivePeriod(dateOfBirsday, dateOfDead);
        }
    }

    private int getLivePeriod(LocalDate dateLive1, LocalDate dateLive2) {
        return Period.between(dateLive1, dateLive2).getYears();
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getChildrenInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!children.isEmpty()){
            stringBuilder.append(children.get(0).bio());
            for (int i = 1; i < children.size(); i++) {
                stringBuilder.append(", ");
                stringBuilder.append(children.get(i).bio());
            }
        }
        else stringBuilder.append("нет информации");
        return stringBuilder.toString();
    }

    @Override
    public String getSpouseInfo() {
        String string = new String();
        if (spouse == null){
            string += "нет информации";
        }
        else string += this.spouse.bio();
        return string;
    }

    @Override
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    @Override
    public Human getSpouse() {
        return spouse;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setParentNoHuman(Human parentNoHuman) {
        this.parentNoHuman = parentNoHuman;
    }

    @Override
    public void setFamelyName(String famelyName) {
        this.famelyName = famelyName;
    }

    @Override
    public String getFamelyName() {
        return famelyName;
    }

    public String bio() {
        if (this.firstName == null){
            this.firstName = "не известно";
        }
        if (this.famelyName == null){
            this.famelyName = "не известно";
        }
        return this.firstName + " " + this.famelyName;
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        // stringBuilder.append("\nID: " + getIdNo());
        stringBuilder.append("\nID: ");
        stringBuilder.append(getIdNo());
        stringBuilder.append("\nФИО: ");
        stringBuilder.append(bio());
        stringBuilder.append("\nВозраст: ");
        stringBuilder.append(getAge());
        stringBuilder.append("\nОтец: ");
        if (this.father != null)stringBuilder.append(father.bio());
        else stringBuilder.append("нет информации");
        stringBuilder.append("\nМать: ");
        if (this.mother != null) stringBuilder.append(mother.bio());
        else stringBuilder.append("нет информации");

        stringBuilder.append("\nСупруг/супругв: ");
        if (this.spouse != null) stringBuilder.append(getSpouseInfo());
        else stringBuilder.append("нет информации");

        stringBuilder.append("\nДети: ");
        stringBuilder.append(getChildrenInfo());

        //TODO добавить информацию о бывших супругах и, соответственно, детях от других браков

        return stringBuilder.toString();
    }

    @Override
    public long getIdNo() {
        return idNo;
    }

    @Override
    public void setIdNo(long idNo) {
        this.idNo = idNo;
    }

    @Override
    public List<Human> getListParents() {
        List<Human> listParents = new ArrayList<>(3);
        if (father != null){
            listParents.add(father);
        }
        if (mother != null){
            listParents.add(mother);
        }
        if (parentNoHuman != null){
            listParents.add(parentNoHuman);
        }
        return listParents;
    }

    @Override
    public List<Human> getChildren() {
        return children;
    }

    @Override
    public void addAChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            child.addAParent(this);
        }
    }
    
    @Override
    public void removeAChild(Human child) {
        if (children.contains(child)) {
            children.remove((Human) child);
            child.removeAParent(this); 
        }
    }

    @Override
    public boolean addAParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        } else if(parent.getGender().equals(Gender.Alien)) {
            setParentNoHuman(parent);
        }
    
        if (!parents.contains(parent)) {
            parents.add(parent);
            parent.addAChild(this); 
            return true;
        }
        return false;
    }

    @Override
    public void removeAParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(null);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(null);
        } else if(parent.getGender().equals(Gender.Alien)) {
            setParentNoHuman(null);
        }
    
        if (parents.contains(parent)) {
            parents.remove(parent);
            parent.removeAChild(this);
        }
    }

    @Override
    public boolean equals(Object obj){
        if  (this == obj) {
            return true;
        }
        if (obj instanceof Human human) {
            return human.getIdNo() == getIdNo();
        }
        return false;
    }

    @Override
    public String toString() {
        return getHumanInfo();
    }

    @Override
    public int compareTo(Human o) {
        return firstName.compareTo(o.famelyName);
    }

}
