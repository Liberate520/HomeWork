package Family_Tree.model.Human;

import Family_Tree.model.FamilyTree.TreeVersatility;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeVersatility<Human> {
    private long id;
    private String name;
    private LocalDate birth;
    private LocalDate death;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;
    private Human partner;
    private Integer age;

    public Human(String name, LocalDate birth, LocalDate death, Gender gender, Human father, Human mother, Integer age) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.death = death;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
        this.age=age;
    }

    public Human(String name, Gender gender, LocalDate birth) {
        this(name, birth, null, gender, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birth,
             Human father, Human mother) {
        this(name, birth, null, gender, father, mother, null);
    }

    public Human(String name, Integer age, Gender gender) {
        this(name, null, null, gender, null, null, age);
    }


    public boolean addParents(Human parents){
        if (parents.getGender().equals(Gender.Female)) {
            setFather(parents);
        } else {
            setMother(parents);
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

    public void setGender(Gender gender){
        this.gender = gender;
    }
    public void setFather(Human father){
        this.father = father;
    }
    public void setMother(Human mother){
        this.father = mother;
    }
    public Object getGender() {return gender;}
    public Human getMother(){return mother;}

    public Human getFather(){return father;}

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if(father != null){
            list.add(father);
        }
        if(mother != null){
            list.add(mother);
        }
        return list;
    }
    public List<Human> getChildren(){
        return children;
    }

    public int calculateAge(LocalDate birth, LocalDate currentDate) {
        return Period.between(birth, currentDate).getYears();
    }
    public int getAge() {
        if (null == death) {
            return calculateAge(birth, LocalDate.now());
        }else{
            return calculateAge(birth, death);
            }
        }

    public String getName(){
        return name;
    }
    public Integer getage(){return age;}
    public long getID(){
        return id;
    }
    public void setID(long id){this.id = id;}
    public LocalDate getBirth(){
        return birth;
    }
    public LocalDate getDeath(){
        return death;
    }
    public void setBirth(LocalDate birth){this.birth = birth;}
    public void setDeath(LocalDate death){this.death = death;}

    @Override
    public String toString(){return getInf();}//Убери name, age, gender(Добавь о)
//    public String getInfo() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("id: ");
//        sb.append(id);
//        sb.append("Имя: ");
//        sb.append(name);
//        sb.append("Возраст: ");
//        sb.append(getAge());
//        sb.append("Дети: ");
//        sb.append(children);
//        sb.append("Родители: ");
//        sb.append(getFatherInf());
//        sb.append(" , ");
//        sb.append(getMotherInf());
//        if (!(death == null)) {
//            sb.append(getDeath());
//        }
//        return sb.toString();
//    }


    public String getInf() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(" ,Возраст: ");
        sb.append(age);
        sb.append(" ,Гендр: ");
        sb.append(gender);
        return sb.toString();
    }

        public String getMotherInf() {
            String res = "Мама: ";
            Human mother = getMother();
            if (mother != null) {
                res += mother.getName();
            } else {
                res = "Неизвестна";
            }
            return res;
        }
        public String getFatherInf() {
        String res = "Отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res = "Неизвестен";
        }
        return res;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }if(!(obj instanceof Human human)){
            return false;
        }
        return human.getID() == getID();
    }

   /* @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }*/
}


