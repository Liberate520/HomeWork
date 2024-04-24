package re.zip.famely_tree.famely_tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import re.zip.famely_tree.humans.Human;
import re.zip.famely_tree.srv.HumanComparatorByFirstName;
import re.zip.famely_tree.srv.HumanIterator;
import re.zip.famely_tree.srv.HumanComparatorByBirthDate;
import re.zip.famely_tree.srv.HumanComparatorByFamelyName;

public class FamelyTree implements Serializable, Iterable<Human>{
    private long humanId;
    private List<Human> humanList;

    public FamelyTree(List<Human> humanList){
        this.humanList = humanList;
    }
    
    public FamelyTree(){
        humanList = new ArrayList<>();
    }

    public boolean addToFamely(Human human){
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setIdNo(++humanId);
            addHumanToCildren(human);
            addHumanToParents(human);
            return true;
        }
        return false;
    }

    private void addHumanToParents(Human human){
        for (Human parent : human.getListParents()) {
           parent.addACild(human); 
        }
    }

    private void addHumanToCildren(Human human){
        for (Human child : human.getChildren() ) {
            child.addAParent(human); 
         }
    }

    public List<Human> getSiblingsList (int humanId){
        Human human = searchHumanById(humanId);
        if (human == null){
            return null;
        }
        List<Human> ListSiblings = new ArrayList<>();
        for (Human parent : human.getListParents()) {
            for (Human child : parent.getChildren()) {
                if (!child.equals(human)){
                    ListSiblings.add(child);
                }
            }
        }
    return ListSiblings;
    }

    public List<Human> searchByNane(String name){
        List<Human> ListByName = new ArrayList<>();
        for (Human human : humanList){
            if (human.getFatherName().equals(name)){
                ListByName.add(human);
            }
        }
    return ListByName;
    }

    public boolean setWeddding (long partner1ID, Long partner2ID, Integer getFamelyName){
        if (checkID(partner1ID) && checkID(partner2ID)){
            Human partner1 = searchHumanById(partner1ID);
            Human partner2 = searchHumanById(partner2ID);
            return setWeddding(partner1, partner2, getFamelyName);
        }
        return false;
    }

    public boolean setWeddding (long partner1ID, Long partner2ID){
        return setWeddding(partner1ID, partner2ID, 0);
    }

//TODO необходимо что-то сделать с перводом мужских фамилий в женские и обратно

    public boolean setWeddding (Human partner1, Human partner2, Integer getFamelyName){
        if (partner1.getSpouse() == null && partner1.getSpouse() == null){
            partner1.setSpouse(partner2);
            partner2.setSpouse(partner1);
            if (getFamelyName == 1){
                partner2.setFamelyName(partner1.getFamelyName() + " (" + partner2.getFamelyName() + ")");
            }
            else{
                if (getFamelyName == 2){
                    partner1.setFamelyName(partner2.getFamelyName() + " (" + partner1.getFamelyName() + ")");
                }
            }
            return true;
        }
        return false;
    }

    public boolean setWeddding (Human partner1, Human partner2, String newFamelyName){
        if (partner1.getSpouse() == null && partner1.getSpouse() == null){
            partner1.setSpouse(partner2);
            partner2.setSpouse(partner1);
            partner2.setFamelyName(newFamelyName + " (" + partner2.getFamelyName() + ")");
            partner1.setFamelyName(newFamelyName + " (" + partner1.getFamelyName() + ")");
            return true;
        }
        return false;
    }

    public boolean setWeddding (Human partner1, Human partner2){
        if (partner1.getSpouse() == null && partner1.getSpouse() == null){
            partner1.setSpouse(partner2);
            partner2.setSpouse(partner1);
            return true;
        }
        return false;
    }

    public boolean setDivorse (long partner1ID, Long partner2ID){
        if (checkID(partner1ID) && checkID(partner2ID)){
            Human partner1 = searchHumanById(partner1ID);
            Human partner2 = searchHumanById(partner2ID);
            return setDivorse(partner1, partner2);
        }
        return false;
    }

    public boolean setDivorse (Human partner1, Human partner2){
        if (partner1.getSpouseInfo() != null && partner1.getSpouseInfo() != null){
            partner1.setSpouse(null);
            partner1.setSpouse(null);
            return true;
        }
        return false;
    }

    public boolean removeFromFamely (long humanID){
        if (checkID(humanID)){
            Human human = searchHumanById(humanID);
            return removeFromFamely(human);
        }
        return false;
    }

    public boolean removeFromFamely(Human human){
        if (humanList.contains(human)){
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkID(long id){
        return id < humanId && id > 0;
    }

    public Human searchHumanById(long id){
        if (checkID(id)){
            for (Human human: humanList){
                if (human.getIdNo() == id) {
                    return human;
                }
            }
        }
    return null;
    }

    // public void addToFamely(Human human){
    //     humanList.add(human);
    // }   

    public void sortByFamelyName() {
        humanList.sort(new HumanComparatorByFamelyName());
    }

    public void sortByFirstName() {
        humanList.sort(new  HumanComparatorByFirstName());
    }

    public void sortByBirthDate() {
        humanList.sort(new  HumanComparatorByBirthDate());
    }

    
    @Override
    public Iterator<Human> iterator() {   
        return new HumanIterator(humanList);
    }

    public String getFamelyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nСуществ семье: ");
        stringBuilder.append(humanList.size());
        stringBuilder.append("\n");
        for (Human human : humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        } 
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getFamelyInfo();
    }
}
