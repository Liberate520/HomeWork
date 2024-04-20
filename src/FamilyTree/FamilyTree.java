package FamilyTree;
import java.util.Iterator;
import java.util.LinkedList;
import java.io.Serializable;
// import Writable.Writable;

public class FamilyTree<E extends LeafFamilyTree> implements Serializable, Iterable<E>{
    public void write(){

    }
    public void load(){

    }
    private long idLeaf;
    private final LinkedList<E> familyTree;
    public FamilyTree(){
        this.idLeaf = 0;
        this.familyTree = new LinkedList<E>();
    }
    public int count(){
        return this.familyTree.size();
    }
    public long createID(){
        this.idLeaf++;
        return this.idLeaf;
    }
    public void addHuman(E human){
        if (human.getId() == -1){
            human.setId(this.createID());
            this.familyTree.add(human);
        }
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
    public void setWedding(E human1, E human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
        }
    }
    public Iterator<E> iterator(){return new FamilyTreeIterator(familyTree);}

    public void sortByAge(){familyTree.sort(new LeafComparatorByAge());}

    public void sortByName(){familyTree.sort(new LeafComparatorByName());}

    public void sortByNameRevers(){familyTree.sort(new LeafComparatorByName().reversed());}

    public void sortByAgeRevers(){familyTree.sort(new LeafComparatorByAge().reversed());}
}