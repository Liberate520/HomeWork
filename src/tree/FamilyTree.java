package tree;

import human.Gender;
import human.Human;
import human.HumanIterator;
import human.comparator.*;
import service.SortType;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human>{
    private long humanID;
    public List<Human> humanList;
    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void add(Human human){
        if(!humanList.contains(human)){
            humanList.add(human);
            human.setID(humanID++);
            addToCildren(human);
            addToMother(human);
            addToFather(human);
        }
    }
    // заимствовал, но по-своему
    private void addToCildren(Human human){ // добавляем человека родителем к его детям если его там нет.
        for (Human child: human.getChildren()){
            if(human.getGender() == Gender.Female){
                child.setMother(human);
            } else {
                child.setFather(human);
            }
        }
    }
    private void addToMother(Human human){
        if(human.getMother()!=null) {
            human.getMother().addChildToList(human);
        }
    }
    private void addToFather(Human human){
        if(human.getFather()!=null) {
            human.getFather().addChildToList(human);
        }
    }
    public String getAllInfo(SortType sortBy, boolean reverse) {

        if(sortBy == SortType.byId || sortBy == SortType.defaultSort){
            sortById();
        }
        if(sortBy == SortType.byName){
            sortByName();
        }
        if(sortBy == SortType.byLastName){
            sortByLastName();
        }
        if(sortBy == SortType.byDateOfBirth){
            sortByDateOfBirth();
        }
        if(sortBy == SortType.byDateOfDeath){
            sortByDateOfDeath();
        }
        if(sortBy == SortType.byAge){
            sortByAge();
        }
        if(sortBy == SortType.byChildrenNumber){
            sortByCildrenNumber();
        }

        StringBuilder str = new StringBuilder();
        for(Human human: humanList){
            str.append(human.getInfo() + "\n");
        }
        str.append(humanID);
        return str.toString();
    }
    public String getAllInfo(SortType sortBy) {
        return getAllInfo(sortBy, false);
    }
    public String getAllInfo() {
        return getAllInfo(SortType.defaultSort, false);
    }

    public String getChildInfo(Human human) {

        return human.getChildren().toString();
    }

    public void saveAsHtml(){
        int i = 0;
        StringBuilder outHTML = new StringBuilder();
        outHTML.append("<link rel=\"stylesheet\" href=\"_styles.css\">\n<ul class=\"tree-padding tree-vertical-lines tree-horizontal-lines tree-summaries tree-markers tree-buttons\">\n");
        outHTML.append(humanList.get(i).getHTML());

        outHTML.append("</ul>");
        try {
            FileWriter writer = new FileWriter("output.html");
            writer.write(outHTML.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл.");
            e.printStackTrace();
        }

    }
    public void sortById(){
        humanList.sort(new HumanComparatorById());
    }
    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }
    public void sortByLastName(){
        humanList.sort(new HumanComparatorByLastName());
    }
    public void sortByDateOfBirth(){
        humanList.sort(new HumanComparatorByDateOfBirth());
    }
    public void sortByDateOfDeath(){
        humanList.sort(new HumanComparatorByDateOfDeath());
    }
    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }
    public void sortByCildrenNumber(){
        humanList.sort(new HumanComparatorByCildrenNumber());
    }



    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
}
