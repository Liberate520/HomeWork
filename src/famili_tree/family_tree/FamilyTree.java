package family_tree;


import java.io.Serializable;


import Human.Human;

import java.util.*;

import Comporator.HumanComporatorByAge;
import Comporator.HumanComporatorByName;



public class FamilyTree implements Iterable <Human>, Serializable{
    
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
                System.out.println(el);
                
                
            }
        }
    
        return "konec dereva!";
    }
    
    public String getInfo(){
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


    public void sortByName(){
        tree.sort(new HumanComporatorByName() ); 
     }
     
     public void sortByAge(){
         tree.sort(new HumanComporatorByAge() );
     }
     
     
     
     @Override
     public Iterator <Human> iterator(){
         return new HumanIterator();
     }
        
        
    class HumanIterator implements Iterator<Human>{
    private int curIndex;

        @Override
        public boolean hasNext(){
            return tree.size()>curIndex;
        }
        
        @Override
        public Human next(){
            return tree.get(curIndex++);
        }
        
    }
        
}
