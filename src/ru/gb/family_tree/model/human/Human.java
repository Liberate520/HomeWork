package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.Period;


public class Human implements Serializable, FamilyTreeElement<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate dob, dod;
    private List<Human> children = new List<Human>;
    private Human mother, father;
    private HashMap<Human, SpouseStatus> spouses = new HashMap<>();

        public Human(String name, Gender gender, String dob) {
        this.id = -1;
        this.name = name;
        this.gender = gender;
        this.dob = LocalDate.parse(dob);
        this.dod = dod;
        this.children = children;
        this.mother = mother;
        this.father = father;
        this.spouses = spouses;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id=id;
    }


    public void PrintId() {
        System.out.println("Id: " + this.getId());
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void PrintName() {
        System.out.println("Surname Name Patronymic: " + this.getName());
    }


    public LocalDate getDob() {
        return dob;
    }


    public void setDob(LocalDate dob) {
        this.dob = dob;
    }


    public void PrintDob() {
        System.out.println("Date of Birth (year-month-day): " + this.getDob());
    }


    public LocalDate getDod() {
        return dod;
    }


    public void setDod(LocalDate dod) {
        this.dod = dod;
    }


    public void PrintDod() {
        if (dod == null) {
            System.out.println("Is alive");
        } else {
            System.out.println("Date of Death (year-month-day): " + this.getDod());
        }
    }


    public Gender getGender() {
        return gender;
    }


    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public void PrintGender() {
        System.out.println("Gender: " + this.getGender());
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


    public String getChildrenAbout() {
        StringBuilder childrenAbout = new StringBuilder();
        childrenAbout.append("Children: ");
        if(children.size() > 0) {
            childrenAbout.append(children.getFirst().getName());
            for (int i = 1; i < children.size(); i++) {
                childrenAbout.append(", ");
                childrenAbout.append(children.get(i).getName());
            }
        } else {
            childrenAbout.append("None");
        }
        return childrenAbout.toString();
    }


    public void PrintChildren() {
        System.out.println(getChildrenAbout());
    }


    public Human getMother() {
        return mother;
    }


    public void setMother(Human mother) {
        this.mother = mother;
    }


    public String getMotherAbout() {
        String motherAbout = "Mother: ";
        Human mother = getMother();
        if (mother == null) {
            motherAbout += "Unknown";
        } else {
            motherAbout += mother.getName();
        }
        return motherAbout;
    }


    public void PrintMother() {
        System.out.println(getMotherAbout());
    }


    public Human getFather() {
        return father;
    }


    public void setFather(Human father) {
        this.father = father;
    }


    public String getFatherAbout() {
        String fatherAbout = "Father: ";
        Human father = getFather();
        if (father == null) {
            fatherAbout += "Unknown";
        } else {
            fatherAbout += father.getName();
        }
        return fatherAbout;
    }


    public void PrintFather() {
        System.out.println(getFatherAbout());
    }


    public void addParent(Human parent) {
        if (parent.gender.equals(Gender.male)) {
            this.setFather(parent);
            if (!parent.getChildren().contains(this)){
                parent.addChild(this);
            }
        }else if (parent.gender.equals(Gender.female)) {
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


    public String getSpousesAbout() {
        StringBuilder spousesAbout = new StringBuilder();
        spousesAbout.append("Spouses: ");

        if (!spouses.isEmpty()) {
            // Перебираем пары ключ-значение с помощью метода entrySet()
            boolean first = true;
            for (Map.Entry<Human, SpouseStatus> entry : spouses.entrySet()) {
                if (!first) {
                    spousesAbout.append(", ");
                } else {
                    first = false;
                }
                // Добавляем ключ - имя
                spousesAbout.append(entry.getKey().getName());
                spousesAbout.append(": ");
                // Добавляем значение - статус
                spousesAbout.append(entry.getValue());
            }
        } else {
            spousesAbout.append("None");
        }

        return spousesAbout.toString();
    }


    public void PrintSpouses() {
        System.out.println(getSpousesAbout());
    }


    private int getInterval(LocalDate dob, LocalDate dod) {
        Period interval = Period.between(dob, dod);
        return interval.getYears();
    }


    public int getAge() {
        if (dod == null) {
            return getInterval(dob, LocalDate.now());
        } else {
            return getInterval(dob, dod);
        }
    }


    public String getLifeStatus() {
        if (dod == null) {
            return "Alive";
        } else {
            return "Dead";
        }
    }


    public void PrintAge() {
        if (dod == null) {
            System.out.println(getLifeStatus() + ", age is: " + this.getAge());
        } else {
            System.out.println(getLifeStatus() + ", age was: " + this.getAge());
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
        sb.append("\nName: ");
        sb.append(name);
        sb.append("\nGender: ");
        sb.append(getGender());
        sb.append("\nAge: " + getAge() + ". " + getLifeStatus());
        sb.append("\n" + getChildrenAbout());
        sb.append("\n" + getMotherAbout());
        sb.append("\n" + getFatherAbout());
        sb.append("\n" + getSpousesAbout());
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


//----------------------------------------------------------------------