package famili_tree.family_tree;


import java.io.Serializable;


import famili_tree.Human.Human;

import java.util.*;

public class FamilyTree implements Serializable{
    
    private List <Human> tree;
    
    public FamilyTree(Human human){
        this.tree=new ArrayList<>();
        this.tree.add(human);
    }
    public FamilyTree(){
        this(null);
        
    }
    
    public void addHuman(Human  human){
        if (!tree.contains(human)){
            tree.add(human);
        }
    }
    
    public String toString(){
        if (tree.isEmpty()){
            return "V dereve net ludey";
            
        }else{
            for (Human el:tree){
                System.out.println( el+"\n"+ 
                " zhenat na "+ "\n"+
                el.suprug +"\n"+
                " dety: "+"\n"+
                el.children);
            }
        }
    
        return "konec dereva!";
    }
        
}
