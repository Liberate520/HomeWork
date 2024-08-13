package family_tree.family_tree_Angelina;

import family_tree.human.Human;

import java.io.Serializable;
import java.util.List;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Human> familyMembers;

    public FamilyTree(List<Human> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public String displayFamilyTree() {
        StringBuilder result = new StringBuilder();
        for (Human person : familyMembers) {
            result.append(person.toString()).append("\n"); // Используем метод toString
        }
        return result.toString();
    }
}






































































































/*public class FamilyTree {
    private long humansId = 0;
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());}

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;}

    public boolean add(Human human){
        if (human == null) {
            return false;
        }
        if(!humanList.contains(human)) {
            human.setId(hummanId++);
            humanList.add(human);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<Human> getSiblings(long id){
        Human human = getById(id);
        if (human == null){
            return null;
        }
        List<Human> res = new ArrayList<>();
        for(Human parent: human.getParents()){
            for(Human child: parent.getChildren()){
                if(!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for(Human human: humanList){
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
           Human human1 = getById(humanId1);
           Human human2 = getById(humanId2);
           return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(Human human1, Human human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }else {
            return false;
        }
    }

    public boolean setDivorce(long humanId1, long humanId2){
        if(checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setDivorce(human1,human2);
        }
        return false;
    }

    public boolean setDivorce(Human human1, Human human2){
        if (human1.getSpouse() != null && human1.getSpouse().equals(human2) &&
            human2.getSpouse() != null && human2.getSpouse().equals(human1)){
            human1.getSpouse(null);
            human2.getSpouse(null);
            return true;
        }else{
            return false;
        }
    }

    public boolean remove(long humansId){
        if(checkId(humansId)){
            Human human = getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id){
        return id < humansId && id >= 0;
    }

    public Human getById(long id){
        for(Human human: humanList){
            if(human.getId() == id){
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(" In family tree ");
        sb.append(humanList.size());
        sb.append(" objects: \n");
        for (Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
*/
