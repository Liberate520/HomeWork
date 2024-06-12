package seminar2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long humansId;
    private List<Human> humanList;
    private int index;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }

    public boolean add(Human human){
        if(human == null){
            return false;
        }

        if(!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for(Human child: human.getChildren()){
            child.addParent(human);
        }
    }



    public List<Human> getByNameSurname(String name, String surname){
        List<Human> result = new ArrayList<>();
        for(Human human: humanList){
            if(human.getName().equals(name) && human.getSurname().equals(surname)){
                result.add(human);
            }
        }
        return result;
    }

    public String getByOneFamily(String surname){
        StringBuilder result = new StringBuilder();
        result.append("Семья (муж/жена/дети) " + surname + "(a/ой) состоит из: \n");

        for(Human human: humanList){
            if(human.getSurname().equals(surname)){
                result.append(human.getBriefInfo() + "\n");

            }
        }
        return result.toString();
    }

    @Override
    public String toString() {
        switch (index){
            case 1:
                return getInfoSortByName();
            case 2:
                return getInfoSortBySurname();
            case 3:
                return getInfoSortByAge();
            case 4:
                return getInfoSortByChildren();
            default:
                return getInfo();
        }
        //return getInfo();
    }

    public String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("В дереве ");
        info.append(humanList.size());
        info.append(" объекта(ов): \n");
        for(Human human: humanList){
            info.append(human);
            info.append("\n");
        }

        return info.toString();

    }

    // ----------- методы сортировки ----------------
    public void sortByName(){
        index = 1;
        humanList.sort(new HumanComparatorByName());

    }

    public void sortBySurname(){
        index = 2;
        humanList.sort(new HumanComparatorBySurname());

    }

    public void sortByAge(){
        index = 3;
        humanList.sort(new HumanComparatorByAge());
    }


    public void sortByChildren(){
        index = 4;
        humanList.sort(new HumanComparatorByChildren());
    }

    // ---------- методы вывода информации при сортировке --------

    public String getInfoSortByName(){
        StringBuilder infoSort = new StringBuilder();
        infoSort.append("Отсортировано по имени: \n");
        for(Human human: humanList){
            infoSort.append(human.getName());
            infoSort.append(" " + human.getSurname());
            infoSort.append(" " + human.getDateOfBirth());
            infoSort.append("\n");
        }

        return infoSort.toString();

    }


    public String getInfoSortBySurname(){
        StringBuilder infoSort = new StringBuilder();
        infoSort.append("Отсортировано по фамилии: \n");
        for(Human human: humanList){
            infoSort.append(human.getSurname());
            infoSort.append(" " + human.getName());
            infoSort.append(" " + human.getDateOfBirth());
            infoSort.append("\n");
        }

        return infoSort.toString();

    }

    public String getInfoSortByAge(){
        StringBuilder infoSort = new StringBuilder();
        infoSort.append("Отсортировано по возрасту: \n");
        for(Human human: humanList){
            infoSort.append(human.getAge() + " год(а)/лет");
            infoSort.append(" " + human.getSurname());
            infoSort.append(" " + human.getName());
            infoSort.append("\n");
        }

        return infoSort.toString();

    }


    public String getInfoSortByChildren(){
        StringBuilder infoSort = new StringBuilder();
        infoSort.append("Отсортировано по количеству детей в семье: \n");
        for(Human human: humanList){
            infoSort.append(human.getSurname() + " " + human.getName() + ", "+ human.getChildrenInfo());

            infoSort.append("\n");
        }

        return infoSort.toString();
    }


    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
}
