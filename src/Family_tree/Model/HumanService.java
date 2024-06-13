package Family_tree.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Family_tree.Model.Humans.Gender;
import Family_tree.Model.Humans.Human;
import Family_tree.Model.Tree.Family_tree;

public class HumanService extends Service<Human> {

    private List<Family_tree<Human>> list;
    private Family_tree<Human> currentTree;

    public HumanService(){
        list = new ArrayList<>(); 
        currentTree = null;       
    }

    @Override
    public List<Family_tree<Human>> getTreeList() {
        return this.list;
    }

    @Override
    public void setCurrentTree(Family_tree<Human> tree) {
        this.currentTree = tree;
    }
    public Family_tree<Human> getCurrentTree(){
        return this.currentTree;
    }

    @Override
    public boolean newChild(Human child, Human father, Human mother) {
        try{
            child.setFather(father);
            if (father != null){                
                father.addChild(child);
            }        
            child.setMother(mother);
            if (mother != null){
                mother.addChild(child);
            }   
            currentTree.add(child);     
        return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public boolean setMarriage(Human one, Human two){
        boolean boo = one.setSpouse(two);
        boo = two.setSpouse(one);
        return boo;
    }

    @Override
    public void setCurrentTree(int index) {
        this.currentTree = list.get(index);
    }
    public Human newHuman(String nane, Gender gender, LocalDate birthDate){
        Human human = new Human(nane, gender, birthDate);
        return human;
    }
    
}
