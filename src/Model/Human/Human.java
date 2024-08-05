package Model.Human;

import Model.FamilyTree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human  implements Serializable, Comparable<Human>, FamilyTreeItem<Human> {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;

//    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, List<Human> parents) {
//        this.name = name;
//        this.gender = gender;
//        this.birthDate = birthDate;
//        this.deathDate = deathDate;
//        this.parents = parents;
//        children = new ArrayList<>();
//    }
//
//    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
//        this(name, gender, birthDate, deathDate, null);
//        parents = new ArrayList<>();
//    }


    public Human() {
        id = -1;
        name = null;
        gender = null;
        birthDate = null;
        deathDate = null;
        mother = null;
        father = null;
        parents = new ArrayList<>();
        children = new ArrayList<>();
        spouse = null;
    }

    private int getAge(LocalDate birthDate, LocalDate deathDate){
        if (deathDate == null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        }
        else {
            return Period.between(birthDate, deathDate).getYears();
        }
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

    public List<Human> getParents() {
        return parents;
    }

    public void setParents() {
        parents.add(mother);
        parents.add(father);
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpouseInfo() {
        if (spouse == null) {
            return "отсутствует";
        }
        else {
            return spouse.name;
        }
    }

    public StringBuilder getParentsInfo() {
        StringBuilder parentsList = new StringBuilder();
        if (mother != null) {
            parentsList.append("мать: " + mother.getName());
        }
        else {
            parentsList.append("мать: неизвестна");
        }
        if (father != null) {
                parentsList.append(", отец: " + father.getName());
            }
            else {
                parentsList.append(", отец: неизвестен");
            }
        return parentsList;
    }
//    public StringBuilder getParentsInfo() {
//        StringBuilder parentsList = new StringBuilder();
//        if (parents.isEmpty()) {
//            parentsList.append("неизвестны");
//            return parentsList;
//        }
//        else  {
//            if (parents.get(0) != null) {
//                parentsList.append("мать: " + parents.get(0).getName());
//            }
//            else {
//                parentsList.append("мать: неизвестна");
//            }
//            if (parents.get(1) != null) {
//                parentsList.append(", отец: " + parents.get(1).getName());
//            }
//            else {
//                parentsList.append(", отец: неизвестен");
//            }
//            return parentsList;
//        }
//    }

    public StringBuilder getChildrenInfo() {
        StringBuilder childrenList = new StringBuilder();
        if (children.isEmpty()) {
            childrenList.append("неизвестны");
            return childrenList;
        }
        else {
            for (Human child : children) {
                childrenList.append(child.getName() + ", ");
            }
            childrenList.delete(childrenList.length() - 2, childrenList.length());
            return childrenList;
        }
    }

    public int getAgeInfo(){
        return getAge(birthDate, deathDate);
    }

    @Override
    public String toString() {
        return "ID:" + id + ", имя: " + name + ", пол: " + gender + ", возраст: " + getAgeInfo() + ", супруг(а): " + getSpouseInfo() +  ", родители: " + getParentsInfo() + ", дети: " + getChildrenInfo();
    }

    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }
}
