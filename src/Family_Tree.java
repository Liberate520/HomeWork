import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Family_Tree implements Serializable {
    private long humansId;
    private List<Human> humanList;

    public Family_Tree() {this (new ArrayList<>()); }

    public Family_Tree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human){
        if(human == null){
            return false;
        }
        if(!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for(Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for(Human child: human.getChildren()){
            child.addChild(human);
        }
    }

    public List<Human> getSiblings(long id){
        Human human = getById(id);
        if(human == null){
            return null;
        }
        List<Human> res = new ArrayList<>();
        for(Human parent: human.getParents()){
            for (Human child: human.getChildren()){
                if(!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList){
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humansId1, long humansId2) {
        if (checkId(humansId1) && checkId(humansId2)) {
            Human human1 = getById(humansId1);
            Human human2 = getById(humansId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.getSpouse(human2);
                human2.getSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean setDevorse(long humansId1, long humansId2) {
        if (checkId(humansId1) && checkId(humansId2)) {
            Human human1 = getById(humansId1);
            Human human2 = getById(humansId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.getSpouse(human2);
                human2.getSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remove (long humansId){
        if (checkId(humansId)){
            Human human = getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id){
        return id < humansId && id >= 0;
    }

    public Human getById(Long id){
        for (Human human: humanList){
            if(human.getId() == id){
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {return getInfo();}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(" в дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}

//Поля: Список людей (лист), список членов семьи.
//Методы: Добавление, поиск, вывод всего списка и т.д.
