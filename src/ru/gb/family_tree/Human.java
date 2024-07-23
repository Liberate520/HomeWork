package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;
    private Human mother;
    private Human father;
    private Human spouse;
    private List<Human> children;


    public Human(String lastName, String firstName, String patronymic, LocalDate dateOfBirth, LocalDate dateOfDeath, Gender gender, Human mother, Human father) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.dateOfDeath = dateOfDeath;
        id = -1;
        children = new ArrayList<Human>();
    }

    public Human(String lastName, String firstName, LocalDate dateOfBirth, Gender gender, Human mother, Human father) {
        this(lastName, firstName, null, dateOfBirth, null, gender, mother, father );
    }

    public Human(String lastName, String firstName, LocalDate dateOfBirth, Gender gender) {
        this(lastName, firstName, null, dateOfBirth, null, gender, null, null );
    }

    public boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if (parent.getGender().equals(Gender.Female)){
           setMother(parent);
        }else if (Gender.Male.equals(parent.getGender())){
            setFather(parent);
        }

        return true;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Human>getParents(){
        List<Human> listParens = new ArrayList<>();
        if (father!=null) listParens.add(father);
        if (mother!=null) listParens.add(mother);
        return listParens;
    }

    //дописать метод расчета возраста


    @Override
    public String toString() {

        StringBuilder sorse = new StringBuilder();
        sorse.append("Человек id ");
        sorse.append(getId());
        sorse.append(", ");
        sorse.append("фамилия ");
        sorse.append(getLastName());
        sorse.append(", ");
        sorse.append("имя ");
        sorse.append(getFirstName());
        sorse.append(", ");
        sorse.append("отчетство: ");
        if (!getPatronymic().equals(""))
            sorse.append(getPatronymic());
        else  sorse.append("нет");
        sorse.append(", ");
        sorse.append("пол ");
        sorse.append(getGender());
        sorse.append(", ");
        sorse.append("дата рождения: ");
        sorse.append(getDateOfBirth().toString());
        sorse.append(", ");
        sorse.append("мать: ");
        sorse.append(getMotherInfo());
        sorse.append(", ");
        sorse.append("отец: ");
        sorse.append(getFatherInfo());
        sorse.append(", ");
        sorse.append("супруг(а): ");
        sorse.append(getSpouseInfo());
        sorse.append(", ");
        sorse.append("дети: ");
        sorse.append(getChildrenInfo());

        return sorse.toString();
    }

    public String getMotherInfo() {
       String motherStr = "";
       Human mother = getMother();
       if (mother!=null){
           motherStr = mother.getFirstName()+ " "+ mother.getLastName();
       } else{
           motherStr = "нет";
       }
        return motherStr;
    }

    public String getFatherInfo() {
        String fatherStr = "";
        Human father = getFather();
        if (mother!=null){
            fatherStr = father.getFirstName()+ " "+ father.getLastName();
        } else{
            fatherStr = "нет";
        }
        return fatherStr;
    }


    public String getSpouseInfo() {
        String spouseStr = "";
        Human spouse = getSpouse();
        if (spouse!=null){
            spouseStr = spouse.getFirstName()+ " "+ spouse.getLastName();
        } else{
            spouseStr = "нет";
        }
        return spouseStr;
    }


    public String getChildrenInfo() {
        StringBuilder childrenStr = new StringBuilder();
       List<Human> children = getChildren();
        if (children.size()!=0){

            for (int i = 0; i < children.size()-1; i++) {
                childrenStr.append(children.get(i).getFirstName()).append(" ").append(children.get(i).getLastName());
                childrenStr.append(", ");
            }
            childrenStr.append(children.get(children.size()-1).getFirstName()).append(" ").append(children.get(children.size()-1).getLastName());

        } else{
            childrenStr = new StringBuilder("нет");
        }
        return childrenStr.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId()==getId();
    }
}
