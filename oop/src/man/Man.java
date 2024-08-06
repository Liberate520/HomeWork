package man;

import family_tree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Man implements Serializable, FamilyTreeItem {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Man> childrens = new ArrayList<>();
    private Man mother;
    private Man father;
    private Man spouse;


    public Man(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Man mother, Man father, Man spouse) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
    }
    public Man(String name, Gender gender, LocalDate birthDate, Man mother, Man father) {
        this(name, gender, birthDate, null, mother, father, null);

    }

    public Man(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null, null);

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
     public String getName() {
        return name;
    }
    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Man> getChildrens() {
        return childrens;
    }

    public Man getMother() {
        return mother;
    }

    public Man getFather() {
        return father;
    }

    public Man getSpouse() {
        return spouse;
    }

    public int getAge() {
        int age;
        if(this.deathDate != null){
            age = Period.between(this.birthDate, this.deathDate).getYears();
        }
        else{
            age = Period.between(this.birthDate, LocalDate.now()).getYears();
        }
        return age;
    }
    public boolean getMerried(Man spouse){
        if (this.spouse == null){
            this.spouse = spouse;
            return true;
        }
        else{
            System.out.println(this.name + "уже женат/замужем, запрещено");
            return false;
        }
    }
    public boolean addChild(Object child){
        if (!childrens.contains((Man)child)){
            childrens.add((Man)child);
            return true;
        }
        else{
            System.out.println(((Man)child).getName() + "уже был добавлен в список детей");
            return false;
        }
    }
    public boolean addMother(Object mother) {
        if (this.mother == null) {
            this.mother = (Man)mother;
            System.out.println(this.name + "добавлена мама");
            return true;
        } else {
            return false;
        }
    }
    public boolean addFather(Object father){
        if (this.father == null) {
            this.father = (Man)father;
            System.out.println(this.name + "добавлен папа");
            return true;
        } else {
            return false;
        }
    }
    public List<Man> getParents(){
        List<Man> list = new ArrayList<>();
        if (father != null){
            list.add(father);
        }
        if (mother!= null){
            list.add(mother);
        }
        return list;
    }



    @Override
    public boolean equals(Object obj) {
         if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Man anotherMan = (Man) obj;
        return anotherMan.getId() == getId();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder manInfo = new StringBuilder();
        manInfo.append("имя: ");
        manInfo.append(name);
        manInfo.append(" пол: ");
        manInfo.append(gender);

        manInfo.append(" супруг: ");
        if (spouse != null) {
            manInfo.append(spouse.getName());
            manInfo.append(" ");
        }
        else{
            manInfo.append("нет ");
        }

        manInfo.append("родители:");
        if(!getParents().isEmpty()) {
            List<Man> list = getParents();
            for (Man man : list) {
                manInfo.append(man.getName());
                manInfo.append(", ");
            }
        }
        else{
                manInfo.append("неизвестны ");
        }

        manInfo.append("дети: ");
        if(!getChildrens().isEmpty()) {
            List<Man> list = getChildrens();
            for (Man man : list) {
                manInfo.append(man.getName());
                manInfo.append(", ");
            }
        }
        else{
                manInfo.append("нет");
        }
        return manInfo.toString();
     }
}
