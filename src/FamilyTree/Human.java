package FamilyTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate dob;
    private LocalDate dod;
    private Gender gender;
    private String occupation;
    private String nationality;
    private String placeOfBirth;

    private Human father;
    private Human mother;
    private List<Human> children;
    private Human spouse;

    public Human(String name, LocalDate dob,
                 LocalDate dod,
                 Gender gender,
                 Human father,
                 Human mother) {

        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;

        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    // Getters and Setters

    public String getName() { return name; }

    public LocalDate getDob() { return dob; }

    public LocalDate getDod() { return dod; }

    public Gender getGender() { return gender; }

    public String getOccupation() { return occupation;}

    public void setOccupation(String occupation){ this.occupation=occupation;}

    public String getNationality(){return nationality;}

    public void setNationality(String nationality){this.nationality=nationality;}

    public String getPlaceOfBirth(){return placeOfBirth;}

    public void setPlaceOfBirth(String placeOfBirth){this.placeOfBirth=placeOfBirth;}

    public Human getFather(){return father;}

    public void setFather(Human father){this.father=father;}

    public Human getMother(){return mother;}

    public void setMother(Human mother){this.mother=mother;}

    public List<Human>getChildren(){return children;}

    public void addChild(Human child){if(!children.contains(child)){children.add(child);}if(this.gender==Gender.Male&&child.getFather()!=this){child.setFather(this);}else if(this.gender==Gender.Female&&child.getMother()!=this){child.setMother(this);}}

    public void setSpouse(Human spouse){this.spouse=spouse;}

    public Human getSpouse(){return spouse;}
}