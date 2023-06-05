package tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import comparers.ComparatorFamilyByBirthDay;
import comparers.ComparatorFamilyByChildrenAmount;
import comparers.ComparatorFamilyByName;
import filework.CapableOfPreserving;
import filework.CapableOfRestore;

/**
 * Family tree
 */
public class FamilyTree implements Serializable, Iterable<Human>{
    private List<Human> family;

    public FamilyTree() {
        family = new ArrayList<>();
    }

    /** added new member */
    public void addNewMember(Human human) {
        if(!contains(human)){
            family.add(human);
            if(human.getFather() != null){
                human.getFather().addChild(human);
            }
            if(human.getMother() != null){
                human.getMother().addChild(human);
            }
        }
    }

    /** checked contains member in family list */
    private Boolean contains(Human search) {
        for (Human human : family) {
            if (human.equals(search)) {
                return true;
            }
        }
        return false;
    }

    /** representation */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Human human : family) {
            builder.append(human);
            builder.append("\n");
        }
        return builder.toString();
    }

    /** сохранение */
    public void save(String path, CapableOfPreserving preserve){
        preserve.save(path, this);
    }

    /** чтение */
    public FamilyTree read(String path, CapableOfRestore restore){
        return (FamilyTree)restore.read(path);
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator();       
    }

    /** сортировка по имени*/
    public void sortByName() {
        Collections.sort(family, new ComparatorFamilyByName());
    }

    /** сортировка дню рождения*/
     public void sortByBirthday() {
        Collections.sort(family, new ComparatorFamilyByBirthDay());
    }

    /** сортировка по количеству детей*/
     public void sortByChildrenAmount() {
        Collections.sort(family, new ComparatorFamilyByChildrenAmount());
    }


    class FamilyTreeIterator implements Iterator<Human>{
        private int index = 0;
            
        @Override
        public boolean hasNext(){
            return index < family.size() && family.get(index) != null;
        }
        
        @Override
        public Human next() {
            return family.get(index++);
        }
    }
}


