package ru.gb.family.model.service;

import ru.gb.family.model.familyTree.FamilyTree;
import ru.gb.family.model.familyTree.ItemFamilyTrees.ItemFamilyTree;
import ru.gb.family.model.familyTree.ItemFamilyTrees.enums.DegreeOfKinship;
import ru.gb.family.model.familyTree.ItemFamilyTrees.enums.Gender;
import ru.gb.family.model.familyTree.genTest.GeneratItemFamilyTree;
import ru.gb.family.model.familyTree.jobfiles.FileHandler;
import ru.gb.family.model.familyTree.jobfiles.Writable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public class Service<E extends FamilyTree, T extends ItemFamilyTree<T>> implements Serializable {
    private FamilyTree familyTree;
    private long idItemFamilyTree;
    private String pathDir = "src/ru/gb/family/model/data/";
    private String nameTree = "new";


    public String getNameTree() {
        return this.nameTree;
    }

    public void setNameTree(String nameTree) {
        this.nameTree = nameTree;
        this.save();
    }




    public Service() {
      familyTree = new FamilyTree<T>();
    }

    public List<String> getListFilesData(){
        Writable writable = new FileHandler();
        writable.getListSaveTree(pathDir);

        return writable.getListSaveTree(pathDir);
    }
    public FamilyTree getFamilyTree(){

        return familyTree;
    }

    public void creatItemFamilyTree(String name, LocalDate birthday,LocalDate dateOfDeath, Gender gender){
        if (dateOfDeath != null){
            familyTree.creatItemFamilyTreeInTree(idItemFamilyTree++,name,birthday,dateOfDeath,gender);
        }else {
            familyTree.creatItemFamilyTreeInTree(idItemFamilyTree++, name, birthday, gender);
        }
    }
    public ItemFamilyTree<T> getItemFamilyTree(String name, LocalDate birthday){
        return familyTree.getItemFamilyTree(name,birthday);

    }

    public void editItemFamilyTree(ItemFamilyTree<T> itemFamilyTreeEdit,ItemFamilyTree<T> additemFamilyTree,DegreeOfKinship degreeOfKinship){
        familyTree.editItemFamilyTree(itemFamilyTreeEdit,additemFamilyTree,degreeOfKinship);

     }

    public void save() {
        //System.out.println(pathDir+nameTree);
        Writable writable = new FileHandler();
        writable.save(this.getFamilyTree(),pathDir+nameTree);
    }

    public void setFamilyTree(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void read(String nameOpenTree) {
        System.out.println("Открываем Базу:"+pathDir + nameOpenTree);
        System.out.println("Проверка файла:"+ chekFile(pathDir + nameOpenTree));
        Writable writable = new FileHandler();
        this.setFamilyTree((FamilyTree) writable.read(pathDir + nameOpenTree));

    }
    public void del(String nameDelTree) {
        Writable writable = new FileHandler();
        writable.deleteFile(pathDir + nameDelTree);
    }

    public boolean chekFile(String filePath) {
        Writable writable = new FileHandler();
        return writable.chekFile(filePath);
    }

    public void newTestFamilyTree(){
        GeneratItemFamilyTree generatFamalyTree = new GeneratItemFamilyTree();
        this.setFamilyTree(generatFamalyTree.gen());
        this.setNameTree("newTestFamilyTree");
        System.out.println(idItemFamilyTree);
        idItemFamilyTree = familyTree.counting();
        System.out.println(idItemFamilyTree);
        System.out.println(this.getFamilyTree());
        this.save();

    }



}