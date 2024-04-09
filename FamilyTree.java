package homeWork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    private List<Human> list;
    
    public FamilyTree() {
        this.list = new ArrayList<>();
    }

    public void addTree(Human name) {
        list.add(name);
    }

    public String printTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево:\n");
        for (Human human: list){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
