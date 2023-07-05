package family_tree;

import java.io.Serializable;

/*
 * 
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;
import family_tree.Human;
import family_tree.Gender;

class FamilyTree implements Serializable {
    private List< Human> ListHumans;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> ListHuman) {
        this.ListHumans = ListHuman;
    }

    


    public void add (Human human){
        if (!ListHumans.contains(human)){
            ListHumans.add(human);
            addParents(human);
            addChildren(human);
            addToSpouse(human);

        }

    }

   
    // public void printFamilyTree() {
    //     printFamilyTree(ListHumans);
    // }

    private void addParents (Human human){
        for (Human parent : human.getParents()) {
            parent.addChild(human);
           
        }

    }

    private void addChildren(Human human){
        for (Human child : human.getChildren()) {
            child.addParent(human);
            
        }



    }

    private void addToSpouse(Human human){
        if (human.getSpouse()!= null){
            human.addSpouse(human.getSpouse());


        }
        
            
    }


    public String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("В дереве " + ListHumans.size() + " людей\n");
        for (Human human : ListHumans) {
            info.append(human.getInfo()+"\n");
            
        }
        return info.toString();
    }

    public void  getByName(String name){
        List <Human> findlist = new ArrayList<>();
        for (Human human : ListHumans) {
            if(human.getName().equals(name)){
                findlist.add(human);
                
            }   
        }

        for (Human human : findlist) {
            System.out.println(human);
            
        }
    
        
    }
    
    public List<Human> getListHumans() {
        return this.ListHumans;
    }



    // private void printFamilyTree(Human person, int level) {
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < level; i++) {
    //         sb.append("  ");
    //     }
    //     sb.append("- ");
    //     sb.append(person.getName());
    //     System.out.println(sb.toString());

    //     List<Human> children = person.getChildren();
    //     for (Human child : children) {
    //         printFamilyTree(child, level + 1);
    //     }
    // }

}