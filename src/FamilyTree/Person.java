package src.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;

public class Person extends FTObjects implements Serializable{

    private String name;
    private Integer birthDay;
    private Integer deathDay;
    private Sex sex;
    private Integer generation;
    private ArrayList<String> spouseName;
    private ArrayList<String> childrenName;
    private String additionalField;


    public Person(String name, Integer birthDay, Integer deathDay, Sex sex, String additionalField) {
        this(name, birthDay, deathDay, sex);
        this.additionalField = additionalField;
    }

    public Person(String name, Integer birthDay, Integer deathDay,
                  Sex sex) {
        super();
        this.name = name;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.sex = sex;
        spouseName = new ArrayList<String>();
        childrenName = new ArrayList<String>();
    }

    public boolean addChild(String child){
        if(!childrenName.contains(child)){
            return childrenName.add(child);
        }
        else {
            return false;}
    }

    public boolean addSpouseName(String spouse) {
        if (spouseName == null){
            return spouseName.add(spouse);
        }
        else{
            if (!spouseName.contains(spouse)) {
                return spouseName.add(spouse);
            }
            else {
                return false;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(Integer deathDay) {
        this.deathDay = deathDay;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public ArrayList<String> getSpouseName() {
        return spouseName;
    }

    public ArrayList<String> getChildrenName() {
        return childrenName;
    }

    public boolean setChildrenName(String childrenName) {
        this.childrenName.add(childrenName);
        return false;
    }

    public String getAdditionalField() {
        return additionalField;
    }

    public void setAdditionalField(String additionalField) {
        this.additionalField = additionalField;
    }

    @Override
    public String toString() {
        return "Person: " + name + ",\t years of life: " + birthDay + " - " + deathDay +
                ",\t spouses: " + spouseName +
                ",\n\t children: " + childrenName+
                ",\n\t  sex: " + sex +
                ",\n\t\t years of government: " + additionalField;
    }
}
