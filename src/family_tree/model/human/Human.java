package family_tree.model.human;



import family_tree.model.ItemFamilyTree;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public class Human implements ItemFamilyTree<Human>{
    private long id ;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human spouse;


//    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate,
//                 Human mother, Human father) {
//        id = -1;
//        this.name = name;
//        this.gender = gender;
//        this.birthDate = birthDate;
//        this.deathDate = deathDate;
//        this.mother = mother;
//        this.father = father;
//        children = new ArrayList<>();
//    }
//
//    public Human(String name, Gender gender, LocalDate date) {
//
//
//        this(name, gender, date, null, null, null);
//
//
//
//    }
//
//    public Human(String name, Gender gender, LocalDate birthDate,
//                 Human mother, Human father) {
//        this(name, gender, birthDate, null, mother, father);
//    }

    private Human(Builder builder){
        id = -1;;
        this.name = builder.name;
        this.gender = builder.gender;
        this.birthDate = builder.birthDate;
        this.deathDate = builder.deathDate;
        this.mother = builder.mother;
        this.father = builder.father;
        children = new ArrayList<>();;
        this.spouse = builder.spouse;
    }

     public static class Builder {
         private long id;
         private String name;
         private Gender gender;
         private LocalDate birthDate;
         private LocalDate deathDate;
         private Human mother;
         private Human father;
         private List<Human> children;
         private Human spouse;

         public Builder setBirthDate(LocalDate birthDate) {
             this.birthDate = birthDate;
             return this;
         }

         public Builder setChildren(List<Human> children) {
             this.children = children;
             return this;
         }

         public Builder setDeathDate(LocalDate deathDate) {
             this.deathDate = deathDate;
             return this;
         }

         public Builder setFather(Human father) {
             this.father = father;
             return this;
         }

         public Builder setGender(Gender gender) {
             this.gender = gender;
             return this;
         }

         public Builder setId(long id) {
             this.id = id;
             return this;
         }

         public Builder setMother(Human mother) {
             this.mother = mother;
             return this;
         }

         public Builder setName(String name) {
             this.name = name;
             return this;
         }

         public Builder setSpouse(Human spouse) {
             this.spouse = spouse;
             return this;
         }

         public Human build() {
             return new Human(this);
         }


     }

// Добавил проверку на пустое поле отца или матери

        public boolean addParent(Human parent) {
            if ((this.father == null) && (parent.getGender().equals(Gender.male))) {
                setFather(parent);
            } else if ((this.mother == null) && (parent.getGender().equals(Gender.female))) {
                setMother(parent);
            }
            return true;
        }


    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }



    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
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
//                Period diff =  Period.(birthDate,deathDate);
//    }


 @Override
    public String toString() {
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
        sb.append((getMotherInfo()));
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }


    public String getSpouseInfo() {
        String res = "супруг(а): ";
        if (spouse == null) {
            res += " нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        if (mother == null) {
            res += " неизвестна";
        } else {
            res += mother.getName();
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        if (father == null) {
            res += " неизвестен";
        } else {
            res += father.getName();
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
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

//    @Override
//    public int compareTo(Human o) {
//        return this.name.compareTo(o.name);
//    }



}