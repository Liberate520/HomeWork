package model.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.human.Gender;
import model.human.Comparator.HumanComparatorByAge;
import model.human.Comparator.HumanComparatorByName;

public class FamilyTree<E extends TreeNode<E>>  implements Serializable, Iterable<E> {
    private long HumanId;
    private List<E> humans;
    
    public FamilyTree(){humans = new ArrayList<>(); }

    public boolean addHuman(E human) {
        if (human == null) {
            return false;
        }
        if (!humans.contains(human)) {
            humans.add(human);
            human.setId(HumanId++);

            addParents(human);
            addChildren(human);

            return true;
        }
        return false;
    }
    private void addParents(E member) {
        E mother = member.getMother();
        if (mother != null) {
            mother.addChild(member);
        }

        E father = member.getFather();
        if (father != null) {
            father.addChild(member);
        }
    }

    private void addChildren(E member) {
        if (member.getChildren().size() > 0) {
            for (E child : member.getChildren()) {
                if (member.getGender() == Gender.Female) {
                    child.setMother(member);
                } else {
                    child.setFather(member);
                }
            }
        }
    }


    public E findById(long id) {
        for (E human: humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }


    public List<E> findByName(String name) {
        List<E> res = new ArrayList<>();
        for (E human: humans) {
            if (human.getName().equalsIgnoreCase(name)) {
                res.add(human);
            }
        }
        for (E member : res) {
            System.out.println(member);
        }
        return res;
    }


    public boolean checkById(int id) {
        return humans.contains(findById(id));
    }


    public String getFamilyInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Древо состоит из ");
        sb.append(humans.size() + " человек: ");
        sb.append("\n");
        sb.append("-----------\n");
        for (E human : humans) {
            sb.append(human);
            sb.append("\n");
            sb.append("-----------\n");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return getFamilyInfo();
    }



    public void sortByName(){ humans.sort(new HumanComparatorByName<>());}
    public void sortByAge(){ humans.sort(new HumanComparatorByAge<>());}

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humans);
    }

}
