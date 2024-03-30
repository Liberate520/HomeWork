package family_tree.person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Human {
    protected String name;
    protected LocalDate dob, dod;
    protected Gender gender;
    protected List<Human> AllChildren = new ArrayList<>();
    protected Human mother, father;
    protected Human partner;
    protected Map<Human, ArrayList<Human>> resultOfTheUnion = new HashMap<>();

    public Human(String name, LocalDate dob, Gender gender) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public void addChildFromUnknownPartner(Human child) {
        resultOfTheUnion = new HashMap<Human, ArrayList<Human>>();
        if (AllChildren != null) {
            AllChildren.add(child);
        } else {
            AllChildren = new ArrayList<>();
            AllChildren.add(child);
        }
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

    public String getName() {
        return name;
    }

    public void setDod(LocalDate dod) {
        if ((dod.isAfter(this.dob)) || (dod.isBefore(this.dob.plusYears(120)))) {
            this.dod = dod;
        } else {
            System.out.println("Date of dead incorrect!"); //некорктна
        }
    }

    public Human findChildByName(String name) {
        if (this.AllChildren == null) {
            System.out.println("This person doesn't have kids");
            return null;
        } else {
            for (Human item : AllChildren) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return item;
                }
            }
        }
        System.out.println("Child with this name: " + name + " is not found");

        return null;
    }

    @Override
    public String toString() {
        return name + "\n" +
                ", dob: " + dob +
                ", dod: " + dod +
                ", gender: " + gender +
                ", Mother: " + mother +
                ", Father: " + father +
                ", number of kids: " + AllChildren.size();
    }

    public List<Human> getListOfChildren() {
        return this.AllChildren;
    }

    public LocalDate getDateOfBirth() {
        return this.dob;
    }

    /**
     * Not finished
     *
     * @param partner
     */
    public void setPartner(Human partner) {
        this.partner = partner;
        resultOfTheUnion.put(partner, new ArrayList<Human>());

    }

    public void addChildFromThisPartner(Human partner, Human child) {
        for (Map.Entry<Human, ArrayList<Human>> entry : resultOfTheUnion.entrySet()) {
            if (partner.equals(entry.getKey())) {
                if (!entry.getValue().contains(child)) {
                    entry.getValue().add(child);
                    AllChildren.add(child); // ? maybe duplicate
                } else {
                    System.out.println("This child already recorded in this union");
                }
            }
        }
        resultOfTheUnion.put(partner, new ArrayList<Human>());
        resultOfTheUnion.get(partner).add(child);
        AllChildren.add(child); // ? maybe duplicate
    }

    /**
     * Not finished
     * @param partner
     * @return
     */
    public ArrayList<Human> getKidsFromPartner(Human partner) {
        for (Map.Entry<Human, ArrayList<Human>> entry : resultOfTheUnion.entrySet()) {
            if (partner.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        System.out.println("This partner and their kids is not found.");
        return null;
    }
}
