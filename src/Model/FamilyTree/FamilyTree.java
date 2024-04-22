package Model.FamilyTree;
import java.util.Iterator;
import java.util.LinkedList;
import java.io.Serializable;

public class FamilyTree<E extends LeafFamilyTree> implements Iterable<E>, Serializable{

//    private long idLeaf;
    private final LinkedList<E> familyTree;
    public FamilyTree(){
//        this.idLeaf = 0;
        this.familyTree = new LinkedList<E>();
    }
    public int count(){
        return this.familyTree.size();
    }
//    public long createID(){
//        this.idLeaf++;
//        return this.idLeaf;
//    }
    public void addHuman(E human){
            this.familyTree.add(human);
    }
    public LinkedList<E> getFamilyTree(){
        return familyTree;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (E human : familyTree){
            stringBuilder.append(human.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public E getHuman(long id){
        if (id<1 && id > this.count()){
            return null;
        } else{
            return this.familyTree.get((int) (id-1));
        }
    }
    public Iterator<E> iterator(){return new FamilyTreeIterator(familyTree);}

    public void sortByAge(){familyTree.sort(new LeafComparatorByAge<E>());}

    public void sortByName(){familyTree.sort(new LeafComparatorByName<E>());}

    public void sortByNameRevers(){familyTree.sort(new LeafComparatorByName<E>().reversed());}

    public void sortByAgeRevers(){familyTree.sort(new LeafComparatorByAge<E>().reversed());}
}