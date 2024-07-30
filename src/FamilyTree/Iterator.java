package FamilyTree


import Human.Human;

import java.util.List;

public class Iterator implements Iterator<Human> {
    private List<Human>list;
    private int index;

    public Iterator(List<Human>list){
        this.list = list;
        index = 0;
    }
    public boolean hasNext(){
        return index < list.size();
    }
    public Human next(){
        return list.get(index++);
    }
}
