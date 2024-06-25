package model.human;

import model.family_tree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class  Human implements Serializable, TreeNode<Human> {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> children;
    private Human mother;
    private Human father;
    private Human spouse;

    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father, Human spouse, LocalDate deathDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        children = new ArrayList<>();
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
    }

    public Human(String name, Gender gender) {

        this(name, gender,null, null, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null, null);
    }
    public Human(String name, Gender gender, LocalDate birthDate, Human mother) {
        this(name, gender, birthDate, mother, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(name, gender, birthDate, mother, father, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father, Human spouse) {
        this(name, gender, birthDate, mother, father, spouse, null);
    }




    public int calculateAge() {
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        }else{
            return getPeriod(birthDate,deathDate);
        }
    }
    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    @Override
    public List<Human> getChildren() {
        return null;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void addChild(Human child){
        children.add(child);
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

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }



    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(calculateAge());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getChildInfo());
        return sb.toString();
    }


    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else{
            res += "-";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        Human father = getFather();
        if (father != null){
            res += father.getName();
        } else{
            res += "-";
        }
        return res;
    }

    public String getSpouseInfo(){
        String res = "супруг(а): ";
        Human spouse = getSpouse();
        if (spouse != null){
            res += spouse.getName();
        } else{
            res += "-";
        }
        return res;
    }

    public String getChildInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if(!children.isEmpty()){
            res.append(children.get(0).getName());
            for(int i =1; i<children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

}