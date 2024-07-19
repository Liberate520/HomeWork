package Human;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Human {

    int ID;
    String name;
    int yearBirth;
    int yearDeath;
    String gender;
    Human father, mother = null;
    ArrayList<Human> children = new ArrayList<>();


    public Human(int ID, String name, int yearBirth, String gender){
        this.ID = ID;
        this.name = name;
        this.yearBirth = yearBirth;
        this.gender = gender;

    }


    public Human(int ID, String name, int yearBirth, int yearDeath, String gender){
        this.ID = ID;
        this.name = name;
        this.yearBirth = yearBirth;
        this.yearDeath = yearDeath;
        this.gender = gender;

    }

    public int getID() {
        return ID;
    }

    public String setFather(Human father) {
        if (this.father == null) {
            this.father = father;
            return setChildren(father); }

        else { return "Have a father\n";}
    }

    public String setMother(Human mother) {
        if (this.mother == null) { this.mother = mother; return setChildren(mother); }
        else { return "Have a mother\n";}
    }

    public String setChildren(Human parent){
        parent.children.add(this);
        return "add baby";
    }


    public ArrayList<Human> getParents(){
        ArrayList parents = new ArrayList<Human>();
        parents.add(this.father);
        parents.add(this.mother);
        return parents;
    }

    public ArrayList getChildren(Human human){
        ArrayList Child = new ArrayList<>();
        for(Human child: children){
            Child.add(child.name);
        }
        return Child;
    }

    @Override
    public String toString() {
        StringBuilder SB = new StringBuilder();
        SB.append("\n\nID: ");
        SB.append(ID);
        SB.append("\nName: ");
        SB.append(name);
        SB.append("\nberthDate: ");
        SB.append(yearBirth);
        SB.append("\ndeathDate: ");
        SB.append(yearDeath);
        SB.append("\ngender: ");
        SB.append(gender);
        SB.append("\nFather: ");
        if (father != null) {SB.append(father.name);}
        SB.append("\nMother: ");
        if (mother != null) {SB.append(mother.name);}
        SB.append("\nchild: ");
        SB.append(getChildren(this));

        return SB.toString();
    }
}

    

