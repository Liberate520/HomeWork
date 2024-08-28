package family_tree.model.human;

import family_tree.model.family_tree.FamilyTreeItem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyTreeItem<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human mother, Human father){
        id = -1;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, LocalDate birthDate, Gender gender){
        this(name, birthDate, null, gender, null, null);
    }

    public Human(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Human getMother(Human mother) {
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

    public boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if (parent.gender.equals(Gender.Female)) {
            setMother(parent);
        } else if (parent.gender.equals(Gender.Male)) {
            setFather(parent);
        }
        return true;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

   public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        }else {
            return getPeriod(birthDate, deathDate);
        }
   }
   public int getPeriod(LocalDate birthDate, LocalDate deathDate){
       Period diff = Period.between(birthDate, deathDate);
       return diff.getYears();
   }

   public String toString(){
        return getInfo();
   }

   public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ");
        stringBuilder.append(id);
        stringBuilder.append(", имя: ");
        stringBuilder.append(name);
        stringBuilder.append(", возраст: ");
        stringBuilder.append(getAge());
        stringBuilder.append(", пол: ");
        stringBuilder.append(gender);
        stringBuilder.append(", мать: ");
        stringBuilder.append(getMotherInfo());
       stringBuilder.append(", отец: ");
       stringBuilder.append(getFatherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getChildrenInfo());
        return stringBuilder.toString();
   }

   public String getMotherInfo(){
       if (this.mother == null)
           return "Неизвестно";
       return this.mother.name;
   }
    private String getFatherInfo() {
        if (this.father == null)
            return "Неизвестно";
        return this.father.name;
    }

    public String getChildrenInfo(){
        StringBuilder chil = new StringBuilder();
        chil.append("Дети: ");
        if (children.size() != 0){
            chil.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                chil.append(", ");
                chil.append(children.get(i).getName());
            }
        }else {
            chil.append("отсутствуют");
        }
        return chil.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
