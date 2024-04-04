package family_tree.person;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Human implements Serializable {
    private long id;
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    //private List<Human> allChildren = new ArrayList<>();
    private Human mother, father;
    private Human partner;
    private Map<Human, ArrayList<Human>> kids = new HashMap<>();
    private int countOfChildren;


    public Human(String name, LocalDate dob, Gender gender) {
        this(name, dob, gender, null, null, null);
    }

    public Human(String name, LocalDate dob, Gender gender, LocalDate dod,
                 Human father, Human mother) {
        id = -1;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.dod = dod;
        this.father = father;
        this.mother = mother;
        //kids.put(null, new ArrayList<>());
    }

    public Human(String name, LocalDate dob, Gender gender, Human father, Human mother) {
        this(name, dob, gender, null, father, mother);
    }

    public void addChildFromUnknownPartner(Human child) {
        if (kids.isEmpty()) {
            kids = new HashMap<>();
        } else if (!kids.containsKey(null)) {
            kids.put(null, new ArrayList<>());
        }
        kids.get(null).add(child);
        countOfChildren++;
    }

    public void addChildFromThisPartner(Human partner, Human child) {
        ArrayList<Human> temp = getKidsFromPartner(partner);
        if (temp != null) {
            if (!temp.contains(child)) {
                getKidsFromPartner(partner).add(child);
                countOfChildren++;
            } else {
                System.out.println("This child already recorded in this union");
            }
        } else {
            kids.put(partner, new ArrayList<Human>());
            kids.get(partner).add(child);
            countOfChildren++;
        }
    }

    public ArrayList<Human> getKidsFromPartner(Human partner) {
        for (Map.Entry<Human, ArrayList<Human>> entry : kids.entrySet()) {
            if (partner.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        System.out.println("This partner and their kids is not found.");
        return null;
    }


    public Human findChildByName(String name) {
        if (kids.isEmpty()) {
            System.out.println("This man don't have children");
            return null;
        }
        for (ArrayList<Human> item : kids.values()) {
            for (Human children : item) {
                if (children.getName().equalsIgnoreCase(name)) {
                    return children;
                }
            }
        }
        System.out.println("Child with this name: " + name + " is not found");
        return null;
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

    public void setDeadDate(LocalDate dod) {
        if ((dod.isAfter(this.dob)) || (dod.isBefore(this.dob.plusYears(140)))) {
            this.dod = dod;
        } else {
            System.out.println("Date of dead incorrect!"); //некорктна
        }
    }

    public Map<Human, ArrayList<Human>> getListOfChildren() {
        return kids;
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
        kids.put(partner, new ArrayList<Human>());

    }

    public List<Human> getListOfPartner() {
        if (!kids.isEmpty()) {
            List<Human> partners = new ArrayList<Human>(kids.keySet().size());
            partners.addAll(kids.keySet());
            return partners;
        }
        System.out.println("This man: " + name + " don't have and had partners");
        return null;
    }

    public int getAge() {
        if (this.dod == null) {
            return getPeriod(dob, LocalDate.now());
        } else {
            return getPeriod(dob, dod);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deadDate) {
        Period diff = Period.between(birthDate, deadDate);
        return diff.getYears();
    }

    public Human getPartner() {
        return partner;
    }

    public Gender getGender() {
        return gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(" , name: ");
        sb.append(name  + "\n");
        sb.append("gender: ");
        sb.append(getGender() + "\n");
        sb.append("age: ");
        sb.append(getAge() + "\n");
        sb.append("partner: ");
        sb.append(getPartner() == null ? "no info\n" : getPartner().getName() + "\n");
        sb.append("mother: ");
        sb.append(getMother() == null ? "no info\n" : getMother().getName() + "\n");
        sb.append("father: ");
        sb.append(getFather() == null ? "no info\n" : getFather().getName() + "\n");
        sb.append("number of kids: ");
        sb.append(countOfChildren);
        sb.append(" ");
        //TODO need to add information: is the person alive?
        return sb.toString();

    }


}
