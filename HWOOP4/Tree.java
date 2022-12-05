import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Tree<T> implements Iterable<T>, Doable<T>{
    private T Human1;
    private List<Relationship<T>> humansRelationships = new ArrayList<>();
    private List<T> humans = new ArrayList<>();
    public List<Relationship<T>> getHumans(){
        return humansRelationships;
    }

    public T getHuman() {
        return Human1;
    }

    @Override
    public void addRelation(T human1, T human2, Relations relation1, Relations relation2){
        this.humansRelationships.add(new Relationship<>(human1, human2, relation1));
        this.humansRelationships.add(new Relationship<>(human2, human1, relation2));
    }

    public void addPerson(T human1) {
        this.humans.add(human1);
    }

    @Override
    public String toString() {
        String res = new String();
        for (Relationship<T> elem : humansRelationships) {
            res += elem +"\n";
        }
        return res;
    }

    @Override
    public String print(){
        String res = new String();
        for (T human : humans) {
            res += human +"\n";
        }
        return res;
    }

    @Override
    public void search(String name) {
        for (T human : humans) {
            if (((Human) human).getFirstName().equals(name)) {
                System.out.println("The result of the search is:\n" + human + "\n");
            }
        }
    }

    public void sortByFirstName(){
        humans.sort(new HumanComparatorByFirstName<T>());
    }

    public void sortByAge(){
        humans.sort(new HumanComparatorByAge<T>());
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator<T>(humans);
    }
}
