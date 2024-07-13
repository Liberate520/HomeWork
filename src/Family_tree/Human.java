package Family_tree;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private int  id;
    private Gender gender;
    private String name;
    private LocalDate birthDate, deathDate;
    private List<Human> parents,children ;
    private Human spouse;

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human(String name, LocalDate birthDate, LocalDate deathDate, /*List<Human> children,*/ Human father, Human mother, Gender gender) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        //this.children = children;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }
// Вызов конструктора с пр                                    именением this означает, что идёт обращение к текущему конструктору.
    public Human(String name, LocalDate birthDate, Gender gender) {
        this(name, birthDate, null, null, null, gender);        
    }

    public Human (String name, LocalDate birthDate, Human father, Human mother, Gender gender) {
        this(name, birthDate, null, father, mother, gender);   
    }

    public boolean addChild(Human child) {
        if(!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if(!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.MALE) {
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.FEMALE) {
                return parent;
            }
        }
        return null;
    }

    public int getAge() {
        if (deathDate == null) {
            return getPeriod (birthDate, LocalDate.now());
        } else {
            return getPeriod (birthDate, deathDate);
        }
    }

    private int getPeriod (LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public Human getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Human> getChildren() {
        return children;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }



    // public void getChildren() {
    //     if (children == null) {
    //         System.out.println("No children");
    //     } else {
    //         for (Human child : children) {
    //             System.out.println(child);
    //         }
    //     }
    // }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    // public void setFather(Human father) {
    //     this.father = father;
    // }

    // public void setMother(Human mother) {
    //     this.mother = mother;
    // }

    public void setGender(Gender gender) {

        this.gender = gender;
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
        return human.getId() == human.getId();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(",name: ");
        sb.append(name);
        sb.append(",gender: ");
        sb.append(getGender());
        sb.append(",ages: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSposeInfo());
        




}
    
    
