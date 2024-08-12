package Model.Creature;

import Model.Builders.InfoBuilder;
import Model.Builders.OwnInfoBuilder;
import Model.Formating.MyDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Creature implements Serializable, Entity {
    private Integer ID;
    private MyDate dateOfBirth, dateOfDeath;
    private String name, surname;
    private Gender gender;
    private final ArrayList<Entity> children = new ArrayList<>();
    private Entity mather, father, spouse;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public ArrayList<Entity> getChildren() {
        return children;
    }

    public MyDate getDateOfBirth() {
        return dateOfBirth;
    }

    public MyDate getDateOfDeath() {
        return dateOfDeath;
    }

    public Entity getFather() {
        return father;
    }

    public Entity getMather() {
        return mather;
    }

    public Integer getID() {
        return ID;
    }

    public Gender getGender() {
        return gender;
    }

    public Entity getSpouse() {
        return spouse;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(MyDate dateOfBirth) {
         this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfDeath(MyDate dataOfDeath) {
        this.dateOfDeath = dataOfDeath;
    }

    public void setFather(Entity father) {
        if (!this.equals(father)) {
            this.father = father;
        }
    }

    public void setMather(Entity mather) {
        if (!this.equals(mather)) {
            this.mather = mather;
        }
    }

    public void setSpouse(Entity spouse) {
        if (!this.equals(spouse)){
            this.spouse = spouse;
        }
    }

    public void addKid(Entity new_kid){
        if (!this.children.contains(new_kid)){

            this.children.add(new_kid);
        }
    }

    public void addChildren(ArrayList<Entity> children){
        for (Entity kid: children) this.addKid(kid);
    }

    public void removeKid(Entity kid){
        for (Entity currentKid: new ArrayList<>(this.children)){
            if (currentKid.equals(kid)) this.children.remove(kid);
        }
    }

    private OwnInfo packEntity(Entity entity){
        if (entity == null){
            return null;
        }

        return new OwnInfoBuilder()
                 .setID(entity.getID())
                 .setName(entity.getName())
                 .setSurname(entity.getSurname())
                 .setGender(entity.getGender())
                 .setDateOfBirth(entity.getDateOfBirth())
                 .setDateOfDeath(entity.getDateOfDeath())
                 .build();
    }

    public Info getInfo(){
        ArrayList<OwnInfo> childrenOwnInfo = null;

        if(!this.children.isEmpty()){
            childrenOwnInfo = new ArrayList<>();

             for (Entity kid: this.children){
                childrenOwnInfo.add(packEntity(kid));
            }
        }

        return new InfoBuilder()
                .setSelfInfo(packEntity(this))
                .setSpouseInfo(packEntity(this.spouse))
                .setMatherInfo(packEntity(this.mather))
                .setFatherInfo(packEntity(this.father))
                .setChildrenInfo(childrenOwnInfo)
                .build();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Creature creature = (Creature) obj;

        return this.ID.equals(creature.getID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname, this.gender, this.ID);
    }
}
