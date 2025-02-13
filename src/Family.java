
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


public class Family implements Serializable {

    Human wife, husband;
    String family;
    AbstractMap<Human,List<Human>> childParents = new HashMap<>();
    ArrayList<Human> children = new ArrayList<>();

    public Family(String family){
        this.family = family;
    }

    public void setWife(Human wife) {
        this.wife = wife;
        wife.lastName = family;
    }

    public void setHusband(Human husband) {
        this.husband = husband;
        husband.lastName = family;
    }

    public void newChild(Human father, Human mother, Human child){
        List<Human> parents = new ArrayList<>();
        parents.addAll(Arrays.asList(father,mother));
        childParents.put(child, parents);
        children.add(child);
        child.lastName = family;
        parents.clear();
    }

    public void showFamily(){
        List<Human> children = new ArrayList<>();
        System.out.println(String.format("Муж: %s;", husband));
        System.out.println(String.format("Жена: %s; \nДети: ", wife));
        getChildren(children);
        for (int i = 0; i < children.size()-1; i++) {
            System.out.println(String.format("%s, ", children.get(i)));
        }
        System.out.println(String.format(" %s.", children.getLast()));
    }

    

    private void getChildren(List<Human> children) {
        for (Entry<Human,List<Human>> elem : childParents.entrySet()) {
            children.add(elem.getKey());
        }
    }

    @Override
    public String toString() {
        return String.format("Муж: %s; Жена: %s; \n" +
                            "Дети: %s", husband, wife, children);
    }
    

       public Family read(String path) throws IOException, ClassNotFoundException {
           try (ObjectInputStream intput = new ObjectInputStream(new FileInputStream(path))) {
            Family smt = (Family) intput.readObject();
               return smt;
        }
   }

    public void write (Family elem, String file) throws IOException, ClassNotFoundException{
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(elem);
        }
    }
}
/*
* 
* 
*/