package family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate birthday;
    private LocalDate dethday;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, LocalDate birthday, LocalDate dethday, Gender gender, Human father, Human mother) {
        this.name = name;
        this.birthday = birthday;
        this.dethday = dethday;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }


    public void addChild(Human child) {
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getDethday() {
        return dethday;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildrenOf() {
        return children;
    }

    public void setDethday(LocalDate dod) {
        this.dethday = dethday;
    }



    @Override
    public String toString() {
        return name + "|birthday - " + birthday + "|dethday -" + dethday+ "|gender - " + gender + "|father - " + father + "| mother - " + mother + "| children - " + children;
    }


}