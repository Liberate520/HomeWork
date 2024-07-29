package model.familyTree;

import model.Human.Gender;
import model.Human.Human;

import java.time.LocalDate;
import java.time.Period;

public interface ItemFamilyTree {
    String getName();
    int getAge();

    public void setName(String name);

    public LocalDate getDob();

    public void setDob(LocalDate dob);

    public LocalDate getDod();

    public void setDod(LocalDate dod);

    public Gender getGender();

    public void setGender(Gender gender);

    public Human getFather();

    public void setFather(ItemFamilyTree person);

    public Human getMother();


    public String getChildren();

    public void addChild(ItemFamilyTree child);

    void setMother(ItemFamilyTree person);
}
