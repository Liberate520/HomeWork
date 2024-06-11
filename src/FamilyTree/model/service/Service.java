package FamilyTree.model.service;

import FamilyTree.model.builder.HumanBuilder;
import FamilyTree.model.builder.ItemBuilder;
import FamilyTree.model.element.ElementFamilyTree;
import FamilyTree.model.element.Human;
import FamilyTree.model.familyTree.FamilyTree;
import FamilyTree.model.familyTree.Writable;
import FamilyTree.model.element.Gender;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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

    public void addElement(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, E father, E mother, List<E> children, E spouse){
        familyTree.add((E) itemBuilder.createItem(name, gender, birthDate, deathDate, father, mother, children, spouse));
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

    public List<E> searchByName(String name){
        return familyTree.searchByName(name);
    }

    public E searchById(Long id){
        return familyTree.searchById(id);
    }

    public void addChild(long idChild, long idParent){
        familyTree.addChild(searchById(idChild), searchById(idParent));
    }

    public void addParent(long idChild, long idParent){
        familyTree.addParent(searchById(idChild), searchById(idParent));
    }
}
