package Family_tree.Tree;
import java.util.List;

import Family_tree.Humans.Human;

import java.util.ArrayList;

public class Family_tree {
    private List<Human> list;

    public Family_tree(){
        list = new ArrayList<>();        
    }

    public void add(Human human){
        list.add(human);
    }

    public Human search(String name){
        for (Human element : list) {
            if (element.getName().equalsIgnoreCase(name)){
                return element;
            }
        }
        return null;
    }


    
}
