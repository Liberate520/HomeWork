package model.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class FamilyTree<E extends TreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> objectsList;

    public FamilyTree(){

        this(new ArrayList<>());
    }
    public FamilyTree(List <E> personList){

        this.objectsList =personList;
    }

    //Добавление человека в генеалогическое древо
    public boolean add(E person){
        if(person==null || objectsList.contains(person)){
            System.out.println("Пустой объект или такой объект имеется");
            return false;
        }
        else{
            objectsList.add(person);
            return true;
        }
    }


    //Добавление родственных связей
    public void addKinship(String parentName, String childName) {
        E parent = findObject(parentName);
        E child = findObject(childName);

        if (parent != null && child != null) {
            parent.addChild(child);
            child.addParent(parent);
            System.out.println("Родственные связи между "+parent.getFullName()+" и "+ child.getFullName()+" установлены.");
            System.out.println();

        }else {
            System.out.println("Данный объект отсутвует в семейном дереве");
            System.out.println();
        }
    }

    //Метод поиска объекта по имени
    private E findObject (String fullName){
        for (E person : objectsList) {
            String personName = person.getFullName();
            if (personName != null && personName.equals(fullName)) {
                return person;
            }
        }
        return null;
    }



    //Поиск по имени. Могут быть однофамильцы. Возвращается список объектов
    public List<E> getByName(String fullName){
        List<E> res=new ArrayList<>();
        for (E person: objectsList){
            if (person.getFullName().equals(fullName)){
                res.add(person);
            }
        }
        return res;
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb=new StringBuilder();
        sb.append("В генеалогическом древе ");
        sb.append(objectsList.size());
        sb.append(" объектов: \n ");
        for(E person: objectsList){
            sb.append(person);
            sb.append("\n");
        }
        return sb.toString();

    }

    public void sortByName(){

        Collections.sort(objectsList,new ComparatorByName());
    }


    public void sortByDateOfBirth() {

        Collections.sort(objectsList, new ComparatorByBirthDate());
    };



    @Override
    public Iterator<E> iterator() {

        TreeIterator treeIterator = new TreeIterator(objectsList);
        return treeIterator;
    }
}
