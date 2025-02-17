package family_tree.model.human;

import family_tree.model.family_tree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, TreeNode<Human> {
    private long id;
    private String surname, name, middleName;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    private Human dad, mom, spouse;
    private List<Human> children;

    public Human(String surname, String name, String middleName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        id = -1;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        children = new ArrayList<>();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName() {
        return surname + " " + name + " " + middleName;
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

    @Override
    public int getAge() {
        if (deathDate == null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        }
        return Period.between(birthDate, deathDate).getYears();
    }

    public Human getDad() {
        return dad;
    }

    public void setDad(Human dad) {
        this.dad = dad;
    }

    public Human getMom() {
        return mom;
    }

    public void setMom(Human mom) {
        this.mom = mom;
    }

    @Override
    public Human getSpouse() {
        return spouse;
    }

    @Override
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    @Override
    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public boolean addChild(Human child){
        if (!children.equals(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    @Override
    public boolean addParent(Human parent){
        if (parent.getGender().equals(Gender.М)){
            setDad(parent);
        } else if (parent.getGender().equals(Gender.Ж)) {
            setMom(parent);
        }
        return true;
    }

    @Override
    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (dad != null){
            list.add(dad);
        }
        if (mom != null){
            list.add(mom);
        }
        return list;
    }

    public String isAlive(){
        if (deathDate == null) {
            return "Возраст (текущий): ";
        }
        return "Возраст (на момент смерти): ";
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + id + "\n");
        sb.append("ФИО: " + getFullName() + "\n");
        sb.append("Пол: " + getGender() + "\n");
        sb.append(isAlive() + getAge() + "\n");
        sb.append(getSpouseInfo() + "\n");
        sb.append(getDadInfo() + "\n");
        sb.append(getMomInfo() + "\n");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    private String getSpouseInfo() {
        String res = "Супруг(а): ";
        if (spouse == null){
            res += "нет";
        } else {
            res += spouse.getFullName();
        }
        return res;
    }

    private String getDadInfo() {
        String res = "Отец: ";
        Human dad = getDad();
        if (dad != null){
            res += dad.getFullName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    private String getMomInfo() {
        String res = "Мать: ";
        Human mom = getMom();
        if (mom != null){
            res += mom.getFullName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    private String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getFullName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getFullName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
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
