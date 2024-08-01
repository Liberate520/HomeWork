package family_tree;

import man.Gender;
import man.Man;
import man.comparator.ManComparatorByAge;
import man.comparator.ManComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Man>{
    private long id;
    private ArrayList <Man> mans;
    public FamilyTree(ArrayList <Man> peoples){
        this.mans = peoples;
    }

    public FamilyTree(){
        mans = new ArrayList<>();
    }

    public boolean addToFamilyTree(Man man) {
        if (man == null){
            System.out.println("Пусто...");
            return false;
        }
        if (!mans.contains(man)) {
            mans.add(man);
            man.setId(id++);
            System.out.println(man.getName() + " добавлен");
            addToParents(man);
            addToChildren(man);
            return true;
        } else {
            System.out.println(man.getName() + " Ошибка! Уже был добавлен");
            return false;
        }
    }
    private void addToParents(Man man){
        if (man.getParents()!= null) {
            for (Man parent : man.getParents()) {
                parent.addChild(man);
            }
        }
    }

    private void addToChildren(Man man) {
        if (man.getChildrens()!= null) {
            for (Man child : man.getChildrens()) {
                if (man.getGender().equals(Gender.Female)) {
                    child.addMother(man);
                } else {
                    child.addFather(man);
                }
            }
        }
    }
    public List<Man> getByName(String name) {
        List<Man> res = new ArrayList<>();
        for (Man man : mans) {
            if (man.getName().equals(name)) {
                res.add(man);
            }
        }
        return res;
    }

    public boolean setWedding(Man man, Man man2){
        if (man.getSpouse() == null && man2.getSpouse() == null){
            man.getMerried(man);
            man2.getMerried(man2);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean setDivorce(Man man, Man man2){
        if (man.getSpouse().equals(man2)){
            man.getMerried(null);
            man2.getMerried(null);
            return true;
        }
        else {
            System.out.println(man + "не состоит в браке с " + man2);
            return false;
        }
    }
    public boolean remove(long currentId){
        if(currentId<id && id>=0){
            Man currentMan = getById(currentId);
            return mans.remove(currentMan);
        }
        return false;
    }

    public Man getById(long id){
        for (Man man : mans) {
            if (man.getId() == id){
                return man;
            }
        }
        return null;
    }

    public void sortByName(){
        mans.sort(new ManComparatorByName());
    }

    public void sortByAge(){
        mans.sort(new ManComparatorByAge());
    }

    @Override
    public Iterator<Man> iterator()
    {
        return new ManIterator(mans);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Дерево состоит из ");
        sb.append(mans.size());
        sb.append(" объектов\n");
        for (Man man : mans) {
            sb.append(man);
            sb.append("\n");
        }
        return sb.toString();

        }
    }
