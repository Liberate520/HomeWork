package human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
 public class Human implements Serializable,Comparable<Human>{
     private String name;
    private Gender sex;
    private LocalDate brthDate;
    private LocalDate dthDate;
    private int id;
    private List<Human> children;
    private Human father;
    private Human mother;
    private Human spouse;




    public Human( String name, Gender sex, LocalDate brthDate, LocalDate dthDate, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.sex = sex;
        this.brthDate = brthDate;
        this.dthDate = dthDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();

    }

    public Human(String name, Gender sex, LocalDate brthDate) {
        this(name, sex, brthDate, null, null, null);

    }

    public Human(String name, Gender sex, LocalDate brthDate, Human father, Human mother) {
        this(name, sex, brthDate, null, father, mother);
    }



     public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }


     public int getId() {
         return id;
     }

     public void setId(int id) {
        this.id = id;
    }

    public Gender getSex() {
        return sex;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

     public boolean addParent(Human parent) {
         if (parent.getSex().equals(Gender.Male)) {
             setFather(parent);
         } else if (parent.getSex().equals(Gender.Female)) {
             setMother(parent);
         }
         return true;
     }


    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getParents() {
        {
            List<Human> list = new ArrayList<>(2);
            if (father != null) {
                list.add(father);
            }
            if (mother != null) {
                list.add(mother);
            }
            return list;
        }
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBrthDate() {
        return brthDate;
    }

    public LocalDate getDthDate() {
        return dthDate;
    }

    public List<Human> getChildren() {
        return children;
    }

     public void setSex(Gender sex) {
         this.sex = sex;
     }

     public void setName(String name) {
         this.name = name;
     }

     public void setBrthDate(LocalDate brthDate) {
        this.brthDate = brthDate;
    }

    public void setDthDate(LocalDate dthDate) {
        this.dthDate = dthDate;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("id: ");
        info.append(id);
        info.append(", ");
        info.append("имя: ");
        info.append(name);
        info.append(", ");
        info.append("пол: ");
        info.append(sex);
        info.append(", ");
        info.append("дата рождения: ");
        info.append(brthDate);
        info.append(", ");
        info.append(getSprousInfo());
        info.append(", ");
        info.append(getFatherInfo());
        info.append(", ");
        info.append(getMotherInfo());
        info.append(", ");
        info.append(getChildrenInfo());
        return info.toString();

    }

    public String getSprousInfo() {
        String infoSprous = "супруг(а): ";
        if (spouse == null) {
            infoSprous += "отсутствует";
        } else {
            infoSprous += spouse.getName();
        }
        return infoSprous;
    }

    public String getFatherInfo() {
        String infoSprous = "отец: ";
        Human father = getFather();
        if (father == null) {
            infoSprous += "отсутствует";
        } else {
            infoSprous += father.getName();
        }
        return infoSprous;
    }

    public String getMotherInfo() {
        String infoSprous = "мать: ";
        Human mather = getMother();
        if (mather == null) {
            infoSprous += "отсутствует";
        } else {
            infoSprous += mather.getName();
        }
        return infoSprous;
    }

     public String getChildrenInfo() {
         StringBuilder res = new StringBuilder();
         res.append("дети: ");
         if (!children.isEmpty()) {
             res.append(children.getFirst().getName());
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
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId()==getId();
    }

     @Override
     public int compareTo(Human o) {
         return this.name.compareTo(o.name);
     }
 }
