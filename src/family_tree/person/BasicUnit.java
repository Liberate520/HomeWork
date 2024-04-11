package family_tree.person;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BasicUnit implements Serializable {
    private long id;
    private int generation;
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    //private List<Human> allChildren = new ArrayList<>();
    private BasicUnit mother, father;
    private BasicUnit partner;
    private Map<BasicUnit, ArrayList<BasicUnit>> kids = new HashMap<>();
    private int countOfChildren;


    public BasicUnit(String name, LocalDate dob, Gender gender) {
        this(name, dob, null, gender, null, null);
    }

    public BasicUnit(String name, LocalDate dob, LocalDate dod, Gender gender) {
        this(name, dob, dod, gender, null, null);
    }

    public BasicUnit(String name, LocalDate dob, LocalDate dod, Gender gender,
                     BasicUnit father, BasicUnit mother) {
        id = -1;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.dod = dod;
        this.father = father;
        this.mother = mother;
    }

    public BasicUnit(String name, LocalDate dob, Gender gender, BasicUnit father, BasicUnit mother) {
        this(name, dob, null, gender, father, mother);
    }

    public void addChildFromUnknownPartner(BasicUnit child) {
        if (kids.isEmpty()) {
            kids = new HashMap<>();
        } else if (!kids.containsKey(null)) {
            kids.put(null, new ArrayList<>());
        }
        kids.get(null).add(child);
        child.setParent(this);
        countOfChildren++;
    }

    public boolean addChildFromThisPartner(BasicUnit partner, BasicUnit child) {
        ArrayList<BasicUnit> temp = getKidsFromPartner(partner);
        if (!temp.isEmpty()) {
            if (!temp.contains(child)) {
                getKidsFromPartner(partner).add(child);
                partner.getKidsFromPartner(this).add(child);
                partner.countOfChildren++;
                child.setParent(partner);
                child.setParent(this);
                countOfChildren++;
                return true;
            } else {
                System.out.println("This child already recorded in this union");
                return false;
            }
        } else {
            kids.getOrDefault(partner, new ArrayList<BasicUnit>()).add(child);
            partner.kids.getOrDefault(this, new ArrayList<BasicUnit>()).add(child);
            child.setParent(partner);
            child.setParent(this);
            partner.countOfChildren++;
            countOfChildren++;
            return true;
        }
    }

    public ArrayList<BasicUnit> getKidsFromPartner(BasicUnit partner) {
        for (BasicUnit entry : kids.keySet()) {
            if (entry.equals(partner)) {
                return kids.get(entry);
            }
        }
        System.out.println("This partner and their kids is not found.");
        return null;
    }


    public BasicUnit findChildByName(String name) {
        if (kids.isEmpty()) {
            System.out.println("This man don't have children");
            return null;
        }
        for (ArrayList<BasicUnit> item : kids.values()) {
            for (BasicUnit children : item) {
                if (children.getName().equalsIgnoreCase(name)) {
                    return children;
                }
            }
        }
        System.out.println("Child with this name: " + name + " is not found");
        return null;
    }
    public ArrayList<BasicUnit> getListOfChildren() {
        ArrayList<BasicUnit> temp = new ArrayList<>();
        for (ArrayList<BasicUnit> item : kids.values()) {
            temp.addAll(item);
        }
        return temp;
    }

    public BasicUnit getMother() {
        return mother;
    }


    public void setParent(BasicUnit parent) {
        if (parent.getGender().equals(Gender.Male)) {
            this.father = parent;
        } else if (parent.getGender().equals(Gender.Female)) {
            this.mother = parent;
        }
    }

    public BasicUnit getFather() {
        return father;
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
    public void setDateOfBirth(LocalDate dob) {
        this.dob = dob;
    }


    public LocalDate getDateOfBirth() {
        return this.dob;
    }

    /**
     * Not finished
     *
     * @param partner
     */
    public void setPartner(BasicUnit partner) {
        kids.put(partner, new ArrayList<BasicUnit>());
        partner.kids.put(this, new ArrayList<BasicUnit>());
        this.partner = partner;
        partner.partner = this;
    }

    public List<BasicUnit> getListOfPartner() {
        if (!kids.isEmpty()) {
            List<BasicUnit> partners = new ArrayList<BasicUnit>(kids.keySet().size());
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

    public BasicUnit getPartner() {
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
        sb.append(name + "\n");
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
        //TODO need to add information: is the person alive?
        return sb.toString();
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }
}
