import jdk.internal.icu.text.UnicodeSet;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable {
    private long id;
   private String name;
   private Gender gender;
   private LocalDate birthDate, deathDate;
   private Human Father, Mother;
   private List <Human> children;
    private UnicodeSet parents;

    public Human(String name, Gender gender, LocalDate birthDate){
        this.parents = parents;
        id=0;
      this.name=name;
      this.gender=gender;
      this.birthDate=birthDate;
      this.deathDate=deathDate;
      children=new ArrayList<>();
   }

    public long getID() {
        return id;
    }

    public void setID(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
   }
   public Gender getGender(){
       return gender;
   }
    public Human getFather() {
        return Father;
    }
    public void setFather(Human Father) {
        this.Father = Father;
    }
    public Human getMother() {
        return Mother;
    }
    public void setMother(Human Mother) {
        this.Mother = Mother;
    }
    public int getAge (){
        return getPeriod(birthDate, Objects.requireNonNullElseGet(deathDate, LocalDate::now));
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate,deathDate);
        return diff.getYears();
    }

    public List<Human> getChildren() {
           return children;
    }
    public void addChild(Human child) {
        this.children.add(child);
    }
    public List<Human> getParents () {
        List<Human> list = new ArrayList<>(2);
        if (Father != null) {
            list.add(Father);
        }
        if (Mother != null) {
            list.add(Mother);
        }
        return list;
    }
    public void addParents(Human human) {
       this.parents.add((CharSequence) human);
    }
    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
    StringBuilder sb =new StringBuilder();
    sb.append("id: ");
    sb.append(id);
    sb.append("name: ");
    sb.append(name);
    sb.append("gender: ");
    sb.append(gender);
    sb.append("age: ");
    sb.append(getAge());
    sb.append("parents:");
    sb.append(getParents());
    sb.append("child");
    sb.append(getChildren());
    return sb.toString();
    }



}
