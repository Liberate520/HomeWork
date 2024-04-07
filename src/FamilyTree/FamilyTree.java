package FamilyTree;
import java.util.LinkedList;
import java.io.Serializable;

import Human.Human;
import Writer.FileHandler;
// import Writable.Writable;

public class FamilyTree implements Serializable{
    public void write(){

    }
    public void load(){

    }
    private int idLeaf;
//    public static final String FILEPATH = "src\\familyTree.txt";
    private LinkedList<Human> familyTree;
    public FamilyTree(){
        this.idLeaf = 0;
        this.familyTree = new LinkedList<Human>();
    }
    public int count(){
        return this.familyTree.size();
    }
    // public void addID(){
    //   idLeaf++;
    // }
    public int getID(){
        this.idLeaf++;
        return this.idLeaf;
    }
    public void addHuman(Human human){
        if (human.getId() == -1){
            human.setId(getID());
            this.familyTree.add(human);
        }
    }
    public LinkedList<Human> getFamilyTree(){
        return familyTree;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : familyTree){
            stringBuilder.append(human.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public Human getHuman(int id){
        if (id<1 && id > this.count()){
            return null;
        } else{
            return this.familyTree.get(id-1);
        }
    }
    public boolean setWedding(Human human1, Human human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        else return false;
    }
//    public boolean saveTree(){
//        FileHandler handler = new FileHandler();
//        handler.save(this, this.FILEPATH);
//        return true;
//    }
//    public boolean readTree(){
//        FileHandler handler = new FileHandler();
//        this =handler.read(FILEPATH);
//    }
}