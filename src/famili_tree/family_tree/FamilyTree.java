package family_tree;

import Comporator.HumanComporatorByName;
import Comporator.HumanComporatorByAge;
import Human.FamilyTreeItem;

import java.io.Serializable;
import java.util.*;
import java.time.*;

public class FamilyTree<T extends FamilyTreeItem> implements Iterable <T>, Serializable{

    private List <T> tree;

    public FamilyTree(T t){
        this.tree=new ArrayList<>();
        this.tree.add(t);
    }

    public FamilyTree(){
        this.tree=new ArrayList<>();

    }

    public void addHuman(T t){
        if (!(tree.contains(t))){
            tree.add(t);
        }
    }

    public boolean isEmpty(){
        return this.tree.isEmpty();
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        if (tree.isEmpty()){
            return "V dereve net ludey";

        }else{
            for (T el:tree){
                sb.append(el +"\n");


            }
        }

        return sb.toString();
    }

    public String getInfo(){
        StringBuilder sB= new StringBuilder();

        if (tree.isEmpty()){
            sB.append("V dereve net ludey"+"\n");
        }else{
            int i=1;
            for (T el:tree){
                sB.append("*********************************************************"+"\n");
                sB.append("("+Integer.toString(i++)+")");
                sB.append(el+"\n");
                sB.append("ID: "+Integer.toString(el.getId())+"\n");
                if (!(el.getSuprug()==null)){
                    sB.append("-----------------------------------------------------------"+"\n");
                    sB.append(" zhenat na "+ "\n");
                    sB.append(el.getSuprug() +"\n");
                }else{
                    sB.append("-----------------------------------------------------------"+"\n");
                    sB.append(" Holost."+ "\n");
                }
                if (!(el.getChildren().isEmpty())){
                    sB.append("-----------------------------------------------------------"+"\n");
                    sB.append(" dety: "+"\n");
                    sB.append(el.getChildren() +"\n");
                }else{
                    sB.append("-----------------------------------------------------------"+"\n");
                    sB.append(" Net detey."+ "\n");
                }
            }
        }

        return sB.toString();
    }

    public T get(int i){
        return tree.get(i);
    }


    public T getHuman (String name, String familiya, String pol, String birthDate){
        int count=0;
        T res=null;
        for (T el :  tree){
            if (((el.getName()).equals(name)) &&((el.getFamilia()).equals(familiya))&&(el.getPol().equals(pol)) &&(el.getBirtdayDate().equals(birthDate)) ){
                res=el;
                count++;
            }
        }

        if (count==0){
            return res=null;
        }

        return res;

    }

    public T getHumanById (int id){
        int count=0;
        T res=null;
        for (T el :  tree){
            if ((el.getId()==id) ){
                res=el;
                count++;
            }
        }

        if (count==0){

            return res;
        }else{
            return res;
        }

    }

    public String findByName (String name){
        int count=0;
        String res="";
        for (T el : tree){
            if ((el.getName()).equals(name)){
                res=el.toString();
                count++;
            }
        }

        if (count==0){
            res="Chelovek s dannim imenem ne nayden";
        }

        return res;

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


    public boolean contains(T t){
        return this.tree.contains(t);
    }

    class HumanIterator implements Iterator<T>{
        private int curIndex;

        @Override
        public boolean hasNext(){
            return tree.size()>curIndex;
        }

        @Override
        public T next(){
            return tree.get(curIndex++);
        }

    }


}
