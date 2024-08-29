package model.human;

import model.tree.TreeConn;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeConn<Human> {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate deathDay;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human spouse;
    private Alive alive;

    public Human(String name, Gender gender, LocalDate birthDay,
                 LocalDate deathDay, Human mother, Human father,
                 Human spouse, List<Human> children, Alive alive){
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
        this.alive = alive;
        this.children = children;
    }
    public Human(){this(null, null, null);}
    public Human(String name, Gender gender, LocalDate birthDay){
        this(name, gender, birthDay, null, null,
                null,null, new ArrayList<>(), Alive.ALIVE);
    }
    public Human(String name, Gender gender, LocalDate birthDay, LocalDate deathDay){
        this(name, gender, birthDay, deathDay, null,
                null,null, new ArrayList<>(), Alive.DEATH);
    }
    public Human(String name, Gender gender, LocalDate birthDay, Human mother){
        this(name, gender, birthDay, null, mother,
                null,null, new ArrayList<>(), Alive.ALIVE);
    }
    public Human(String name, Gender gender, LocalDate birthDay,
                 LocalDate deathDay, Human mother){
        this(name, gender, birthDay, deathDay, mother,
                null,null, new ArrayList<>(), Alive.DEATH);
    }
    public Human(String name, Gender gender, LocalDate birthDay, Human mother, Human father) {
        this(name, gender, birthDay, null, mother,
                father, null, new ArrayList<>(), Alive.ALIVE);
    }
    public Human(String name, Gender gender, LocalDate birthDay,
                 LocalDate deathDay, Human mother, Human father) {
        this(name, gender, birthDay, deathDay, mother,
                father, null, new ArrayList<>(), Alive.DEATH);
    }
    public Human(String name, Gender gender, LocalDate birthDay,
                 Human mother, List<Human> children){
        this(name, gender, birthDay, null, mother,
                null,null, children, Alive.ALIVE);
    }
    public Human(String name, Gender gender, LocalDate birthDay,
                 LocalDate deathDay, Human mother, List<Human> children){
        this(name, gender, birthDay, deathDay, mother,
                null,null, children, Alive.DEATH);
    }
    public Human(String name, Gender gender, LocalDate birthDay,
                 Human mother, Human father, List<Human> children) {
        this(name, gender, birthDay, null, mother,
                father, null, children, Alive.ALIVE);
    }
    public Human(String name, Gender gender, LocalDate birthDay, LocalDate deathDay,
                 Human mother, Human father, List<Human> children) {
        this(name, gender, birthDay, deathDay, mother,
                father, null, children, Alive.DEATH);
    }
    //public boolean addChild(Human child){
    //    if(!children.contains(child)) {
    //        children.add(child);
    //        return true;
    //    }
    //    return false;
    //}
    public List<Human> getChildren(Human parent){
        if(parent.children.isEmpty()){
            return null;
        }
        return parent.children;
    }

    public int getId(){return id;}
    public String getName(){return name;}
    public Gender getGender(){return gender;}
    public LocalDate getBirthDay(){return birthDay;}
    public LocalDate getDeathDay(){ return deathDay;}
    public Human getMother(){return mother;}
    public Human getFather(){return father;}
    public List<Human> getChildren(){return children;}
    public Human getSpouse(){return spouse;}
    public Alive getAlive(){return alive;}

    public void setId(int id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setGender(Gender gender){this.gender = gender;}
    public void setBirthDay(LocalDate birthDay){this.birthDay = birthDay;}
    public void setDeathDay(LocalDate deathDay){
        this.deathDay = deathDay;
        this.alive = Alive.DEATH;
    }
    private void setMother(Human mother){this.mother = mother;}
    private void setFather(Human father){this.father = father;}
    public void setSpouse(Human spouse){
        if(this.getGender()!=spouse.getGender()){
            this.spouse = spouse;
            spouse.spouse = this;
        }
        else {
            System.out.println("Невозможно добавить однополого супруга!");
        }
    }

    public void addChildren(Human child){
        if(children.contains(child)){
            System.out.println("Ребенок уже добавлен!");
        }
        else {children.add(child);}
    }
    public void addParent(Human parent){
        if(parent.getGender().equals(Gender.FEMALE)){
            setMother(parent);
        } else if (parent.getGender().equals(Gender.MALE)) {
            setFather(parent);
        }
    }
    public List<Human> getParents(){
        List<Human> parentsList = new ArrayList<>();
        if(father == null && mother == null){
            System.out.println(this.getName() + " не имеет родителей!");
        }
        if(father != null){
            parentsList.add(father);
        }
        if(mother != null){
            parentsList.add(mother);
        }
        return parentsList;
    }
    public int getAge(){
        if(this.alive.equals(Alive.ALIVE)){
            return period(birthDay, LocalDate.now());
        }
        else {
            return period(birthDay, deathDay);
        }

    }
    private int period(LocalDate start, LocalDate end){
        Period life = Period.between(start,end);
        return life.getYears();
    }
    @Override
    public String toString(){
        return getInfo();
    }
    private String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("ID: ");
        info.append(getId());
        info.append(", имя: ");
        info.append(getName());
        info.append(", пол: ");
        info.append(getGender());
        info.append(", дата рождения: ");
        info.append(getBirthDay());
        if(alive.equals(Alive.DEATH)){
            info.append(", дата смерти: ");
            info.append(getDeathDay());
            if(getGender() == Gender.MALE) {
                info.append(", прожил ");
            }
            if(getGender() == Gender.FEMALE) {
                info.append(", прожила ");
            }
            info.append(getAge());
            info.append(" лет");

        } else {
            info.append(", возраст: ");
            info.append(getAge());
        }
        info.append(", родители: ");
        info.append(getParentsInfo());
        info.append(", супруг(а): ");
        if(spouse!=null){
            info.append(spouse.name);
        } else {info.append("отсутствует");}
        info.append(getChildrenInfo());


        return info.toString();
    }

    public String getParentsInfo(){
        StringBuilder infoParents = new StringBuilder();
        infoParents.append("мать - ");
        if(mother != null){
            infoParents.append(mother.name);
        } else {
            infoParents.append("неизвестна");
        }
        infoParents.append(", отец - ");
        if(father != null){
            infoParents.append(father.name);
        } else {
            infoParents.append("неизвестен");
        }
       return infoParents.toString();
    }
    public String getChildrenInfo(){
        StringBuilder infoChildren = new StringBuilder();
        infoChildren.append(", дети: ");
        if (!children.isEmpty()){
            for(Human child : children){
                infoChildren.append(child.name);
                infoChildren.append(", ");
            }
        }
        else {
            infoChildren.append("отсутствуют,");
        }
        return infoChildren.toString();
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

}

