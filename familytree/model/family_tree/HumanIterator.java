package familytree.model.family_tree;
import java.util.Iterator;
import java.util.List;
import familytree.model.human.Human;
import familytree.model.family_tree.FamilyTreeItem;

public class HumanIterator<P> implements Iterator<P>{
    private int index;
    private List<P> ListHumans;
    
    public HumanIterator (List<P> ListHumans){
        this.ListHumans = ListHumans;

    }

    @Override
    public boolean hasNext(){

        return index < ListHumans.size();
    }

    @Override
    public P next(){

        return ListHumans.get(index++);
    }
}
