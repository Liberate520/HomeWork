package model.human;

import model.family_tree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  Human implements Serializable, TreeNode<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> children;
    private Human mother;
    private Human father;
    private HashMap<Human, SpouseStatus> spouses = new HashMap<>();



    public Human(String name, Gender gender, String birthDate) {
        this.id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = LocalDate.parse(birthDate);
        this.deathDate = deathDate;
        this.children = new ArrayList<>();
        this.mother = mother;
        this.father = father;
        this.spouses = new HashMap<>();
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id=id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public LocalDate getDeathDate() {
        return deathDate;
    }
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }



    public List<Human> getChildren() {
        return children;
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public String getChildrenInfo() {
        StringBuilder childrenInfo = new StringBuilder();
        childrenInfo.append("дети: ");
        if(children.size() > 0) {
            childrenInfo.append(children.getFirst().getName());
            for (int i = 1; i < children.size(); i++) {
                childrenInfo.append(", ");
                childrenInfo.append(children.get(i).getName());
            }
        } else {
            childrenInfo.append("-");
        }
        return childrenInfo.toString();
    }




    public Human getMother() {
        return mother;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }

    public String getMotherInfo() {
        String motherInfo = "мать: ";
        Human mother = getMother();
        if (mother == null) {
            motherInfo += "-";
        } else {
            motherInfo += mother.getName();
        }
        return motherInfo;
    }



    public Human getFather() {
        return father;
    }
    public void setFather(Human father) {
        this.father = father;
    }

    public String getFatherInfo() {
        String fatherInfo = "отец: ";
        Human father = getFather();
        if (father == null) {
            fatherInfo += "-";
        } else {
            fatherInfo += father.getName();
        }
        return fatherInfo;
    }


    public void addParent(Human parent) {
        if (parent.gender.equals(Gender.Male)) {
            this.setFather(parent);
            if (!parent.getChildren().contains(this)){
                parent.addChild(this);
            }
        }else if (parent.gender.equals(Gender.Female)) {
            this.setMother(parent);
            if (!parent.getChildren().contains(this)){
                parent.addChild(this);
            }
        }
    }




    public HashMap<Human, SpouseStatus> getSpouse() {
        return spouses;
    }

    public void addSpouse(Human spouse, SpouseStatus status) {
        if (!this.spouses.containsKey(spouse)) {
            this.spouses.put(spouse, status);
            spouse.addSpouse(this, status);
        }
    }

    public String getSpousesInfo() {
        StringBuilder spousesInfo = new StringBuilder();
        spousesInfo.append("супруг(а): ");

        if (!spouses.isEmpty()) {
            boolean first = true;
            for (Map.Entry<Human, SpouseStatus> entry : spouses.entrySet()) {
                if (!first) {
                    spousesInfo.append(", ");
                } else {
                    first = false;
                }
                spousesInfo.append(entry.getKey().getName());
                spousesInfo.append(" ");

                spousesInfo.append(entry.getValue());
            }
        } else {
            spousesInfo.append("-");
        }

        return spousesInfo.toString();
    }




    private int getInterval(LocalDate birthDate, LocalDate deathDate) {
        Period interval = Period.between(birthDate, deathDate);
        return interval.getYears();
    }

    public int getAge() {
        if (deathDate == null) {
            return getInterval(birthDate, LocalDate.now());
        } else {
            return getInterval(birthDate, deathDate);
        }
    }

    public String getLifeStatus() {
        if(gender.equals(Gender.Female)) {
            if (deathDate == null) {
                return "жива";
            } else {
                return "умерла (" + deathDate + " )";
            }
        } else{
            if (deathDate == null) {
                return "жив";
            } else {
                return "умер (" + deathDate + ")";
            }
        }
    }




    @Override
    public String toString() {
        return getAbout();
    }

    public String getAbout() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append("\nимя: ");
        sb.append(name);
        sb.append("\nпол: ");
        sb.append(getGender());
        sb.append("\nвозраст: " + getAge() + ", " + getLifeStatus());
        sb.append("\n");
        sb.append(getChildrenInfo());
        sb.append("\n");
        sb.append(getMotherInfo());
        sb.append("\n");
        sb.append(getFatherInfo());
        sb.append("\n");
        sb.append(getSpousesInfo());
        sb.append("\n");
        return sb.toString();
    }





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
}