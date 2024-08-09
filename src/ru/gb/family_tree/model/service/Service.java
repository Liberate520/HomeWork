package ru.gb.family_tree.model.service;

import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.info_collector.InfoCollector;
import ru.gb.family_tree.model.human.builder.HumanBuilder;
import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.enums.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.writer.FileHandler;
import ru.gb.family_tree.model.writer.Writer;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Service {
    private HumanBuilder humanBuilder;
    private FamilyTree<Human> famTree;
    private Writer writer;

    public Service(Writer writer) {
        famTree = new FamilyTree();
        humanBuilder = new HumanBuilder();
        this.writer = writer;
    }

    public void addHuman(String name, String patronymic, String surname,
                         Gender gender, Human father, Human mother,
                         List<Human> children, String profession,
                         String nationality, LocalDate dateOfBirth, LocalDate dateOfDeath,
                         String birthPlace, String notes){
        Human human = humanBuilder.build(name, patronymic, surname,
                gender, father, mother,
                children, profession,
                nationality, dateOfBirth, dateOfDeath,
                birthPlace, notes);
        famTree.addHuman(human);
        setFamilyTies();
    }

    public boolean editHuman(int humanId, InfoCollector infoCollector, List<CollectorItems> editedItems){
        boolean result = famTree.editObject(humanId, infoCollector, editedItems);
        setFamilyTies();
        return result;
    }

    public void addHuman(String name, String patronymic, String surname,
                         Gender gender){
        addHuman(name, patronymic, surname, gender, null, null, null, null, null,
        null, null, null, null);
    }

    private void setFamilyTies(){
        famTree.setParentsByChildren();
        famTree.setChildrenByParents();
    }

    public String getfamilyTreeInfo(){
        if(famTree.isEmpty()){
            return "Не добавлено ни одного человека...";
        }
        return famTree.toString();
    }

    public Human getHumanById(int id){
        return (Human)famTree.getHumanById(id);
    }

    public List<Human> searchHuman(String request){
        return (List<Human>) famTree.searchHuman(request);
    }

    public Map<String, Integer> getInfoForChooseParents(Gender gender){
        return famTree.getInfoForChooseParents(gender);
    }

    public Map<String, Integer> getInfoForChooseChildren(LocalDate dateOfBirthday, LocalDate dateOfDeath){
        return famTree.getInfoForChooseChildren(dateOfBirthday, dateOfDeath);
    }
    public Map<String, Integer> getInfoForEdit(){
        return famTree.getInfoForEdit();
    }

    public void sortByName(){
        famTree.sortByName();
    }

    public void sortByAge(){
        famTree.sortByAge();
    }

    public void sortByBirthday(){
        famTree.sortByBirthday();
    }

    public void sortById(){
        famTree.sortById();
    }

    public boolean saveFamTreeToFile(String fileName){
        boolean success = true;
        try{
            writer.saveObject(famTree, fileName + ".fmt");
        } catch (Exception e){
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    public boolean IsEmpty(){
        return famTree.isEmpty();
    }

    private void setIdAfterLoad(){
        int maxId = 0;
        for(Human human : famTree){
            if(human.getId() > maxId){
                maxId = human.getId();
            }
        }
        humanBuilder.setIdAfterLoad(maxId + 1);
    }

    public boolean loadFamTreeFromFile(String fileName){
        boolean success = true;
        try{
            famTree = (FamilyTree<Human>) writer.readObject(fileName);
            setIdAfterLoad();
        } catch (Exception e){
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    public List<String> showSaveFiles(){
        return writer.showSaves();
    }


}
