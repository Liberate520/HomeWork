package ru.gb.family.presenter;

import ru.gb.family.model.familyTree.FamilyTree;
import ru.gb.family.model.familyTree.ItemFamilyTrees.ItemFamilyTree;
import ru.gb.family.model.familyTree.ItemFamilyTrees.enums.DegreeOfKinship;
import ru.gb.family.model.familyTree.ItemFamilyTrees.enums.Gender;
import ru.gb.family.model.service.Service;
import ru.gb.family.view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;
    public Presenter(View view){
        this.view = view;
        this.service = new Service<>();
    }

    public List<String> getListDataTree() {
        return this.service.getListFilesData();
    }
    public void newTree(String name){

        this.service.setNameTree(name);
        this.service.save();
    }

    public void openTree(String nameTree) {
        this.service.setNameTree(nameTree);
        this.service.read(nameTree);

    }
    public void delTree(String nameTree) {
        this.service.setNameTree(nameTree);
        this.service.del(nameTree);

    }

    public FamilyTree getTree() {

        return this.service.getFamilyTree();
    }



    public boolean save() {
        this.service.save();
    return true;
    }


    public void addItemTree(String name, LocalDate birthday,LocalDate dateOfdaet, Gender gender) {
        this.service.creatItemFamilyTree(name,birthday,dateOfdaet,gender);
        view.printAnswer(this.service.getItemFamilyTree(name,birthday).toString());

    }

    public void printTree() {
        this.service.getFamilyTree();
        view.printAnswer(this.service.getFamilyTree().toString());
    }


    public void itemEdit(ItemFamilyTree item1, ItemFamilyTree item2, DegreeOfKinship degreeOfKinship ) {
        this.service.getFamilyTree().editItemFamilyTree(item1,item2,degreeOfKinship);

    }
    public List<ItemFamilyTree> searchItemByName(String name) {
        return this.service.getFamilyTree().searchByName(name);
    }
}
