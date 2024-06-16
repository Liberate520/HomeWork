package ru.gb.family.service;

import ru.gb.family.familyTree.FamilyTree;
import ru.gb.family.familyTree.ItemFamilyTrees.ItemFamilyTree;
import ru.gb.family.familyTree.ItemFamilyTrees.enums.DegreeOfKinship;
import ru.gb.family.familyTree.ItemFamilyTrees.enums.Gender;
import ru.gb.family.familyTree.ItemFamilyTrees.genTest.GeneratItemFamilyTree;
import ru.gb.family.jobfiles.FileHandler;
import ru.gb.family.jobfiles.Writable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Iterator;



public class Service<E extends FamilyTree, T extends ItemFamilyTree<T>> implements Serializable {
    private long idItemFamilyTree;
    //private familyTree = new FamilyTree();
    //private List<FamilyTree<T>> familyTree;
    private FamilyTree familyTree = new FamilyTree();
    public Service() {
       familyTree = new FamilyTree<T>();
    }

    public FamilyTree getFamilyTree(){

        return this.familyTree;
    }

    public void creatItemFamilyTree(String name, LocalDate birthday,LocalDate dateOfDeath, Gender gender){
        if (dateOfDeath != null){
            familyTree.creatItemFamilyTreeInTree(idItemFamilyTree++,name,birthday,dateOfDeath,gender);
        }else {
            familyTree.creatItemFamilyTreeInTree(idItemFamilyTree++, name, birthday, gender);
        }
    }
    public ItemFamilyTree<T> getItemFamilyTree(String name, LocalDate birthday){
        Iterator<T> iterator = familyTree.iterator();
        while (iterator.hasNext()){
            ItemFamilyTree<T> itnext = iterator.next();
            if(itnext.getName().equalsIgnoreCase(name)
                    && itnext.getBirthday().equals(birthday)){
                return itnext;
            }
        }
        return null;
    }

    public void editItemFamilyTree(ItemFamilyTree<T> currentitemFamilyTree,ItemFamilyTree<T> additemFamilyTree,DegreeOfKinship degreeOfKinship){
        if(currentitemFamilyTree !=null){
            currentitemFamilyTree.editItemFamilyTree(additemFamilyTree,degreeOfKinship);
        }
    }

    public static void save(FamilyTree familyTree, String filePath) {
        Writable writable = new FileHandler();
        writable.save(familyTree, filePath);
    }

    public static FamilyTree read(String filePath) {
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read(filePath);

    }

    public static boolean chekFile(String filePath) {
        Writable writable = new FileHandler();
        return writable.chekFile(filePath);
    }
    public static FamilyTree newTestFamilyTree(){
        GeneratItemFamilyTree generatFamalyTree = new GeneratItemFamilyTree();

        return  generatFamalyTree.gen();
    }

    public void start(String path){

        if (Service.chekFile(path)) {
            this.familyTree =  Service.read(path);
        } else {
           this.familyTree =  Service.newTestFamilyTree();
        }
    }

}