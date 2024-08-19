import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>{
        private long hunansId;
        private List<Human> humans;

        public FamilyTree() {
            humans = new ArrayList<>();
        }

        public int size(){
            return humans.size();
        }
        public void addHuman(Human human){
            humans.add(human);
            human.setId(hunansId++);
            addToParents(human);
            addToChildren(human);
        }
        private void addToChildren(Human human){
            for(Human child: human.getChildren()){
                child.addParent(human);
            }
        }
        private void addToParents(Human human) {
            for (Human parent : human.getParents()) {
                parent.addChild(human);
            }
        }
        public List<Human> getByName(String name){
            List<Human> list = new ArrayList<>();
            for (Human human : humans) {
                if(human.getName().equals(name)){
                    list.add(human);
                }
            }
            return list;
        }
        public Human getById(long id){
            for(Human human: humans){
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
            for (Human human : humans) {
                stringBuilder.append(human);
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }
    public  Iterator<Human> iterator(){
            return new FamilyIterator(humans);
    }
    public void sortByName(){
            humans.sort(new HumanComparatorByName());
    }
    public void sortByDate(){
        humans.sort(new HumanComparatorByBirthDate());
    }
    }
