package FamilyTree.model.familyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends ElementFamilyTree<E>> implements Serializable, Iterable<E> {

    private long itemId = 1;
    private final List<E> itemList;
    private String name;

    public List<E> getHumanList() {
        return itemList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> itemList){
        this.itemList = itemList;
    }

    public void add(E item){
        if(item == null){
            return;
        }
        if(!itemList.contains(item)){
            itemList.add(item);
            item.setId(itemId++);

            addParents(item);
            addChild(item);
        }
    }

    private void addParents(E item){
        if(item.getParents() != null) {
            for (E parent : item.getParents()) {
                parent.addChild(item);
            }
        }
    }


    private void addChild(E item){
        if(item.getChildren() != null) {
            for (E child : item.getChildren()) {
                child.addParents(item);
            }
        }
    }

    public List<E> searchByName(String name){
        List<E> answer = new ArrayList<>();
        for (E item : itemList){
            if(item.getName().equals(name)){
                answer.add(item);
            }
        }
        return answer;
    }

    public void setWadding(long itemId1, long itemId2){
        if(checkId(itemId1) && checkId(itemId2)){
            E item1 = searchById(itemId1);
            E item2 = searchById(itemId2);
            if(item1.getSpouse() == null && item2.getSpouse() == null){
                item1.setSpouse(item2);
                item2.setSpouse(item1);
            }
        }
    }

    private boolean checkId(long id){
        return id < itemId && id > 0;
    }

    public E searchById(long id){
        for (E item : itemList){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public void sortByName(){
        Collections.sort(itemList);
    }

    public void sortByAge(){
        itemList.sort(new ItemComparatorByAge<>());
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В древе ").append(getName()).append(" ").append(getHumanList().size()).append(" объектов.");
        try {
            for (E item : itemList){
                sb.append("\n" + "[id ").append(item.getId()).append(", имя: ").append(item.getName()).append(", пол: ").append(item.getGender()).append(", возраст: ").append(item.getAge()).append(", супруг(а): ").append(item.getSpouseInfo()).append(", мать: ").append(item.getMotherInfo()).append(", отец: ").append(item.getFatherInfo()).append(", дети: ").append(item.getChildrenInfo()).append("]");
            }
        } catch (Exception ignored){

        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public Iterator<E> iterator() {
        return new ItemIterator<>(itemList);
    }
}