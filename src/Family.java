package src;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class Family implements Serializable, Iterable<Human> {

    Human wife, husband;
    String family;
    ArrayList<Human> children = new ArrayList<>();
    ArrayList<Human> fam = new ArrayList<>();

    public Family(String family){
        this.family = family;
    }

    public void setWife(Human wife) {
        this.wife = wife;
        wife.lastName = family;
        this.fam.add(wife);
    }

    public void setHusband(Human husband) {
        this.husband = husband;
        husband.lastName = family;
        this.fam.add(husband);
    }

    public void newChild(Human father, Human mother, Human child){
        child.father = father;
        child.mother = mother;
        children.add(child);
        child.lastName = family;
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



    @Override
    public Iterator<Human> iterator() {
        // TODO Auto-generated method stub
        return fam.iterator();
    }
}
/*
* 
* 
*/