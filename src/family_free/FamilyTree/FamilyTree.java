package family_free.FamilyTree;

import family_free.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    //переменая для генирации индентификаторов
    private long humansId;
    //список людей
    private List<Human> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList){
        //обычный сеттер принимает лист и записывает его
        this.humanList = humanList;
    }

    public boolean addHuman(Human human){
        //если передили пустую ссылку, то эту ссылку мы не добавляем в дерево
        if (human ==null){
            return false;
        }
        if (!(humanList.contains(human))){
            humanList.add(human);
            human.setId((int) humansId++);

            addToParants(human);
        }
        return false;
    }

    private void addToParants(Human human){
        for (Human parant: human.getParants()){
            parant.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addChild(human);
        }
    }

    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList){
            if(human.getName()==name){
                res.add(human);
            }
        }
        return res;
    }

    public Human getById(long id){
        for(Human human:humanList){
            if(human.getId()==id){
                return human;
            }
        }
        return null;
    }

//    //My
//    public List<List<Human>> getAllDescendants(Human human){
//        if (human.getChildren().size()==0) {
//            return null;
//        }
//        else {
//            List<List<Human>> res = new ArrayList<>();
//        }
//        long id = human.getId();
//
//        for (Human i:humanList){
//            if(i.getChildren().size()!=0) {
//                if (i.getId() == id) {
//                    for (Human child : i.getChildren()) {
//                        res.add(getAllDescendants(child));
//                    }
//                }
//            }
//    }
//        return res;
//    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дерево:\n");
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
