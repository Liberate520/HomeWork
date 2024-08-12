package Presenter;

import Model.Creature.Gender;
import Model.Creature.Info;
import Model.Service;
import View.View;

import java.util.ArrayList;

public class Presenter {
    private final Service service;

    public Presenter(View view, Service service){
        this.service = service;

        view.setPresenter(this);
    }


    public void createFamilyTree(String familyTreeName, String description) {
        this.service.createFamilyTree(familyTreeName, description);
    }

    public void exitFromFamilyTree(){
        this.service.deleteCurrentSave();
    }

    public ArrayList<Info> getFamilyTreeInfo(){
        return this.service.getFamilyTreeInfo();
    }

    public void addEntity(String name, String surname, Gender gender){
        service.createCreature(name, surname, gender);
    }

    public ArrayList<Info> findEntity(String name, String surname){
        return service.findEntity(name, surname);
    }

    public Info getEntityInfo(int ID) throws Exception{
        return this.service.getEntityInfo(ID);
    }

    public void removeEntity(int ID) throws Exception {
        this.service.removeEntity(ID);
    }

    public void changeEntityName(int ID, String newName) throws Exception{
        this.service.changeEntityName(ID, newName);
    }

    public void changeEntitySurname(int ID, String newSurname) throws Exception{
        this.service.changeEntitySurname(ID, newSurname);
    }

    public void sortByChildren() {
        this.service.sortByChildren();
    }

    public void sortByName() {
        this.service.sortByName();
    }

    public void sortBySurname(){
        this.service.sortBySurname();
    }

    public void sortByID(){
        this.service.sortByID();
    }

    public void changeEntitySpouse(int ID, int spouseID) throws Exception{
        this.service.changeEntitySpouse(ID, spouseID);
    }

    public void addKid(int ID, int kidID) throws Exception {
        this.service.addKid(ID, kidID);
    }

    public void changeEntityMather(int ID, int matherID) throws Exception {
        this.service.changeEntityMather(ID, matherID);
    }

    public void changeEntityFather(int ID, int fatherID) throws Exception{
        this.service.changeEntityFather(ID, fatherID);
    }

    public void changeDataOfBirth(int ID, int year, int mount, int day) throws Exception {
        this.service.changeEntityDataOfBirth(ID, year, mount, day);
    }

    public void changeDataOfDeath(int ID, int year, int mount, int day) throws Exception{
        this.service.changeEntityDataOfDeath(ID, year, mount, day);
    }

    public void changeEntityGender(int ID, Gender gender) throws Exception{
        this.service.changeEntityGender(ID, gender);
    }

    public void saveFamilyTree() throws Exception {
        this.service.saveFamilyTree();
    }

    public void changeFileName(String newFileName) {
        this.service.changeFileName(newFileName);
    }

    public void changeDescription(String newDescription){
        this.service.changeDescription(newDescription);
    }

    public void openSave(String fileName) throws Exception {
        this.service.openSave(fileName);
    }

    public ArrayList<String> getSavesList(){
        return this.service.getSavesList();
    }

    public String getSaveDescription() {
        return this.service.getSaveDescription();
    }

    public String getFileName(){
        return this.service.getFileName();
    }
}
