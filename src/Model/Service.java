package Model;

import Model.Builders.CreatureBuilder;
import Model.Builders.FamilyTreeBuilder;
import Model.Builders.SaveBuilder;
import Model.Creature.Creature;
import Model.Creature.Entity;
import Model.Creature.Gender;
import Model.Creature.Info;
import Model.FamilyTree.Save;
import Model.Formating.Exceptions.Date_ERROR;
import Model.Formating.Exceptions.ID_ERROR;
import Model.Formating.MyDate;
import Model.Formating.Writer.Writer;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Service {
    private final Writer writer;
    private Save save;

    public Service(Writer writer){
        this.writer = writer;
    }

    public void createFamilyTree(String familyTreeName, String description){
        this.save = new SaveBuilder()
                .setDescription(description)
                .setFamilyTreeName(familyTreeName)
                .setFamilyTree(new FamilyTreeBuilder().build())
                .build();
    }

    public void deleteCurrentSave() {
        this.save = null;
    }

    public ArrayList<Info> getFamilyTreeInfo(){
        return this.save.getFamilyTree().getInfo();
    }

    public void createCreature(String name, String surname, Gender gender){
        Creature creature = new CreatureBuilder()
                .setName(name)
                .setSurname(surname)
                .setGender(gender)
                .build();

        this.save.getFamilyTree().addEntity(creature);
    }

    public ArrayList<Info> findEntity(String name, String surname) {
        ArrayList<Info> infos = new ArrayList<>();

        for (Entity entity: this.save.getFamilyTree().getFamilyTree()){
            if (entity.getName().equals(name) && entity.getSurname().equals(surname))
                infos.add(entity.getInfo());
        }

        return infos;
    }

    public Info getEntityInfo(int ID) throws ID_ERROR {
        Entity entity = this.save.getFamilyTree().getEntity(ID);

        if (entity == null){
            throw new ID_ERROR();
        }

        return entity.getInfo();
    }

    public void removeEntity(int ID) throws ID_ERROR {
        Entity entity = this.save.getFamilyTree().getEntity(ID);

        if (entity == null)
            throw new ID_ERROR();

        this.save.getFamilyTree().removeEntity(ID);
    }

    public void changeEntityName(int ID, String newName) throws ID_ERROR {
        Entity entity = this.save.getFamilyTree().getEntity(ID);

        if (entity == null)
            throw new ID_ERROR();

        entity.setName(newName);
    }

    public void changeEntitySurname(int ID, String newSurname) throws ID_ERROR {
        Entity entity = this.save.getFamilyTree().getEntity(ID);

        if (entity == null)
            throw new ID_ERROR();

        entity.setSurname(newSurname);
    }

    public void sortByChildren() {
        this.save.getFamilyTree().sortByChildren();
    }

    public void sortByName() {
        this.save.getFamilyTree().sortByName();
    }

    public void sortBySurname(){
        this.save.getFamilyTree().sortBySurname();
    }

    public void sortByID(){
        this.save.getFamilyTree().sortByID();
    }

    public void changeEntitySpouse(int ID, int spouseID) throws ID_ERROR {
        Entity entity = this.save.getFamilyTree().getEntity(ID);

        Entity spouse = this.save.getFamilyTree().getEntity(spouseID);

        if (entity == null || spouse == null)
            throw new ID_ERROR();

        entity.setSpouse(spouse);

        ArrayList<Entity> spouseChildren = new ArrayList<>(spouse.getChildren());

        spouse.addChildren(entity.getChildren());

        entity.addChildren(spouseChildren);

        spouse.setSpouse(entity);
    }

    public void addKid(int ID, int kidID) throws ID_ERROR{
        Entity entity = this.save.getFamilyTree().getEntity(ID);

        Entity kid = this.save.getFamilyTree().getEntity(kidID);

        if (entity == null || kid == null)
            throw new ID_ERROR();

        entity.addKid(kid);

        if (entity.getGender().equals(Gender.male)) kid.setFather(entity);

        else kid.setMather(entity);

        if (entity.getSpouse() != null) entity.getSpouse().addKid(kid);
    }

    public void changeEntityMather(int ID, int matherID) throws ID_ERROR {
        addKid(matherID, ID);
    }

    public void changeEntityFather(int ID, int fatherID) throws ID_ERROR{
        addKid(fatherID, ID);
    }

    public void changeEntityDataOfBirth(int ID, int year, int mount, int day) throws ID_ERROR, Date_ERROR {
        Entity entity = this.save.getFamilyTree().getEntity(ID);

         if (entity == null)
            throw new ID_ERROR();

        MyDate date = new MyDate(year, mount, day);

        if (date.getDay() == null || date.getMonth() == null || date.getYear() == null){
            throw new Date_ERROR();
        }

        entity.setDateOfBirth(date);
    }

    public void changeEntityDataOfDeath(int ID, int year, int mount, int day) throws ID_ERROR, Date_ERROR {
        Entity entity = this.save.getFamilyTree().getEntity(ID);

         if (entity == null)
            throw new ID_ERROR();

        MyDate date = new MyDate(year, mount, day);

        if (date.getDay() == null || date.getMonth() == null || date.getYear() == null){
            throw new Date_ERROR();
        }

        entity.setDateOfDeath(date);
    }

    public void changeEntityGender(int ID, Gender gender) throws ID_ERROR{
        Entity entity = this.save.getFamilyTree().getEntity(ID);

        if (entity == null)
            throw new ID_ERROR();

        entity.setGender(gender);
    }

    public void saveFamilyTree() throws Exception {
        this.writer.save(this.save);
    }

    public void changeFileName(String newFileName) {
        this.save.setFileName(newFileName);
    }

    public void changeDescription(String newDescription){
        this.save.setDescription(newDescription);
    }

    public void openSave(String fileName) throws Exception{
        Save save = writer.open(fileName);

        if (!save.getFileName().equals(fileName))
            save.setFileName(fileName);

        this.save = save;
    }

    public ArrayList<String> getSavesList(){
        return this.writer.getSavesList();
    }

    public String getSaveDescription() {
        return this.save.getDescription();
    }

    public String getFileName(){
        return this.save.getFileName();
    }
}
