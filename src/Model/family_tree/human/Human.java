package Model.family_tree.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Item<Human>, Comparable<Human> {
    private String name;
    private Gender sex;
    private LocalDate brthDate;
    private LocalDate dthDate;
    private int id;
    private Сommunications сommunications;
    private Information information;


    public Human(String name, Gender sex, LocalDate brthDate, LocalDate dthDate, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.sex = sex;
        this.brthDate = brthDate;
        this.dthDate = dthDate;


    }

    public Human(String name, Gender sex, LocalDate brthDate) {
        this(name, sex, brthDate, null, null, null);

    }

    public Human(String name, Gender sex, LocalDate brthDate, Human father, Human mother) {
        this(name, sex, brthDate, null, father, mother);
    }


    public boolean addChild(Human chaild) {
        return сommunications.addChild(chaild);
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
        сommunications.setFather(father);
    }

    public void setMother(Human mother) {

        сommunications.setMother(mother);
    }

    public boolean addParent(Human parent) {

        return сommunications.addParent(parent);
    }


    public Human getFather() {

        return сommunications.getFather();
    }

    public Human getMother() {

        return сommunications.getMother();
    }

    public List<Human> getParents() {

        return сommunications.getParents();

    }

    public void setSpouse(Human spouse) {

        сommunications.setSpouse(spouse);
    }

    public Human getSpouse() {

        return сommunications.getSpouse();
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

        return сommunications.getChildren();
    }

    public void setSex(Gender sex) {

        this.sex = sex;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String getSpousInfo() {
        return information.getSpousInfo();
    }

    public void setBrthDate(LocalDate brthDate) {

        this.brthDate = brthDate;
    }

    public void setDthDate(LocalDate dthDate) {

        this.dthDate = dthDate;
    }

    @Override
    public String toString() {

        return information.getInfo();
    }


    public String getFatherInfo() {

        return information.getFatherInfo();
    }

    public String getMotherInfo() {

        return information.getMotherInfo();
    }

    public String getChildrenInfo() {

        return information.getChildrenInfo();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;

        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    @Override
    public int compareTo(Human o) {

        return this.name.compareTo(o.name);
    }


}

