package FamilyTree.model.service;

import FamilyTree.model.builder.ItemBuilder;
import FamilyTree.model.familyTree.ElementFamilyTree;
import FamilyTree.model.familyTree.FamilyTree;
import FamilyTree.model.builder.HumanBuilder;
import FamilyTree.model.familyTree.Writable;
import FamilyTree.model.human.Gender;

import java.io.IOException;
import java.time.LocalDate;

public class Service<E extends ElementFamilyTree<E>> {
    private FamilyTree<E> familyTree = new FamilyTree<>();
    private ItemBuilder<E> itemBuilder;
    private Writable<E> writable;

    public void setItemBuilder(ItemBuilder<E> itemBuilder) {
        this.itemBuilder = itemBuilder;
    }

    public void setWritable(Writable<E> writable){
        this.writable = writable;
    }

    public void addElement(String name, Gender gender, LocalDate birthDate, LocalDate deathDate){
        familyTree.add(itemBuilder.createItem(name, gender, birthDate, deathDate));
    }

    public void setName(String name){
        familyTree = new FamilyTree<>();
        familyTree.setName(name);
    }

    public FamilyTree<E> viewFamilyTree(){
        return familyTree;
    }

    public void setWadding(long item1, long item2){
        familyTree.setWadding(item1, item2);
    }

    public void save() throws IOException {
        writable.save(familyTree, familyTree.getName() + ".out");
    }

    public void load(String name) throws IOException, ClassNotFoundException {
        familyTree = writable.load(name + ".out");
    }

    public void sortedByName(){
        familyTree.sortByName();
    }

    public void sortedByAge(){
        familyTree.sortByAge();
    }

}
