package re.zip.famely_tree.humans;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// import re.zip.famely_tree.humans.Gender;

public class Human {
    private long idNo;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirsday; 
    private LocalDate dateOfDead;
    private Gender gender;
    private List<Human> children;
    private Human mother, father, parentNoHuman, spouse;
    // private Human child; 
    
    public Human(String firstName, String lastName, LocalDate dateOfBirsday, LocalDate dateOfDead, Gender gender, Human mother, Human father) {
        idNo = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirsday = dateOfBirsday;
        this.dateOfDead = dateOfDead;
        this.gender = gender;
        children = new ArrayList<>();
        this.mother = mother;
        this.father = father;
        
    }

    public Human(String firstName, String lastName, LocalDate dateOfBirsday, Gender gender, Human mother, Human father) {
        this(firstName, lastName, dateOfBirsday, null, gender, mother, father);
    }
    
    public Human(String firstName, String lastName, LocalDate dateOfBirsday, Gender gender) {
        this(firstName, lastName, dateOfBirsday, null, gender, null, null);
    }

    public boolean addACild(Human child) {
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addAParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)){
            setFather(parent);
            return true;
        }
        else if (parent.getGender().equals(Gender.Female)) {
               setMother(parent);
               return true; 
            }
            else if(parent.getGender().equals(Gender.Alien)){
                setParentNoHuman(parent);
                return true; 
            }
        return false; 
    }

    public String getFatherName() {
        HashMap <String, String> fatherNames = new HashMap<String, String> ();
        fatherNames.put("Павел", "Павлов");
        fatherNames.put("Андрей", "Андреев");
        fatherNames.put("Евгений", "Евгеньев");
        fatherNames.put("Лев", "Львов");
        fatherNames.put("Мордух", "Мордухов");
        fatherNames.put("Авраам", "Авраамов");
        fatherNames.put("Абрам", "Абрамов");
        fatherNames.put("Виктор", "Викторов");
        if (this.father == null){
            return "";
        }
        if (this.getGender().equals(Gender.Male)){
            return fatherNames.get(this.father.firstName) + "ич";
        }
        else if (this.getGender().equals(Gender.Female)){
            return fatherNames.get(this.father.firstName) + "на";
        }
        return fatherNames.get(this.father.firstName) + "но";
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

    public String getSpouseInfo() {
        String string = new String();
        if (spouse == null){
            string += "нет информации";
            }
        else string += this.spouse.bio();
        return string;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

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


    public String bio() {
        if (this.firstName == null){
            this.firstName = "не известно";
        }
        if (this.lastName == null){
            this.lastName = "не известно";
        }
            return this.firstName + " " + getFatherName() + " " + this.lastName;
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        // stringBuilder.append("\nID: " + getIdNo());
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

    public long getIdNo() {
        return idNo;
    }

    public void setIdNo(long idNo) {
        this.idNo = idNo;
    }

    public List<Human> getListParents() {
        List<Human> listParents = new ArrayList<>(3);
        if (father != null){
            listParents.add(father);
        }
        if (mother != null){
            listParents.add(mother);
        }
        if (mother != null){
            listParents.add(mother);
        }
        if (parentNoHuman != null){
            listParents.add(parentNoHuman);
        }
        return listParents;
    }

    public List<Human> getChildren() {
        return children;
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

    // public String getFirstName() {
    //     return firstName;
    // }
}
