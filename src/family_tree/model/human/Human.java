package family_tree.model.human;

import family_tree.model.family_tree.ItemFamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Human implements Serializable, ItemFamilyTree {
    private int id;
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private Human father, mather;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public LocalDate getDob() {
        return dob;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMather() {
        return mather;
    }

    public void setMather(Human mather) {
        this.mather = mather;
    }

    @Override
    public String toString() {
        String fatherstring;
        String matherstring;
        String dobstring;
        String dodstring;
        String genderstring;
        if (dob == null) {
            dobstring = "";
        } else {
            dobstring = ", дата рождения: " + dob.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
        }
        if (dod == null) {
            dodstring = "";
        } else {
            dodstring = ", дата смерти: " + dod.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
        }
        if (father == null) {
            fatherstring = "";
        } else {
            fatherstring = ", отец: " + father.id + ", " + father.getName();
        }
        if (mather == null) {
            matherstring = "";
        } else {
            matherstring = ", мать: " + mather.id + ", " + mather.getName();
        }
        if (gender == null) {
            genderstring = "";
        } else if (gender == Gender.Male) {
            genderstring = ", пол: мужской";
        } else {
            genderstring = ", пол: женский";
        }
        return id + ", имя: " + name + dobstring + dodstring + genderstring +
                fatherstring + matherstring;
    }


}
