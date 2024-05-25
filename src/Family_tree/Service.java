package Family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import Family_tree.Humans.Gender;
import Family_tree.Humans.Human;
import Family_tree.Tree.Family_tree;

public class Service implements Serializable{

    private Family_tree tree;
    private List<Family_tree> trees;
    private long counter;
    private List<Human> humans;
    private long humancounter;
    private Human currentHuman;

    public Service() {
        trees = new ArrayList<>();
        humans = new ArrayList<>();
        this.counter = 0;
        this.humancounter = 0;
    }

    public Family_tree createTree(String family) {
        Family_tree newTree = new Family_tree(family, counter);
        counter++;
        trees.add(newTree);
        return newTree;
    }

    public boolean add(Family_tree family_tree) {
        try {
            family_tree.setid(counter);
            counter++;
            trees.add(family_tree);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public long nameValue(String string) {
        char[] chars = string.toCharArray();
        long vals = 0;
        for (char c : chars) {
            vals = (long) c + vals;
        }
        return vals;
    }

    public Family_tree getTree(long index){
        if (this.trees.size() == 0){
            return null;
        }
        this.tree = this.trees.get((int) index);
        return this.tree;
    }

    public void createHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother, long id){
        Human human = new Human(name, gender, birthDate, deathDate, father, mother);
        human.setInnerID(humancounter);
        humancounter++;
        humans.add(human);        
    }
    public Human getHuman(long index){
        if (this.humans.size() == 0){
            return null;
        }
        this.currentHuman = this.humans.get((int) index);
        return this.currentHuman;
    }
    public String getHumansInfo(long index){
        Family_tree currentTree = this.getTree(index);
        StringBuilder sb = new StringBuilder();
        sb.append("Список людей в семье " + currentTree.getFamily() + " \n");
        for (Human human : currentTree) {
            sb.append(human + "\n");
        }
        return sb.toString();
    }

    

}
