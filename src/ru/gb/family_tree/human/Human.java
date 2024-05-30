package ru.gb.family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    private long id;
    private String name;
    // private Human mother, father;
    private List<Human> parents;    /// ТУТ МОЖЕТ БЫТЬ БОЛЕЕ 2 ЧЕЛОВЕК!!! Исправить!!!
    private List<Human> children;
    private LocalDate birthDate, deathDate;
    private Gender gender;
    private Human spouse;
    private Human father;
    private Human mother;        

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {

        id = -1; // ПОдумать, как улучшить!!!

        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }
        
    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);

    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
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
        if (!parents.contains(parent) && parents.size() < 2) {  ///  && parents.size() < 2 ДОБАВИЛ Я
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;        
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    } 
    
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

    public String getSpouseInfo() {
        String res = "супруг[а]: ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        if (mother == null) {
            res += "неизвестна";
        } else {
            res += mother.getName();
        }
        return res;
    }    
    
    public String getFatherInfo() {
        String res = "отец: ";
        if (father == null) {
            res += "неизвестен";
        } else {
            res += father.getName();
        }
        return res;
    } 
    
    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());  ///  ОТ ЭТОГО МОЖНО ИЗБАВИТЬСЯ, НАВЕРНО???
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");                       /// ВОТ ТУТ БУДЕТ НЕМНОГО НЕКРАСИВО
                res.append(children.get(i).getName());

            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();

    }

    public void setSpouse(Human spouse) {this.spouse = spouse;}

    public Human getSpouse() {return spouse;}
    
    public String getName() {return name;}

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public LocalDate getBirthDate() {return birthDate;}

    public LocalDate getDeathDate() {return deathDate;}

    public List<Human> getParents() {return parents;}

    public List<Human> getChildren() {return children;} 
    
    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}

    public void setDeathDate(LocalDate deathDate) {this.deathDate = deathDate;}

    public Gender getGender() {return gender;}

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
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
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
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
        return human.getId() == getId();   /// ТУТ ОПАСНО!!! Если id == -1, то ...
    }

    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }

} 
