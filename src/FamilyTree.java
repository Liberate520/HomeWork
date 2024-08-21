import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E>{
        private long hunansId;
        private List<E> humans;

        public FamilyTree() {
            humans = new ArrayList<>();
        }

        public int size(){
            return humans.size();
        }
        public void addHuman(E human){
            humans.add(human);
            human.setId(hunansId++);
            addToParents(human);
            addToChildren(human);
        }
        private void addToChildren(E human){
            for(E child: human.getChildren()){
                child.addParent(human);
            }
        }
        private void addToParents(E human) {
            for (E parent : human.getParents()) {
                parent.addChild(human);
            }
        }
        public List<E> getByName(String name){
            List<E> list = new ArrayList<>();
            for (E human : humans) {
                if(human.getName().equals(name)){
                    list.add(human);
                }
            }
            return list;
        }
        public E getById(long id){
            for(E human: humans){
                if(human.getId() == id){
                    return human;
                }
            }
            return null;
        }

        @Override
        public String toString(){ return getInfo();}
        public String getInfo() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Семейное древо:\n");
            for (E human : humans) {
                stringBuilder.append(human);
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }
    public  Iterator<E> iterator(){
            return new FamilyIterator(humans);
    }
    public void sortByName(){
            humans.sort(new HumanComparatorByName<>());
    }
    public void sortByDate(){
        humans.sort(new HumanComparatorByBirthDate<>());
    }
    }
