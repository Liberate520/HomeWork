package family_tree;


import java.io.Serializable;
import family_tree.*;

import Human.*;

import java.util.*;

import Comporator.HumanComporatorByAge;
import Comporator.HumanComporatorByName;



public class FamilyTree <T extends FamilyTreeItem> implements Iterable <T>, Serializable{
    
    private List <T> tree;
    
    public FamilyTree(T t){
        this.tree=new ArrayList<>();
        this.tree.add(t);
    }
    public FamilyTree(){
        this(null);
        
    }
    
    public void addHuman(T t){
        if (!tree.contains(t)){
            tree.add(t);
        }
    }
    
    public String toString(){
        if (tree.isEmpty()){
            return "V dereve net ludey";
            
        }else{
            for (T el:tree){
                System.out.println(el);
                
                
            }
        }
    
        return "konec dereva!";
    }
    
    public String getInfo(){
        if (tree.isEmpty()){
            return "V dereve net ludey";
            
        }else{
            for (T el:tree){
                System.out.println( el+"\n"+ 
                " zhenat na "+ "\n"+
                el.getSuprug() +"\n"+
                " dety: "+"\n"+
                el.getChildren());
                
                
            }
        }
    
        return "konec dereva!";
    }

    public String findByName (String name){
        int count=0;
        for (T el : tree){
            if ((el.getName()).equals(name)){
                System.out.println(el);
                count++;
            }
        }

        if (count==0){
            System.out.println("Chelovek s dannim imenem ne nayden");
        }

        return "Poisk zavershen";

    }



    public void sortByName(){
        tree.sort(new HumanComporatorByName() ); 
     }
     
     public void sortByAge(){
         tree.sort(new HumanComporatorByAge() );
     }
     
     
     
     @Override
     public Iterator <T> iterator(){
         return new HumanIterator();
     }
        
        
    // class HumanIterator implements Iterator<T>{
    // private int curIndex;

    //     @Override
    //     public boolean hasNext(){
    //         return tree.size()>curIndex;
    //     }
        
    //     @Override
    //     public T next(){
    //         return tree.get(curIndex++);
    //     }
        
    // }

        
}