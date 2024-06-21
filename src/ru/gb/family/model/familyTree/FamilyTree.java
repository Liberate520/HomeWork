package ru.gb.family.model.familyTree;




import ru.gb.family.model.familyTree.ItemFamilyTrees.ItemFamilyTree;
import ru.gb.family.model.familyTree.ItemFamilyTrees.comparators.ItemFamilyTreeComparatorByAge;
import ru.gb.family.model.familyTree.ItemFamilyTrees.comparators.ItemFamilyTreeComparatorByBirthday;
import ru.gb.family.model.familyTree.ItemFamilyTrees.comparators.ItemFamilyTreeComparatorByChildren;
import ru.gb.family.model.familyTree.ItemFamilyTrees.comparators.ItemFamilyTreeComparatorByName;
import ru.gb.family.model.familyTree.ItemFamilyTrees.enums.DegreeOfKinship;
import ru.gb.family.model.familyTree.ItemFamilyTrees.enums.Gender;
import ru.gb.family.model.familyTree.ItemFamilyTrees.enums.SortBy;
import ru.gb.family.model.familyTree.ItemFamilyTrees.humans.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class FamilyTree <T extends ItemFamilyTree<T>> implements Serializable, Iterable<ItemFamilyTree<T>> {

    private List<ItemFamilyTree<T>> familyTree;


    public FamilyTree() {
        familyTree = new ArrayList<>();

        }

    public void creatItemFamilyTreeInTree(long itemFamilyTreeId, String name, LocalDate birthday,Gender gender) {
        familyTree.add(new ItemFamilyTree<>(itemFamilyTreeId,name,birthday,gender));
    }

    public void creatItemFamilyTreeInTree(long itemFamilyTreeId, String name, LocalDate birthday,LocalDate dateOfDeath,Gender gender) {
        familyTree.add(new ItemFamilyTree<>(itemFamilyTreeId,name,birthday,dateOfDeath,gender));
    }

    public void addItemFamilyTreeInTree(ItemFamilyTree<T> newItemFamilyTree) {
        if (newItemFamilyTree == null) {
            return;
        }
        if (!(familyTree.contains(newItemFamilyTree))) {
            this.familyTree.add(newItemFamilyTree);

        }
    }

    public void sort(SortBy select){
        switch (select){
            case Age -> this.familyTree.sort(new ItemFamilyTreeComparatorByAge());
            case Birthday -> this.familyTree.sort(new ItemFamilyTreeComparatorByBirthday());
            case Name -> this.familyTree.sort(new ItemFamilyTreeComparatorByName());
            case Children -> this.familyTree.sort(new ItemFamilyTreeComparatorByChildren());
        }
    }

    public ItemFamilyTree<T> searchByItemFamilyTree(ItemFamilyTree<T> searchItemFamilyTree){
        ItemFamilyTree result = null;
        for (ItemFamilyTree<T> fd : familyTree ) {
            if (fd.equals(searchItemFamilyTree)) {
                result = fd;
            }
        }
        return result;
    }

    public List<ItemFamilyTree<T>> searchByName (String name){
        List<ItemFamilyTree<T>> result = new ArrayList<>();
        for (ItemFamilyTree<T> fd : familyTree ){
            if (fd.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(fd);
            }
        }
        return result;
    }
    public List<ItemFamilyTree<T>> searchByGender (Gender gender){
        List<ItemFamilyTree<T>> result = new ArrayList<>();
        for (ItemFamilyTree<T> fd : familyTree ){
            if (fd.getGender().equals(gender)){
                result.add(fd);
            }
        }
        return result;
    }
    public List<ItemFamilyTree<T>> searchByDegreeOfKinship (DegreeOfKinship degreeOfKinship){
        List<ItemFamilyTree<T>> result = new ArrayList<>();
        for (ItemFamilyTree<T> fd : familyTree ){
            switch (degreeOfKinship) {
                case Mother:
                    if (fd.getMother() != null){
                        result.add(fd);
                    }
                    break;
                case Father:
                    if (fd.getFather() != null){
                        result.add(fd);
                    }
                    break;
                case Children:
                    if (!(fd.getChildren().isEmpty())){
                        result.add(fd);
                    }
                    break;
            }
        }
        return result;
    }

    public StringBuilder findChildrenItemFamilyTree (ItemFamilyTree<T> searchItemFamilyTree){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----У человека [").append(searchItemFamilyTree.getName()).append("]  из семейного дерева-------------");
        stringBuilder.append("\n");
        if (searchItemFamilyTree.getChildren() != null){
            stringBuilder.append("Есть дети:\n");
            // список детей
            for (ItemFamilyTree<T> itemFamilyTree : searchItemFamilyTree.getChildren()){
                stringBuilder.append(itemFamilyTree.getName()+"("+itemFamilyTree.getAge()+" лет.))");
                stringBuilder.append("\t\n");
            }
        }else{
            stringBuilder.append("\nНет детей! ");
        }
        stringBuilder.append("----------------------------------------------");
        return stringBuilder;
    }



    @Override
    public Iterator<ItemFamilyTree<T>> iterator() {
        return new ItemFamilyTreeIterator(familyTree);
    }
    public StringBuilder printResult(List<ItemFamilyTree<T>> result){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        stringBuilder.append("Результаты поиска:");
        for (ItemFamilyTree<T> itemFamilyTree : result){
            stringBuilder.append("\n id=" + itemFamilyTree.getId() + '\t' +
                    "name=" +itemFamilyTree.getName() +" ("+itemFamilyTree.getAge()+" лет.)"+
                    "\t birthday(" + itemFamilyTree.getBirthday() +
                    ")\t dateOfDeath(" + itemFamilyTree.getDateOfDeath() +
                    ")\t gender=" + itemFamilyTree.getGender());

            stringBuilder.append("\t");
        }
    return stringBuilder;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cемейное Древо:\n");
        for (ItemFamilyTree<T> itemFamilyTree : familyTree){
            stringBuilder.append(itemFamilyTree);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    public Integer counting() {
        Integer cont = 0;
        for (ItemFamilyTree item:familyTree) {
            cont++;
        };
        return cont;
    }
}
