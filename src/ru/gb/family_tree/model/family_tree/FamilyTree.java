package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.info_collector.InfoCollector;
import ru.gb.family_tree.model.human.enums.Gender;
import ru.gb.family_tree.model.human.comparators.HumanComparatorByAge;
import ru.gb.family_tree.model.human.comparators.HumanComparatorByBirthday;
import ru.gb.family_tree.model.human.comparators.HumanComparatorById;
import ru.gb.family_tree.model.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class FamilyTree<T extends FamilyTreeItem<T>> implements Serializable, Iterable<T> {
    private List<T> familyTree;

    public FamilyTree(List<T> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void addHuman(T human) {
        familyTree.add(human);
    }

    public void setParentsByChildren() {
        for (T human : familyTree) {
            List<T> children = human.getChildren();
            if (children != null) {
                for (T child : children) {
                    if (human.getGender() == Gender.Female) {
                        child.setMother(human);
                    } else {
                        child.setFather(human);
                    }
                }
            }
        }
    }

    public boolean editObject(int id, InfoCollector infoCollector, List<CollectorItems> editedItems){
        boolean success = false;
        T obj = this.getHumanById(id);
        for(CollectorItems editedItem : editedItems){
            try{
                obj.editObject(infoCollector, editedItem);
                success = true;
            } catch (Exception e){
                e.printStackTrace();
                success = false;
            }
        }
        return success;
    }

    private void setChildren(T parent, T child){
        if (parent.getChildren() != null){
            List<T> children = parent.getChildren();
            if(!parent.getChildren().contains(child)){
                children.add(child);
                parent.setChildrenList(children);
            }
        } else {
            List<T> children = new ArrayList<>();
            children.add(child);
            parent.setChildrenList(children);
        }
    }

    public void setChildrenByParents(){
        for (T human : familyTree){
            if (human.getMother() != null){
                T mother = (T) human.getMother();
                setChildren(mother, human);
            }
            if (human.getFather() != null){
                T father = (T) human.getFather();
                setChildren(father, human);
            }
        }
    }

    public boolean isEmpty(){
        return familyTree.isEmpty();
    }

    public Map<String, Integer> getInfoForEdit(){
        Map<String, Integer> fullNameId = new HashMap<>();
        for(T obj : familyTree){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj.getName());
            stringBuilder.append(" ");
            stringBuilder.append(obj.getPatronymic());
            stringBuilder.append(" ");
            stringBuilder.append(obj.getSurname());
            stringBuilder.append(", ");
            stringBuilder.append(obj.getDateOfBirthday().getYear());
            stringBuilder.append(" года рождения.");
            stringBuilder.append(" ID: ");
            stringBuilder.append(obj.getId());
            fullNameId.put(stringBuilder.toString(), obj.getId());
        }
        return fullNameId;
    }

    public Map<String, Integer> getInfoForChooseChildren(LocalDate dateOfBirthday, LocalDate dateOfDeath){
        Map<String, Integer> fullNameId = getInfoForEdit();
        Iterator<Map.Entry<String, Integer>> iterator = fullNameId.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            T obj = this.getHumanById(entry.getValue());
            LocalDate endDate;
            if(obj.getDateOfDeath() == null){
                endDate = LocalDate.now();
            } else {
                endDate = obj.getDateOfDeath();
            }
            if(!obj.getDateOfBirthday().isAfter(dateOfBirthday) && obj.getDateOfBirthday().isBefore(endDate)){
                iterator.remove();
            }
        }
        return fullNameId;
    }

    public Map<String, Integer> getInfoForChooseParents(Gender gender){
        Map<String, Integer> fullNameId = getInfoForEdit();
        Iterator<Map.Entry<String, Integer>> iterator = fullNameId.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            T obj = this.getHumanById(entry.getValue());
            if(!obj.getGender().equals(gender)){
            iterator.remove();
            }
        }
        return fullNameId;
    }



    public T getHumanById(int id){
        for(T human : familyTree){
            if(human.getId() == id){
                return human;
            }
        }
        return null;
    }

    // разбиваем строку запроса по пробелу, Создаем HashMap с количеством совпадений по Фамилии Имени и Отчеству,
    // В результат поиска выводятся объекты с максимальным количеством совпадений

    public List<T> searchHuman(String request) {
        List<String> params = new ArrayList<>(Arrays.asList(request.split(" ")));
        List<T> result = new ArrayList<>();
        Map<T, Integer> matches = new HashMap<>();
        int maxMatchCount = 0;
        for (T human : familyTree) {
            int matchCount = 0;
            for (String param : params) {
                if (human.getName().contains(param)) {
                    matchCount++;
                }
                if (human.getSurname().contains(param)) {
                    matchCount++;
                }
                if (human.getPatronymic().contains(param)) {
                    matchCount++;
                }
            }
            if (matchCount > 0) {
                matches.put(human, matchCount);
            }
        }
        maxMatchCount = Collections.max(matches.values());
        for (Map.Entry<T, Integer> entry : matches.entrySet()) {
            if (entry.getValue() == maxMatchCount) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (T human : familyTree) {
            result.append(human);
        }
        return result.toString();
    }

    public void sortByName(){
        familyTree.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        familyTree.sort(new HumanComparatorByAge<>());
    }

    public void sortByBirthday(){
        familyTree.sort(new HumanComparatorByBirthday<>());
    }

    public void sortById(){
        familyTree.sort(new HumanComparatorById<>());
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(familyTree);
    }
}
