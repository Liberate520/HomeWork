package familyTree.familyTree;

import familyTree.human.People;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<People> family;
    private long familyId;

    public FamilyTree(List<People> family) {
        this.family = family;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(People human) {
        if (human == null) {
            return false;
        }

        if (!family.contains(human)) {
            family.add(human);
            human.setId(familyId++);

            addToParetns(human);
            addToChildren(human);

            return true;

        }
        return false;
    }

    private void addToParetns(People people) {
        for (People parents : people.getParents()) {
            parents.addChildren(people);
        }
    }

    private void addToChildren(People people) {
        for (People child : people.getChildren()) {
            child.addParent(people);
        }
    }

    public List<People> getByName(String name) {
        List<People> res = new ArrayList<>();
        for (People hum : family) {
            if (hum.getName().equals(name)) {
                res.add(hum);
            }
        }
        return res;
    }

    public boolean setWeding(long idHuman1, long idHuman2) {
        if (checkId(idHuman1) && checkId(idHuman2)) {
            People spouse1 = getById(idHuman1);
            People spouse2 = getById(idHuman2);
            return setWeding(spouse1, spouse2);
        }
        return false;
    }

    public boolean setWeding(People spouce1, People spouce2){
        if(spouce1.getSpouse() == null && spouce2.getSpouse() == null){
            spouce1.setSpouse(spouce2);
            spouce2.setSpouse(spouce1);
            return true;
        }
        return false;
    }

    public boolean remove (long idHumanRemove){
        if(checkId(idHumanRemove)){
            family.remove(getById(idHumanRemove));
            return true;
        }
        return false;
    }

    private boolean checkId(long checkedId) {
        return (0 < checkedId && checkedId <= familyId);
    }

    public People getById(long idHuman) {
        for (People hum : family) {
            if (hum.getId() == idHuman) {
                return hum;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return toInfo();
    }

    private String toInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном древе находится ");
        sb.append(family.size());
        sb.append(" человек. \n");
        for(People hum: family){
            sb.append(hum);
            sb.append("\n");
        }
        return sb.toString();
    }
}
