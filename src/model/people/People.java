package model.people;

import model.comparators.ComparatorByAge;
import model.comparators.ComparatorByFamilyName;
import model.comparators.ComparatorByName;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static model.people.Gender.female;
import static model.people.Gender.male;

public class People implements Serializable {
    private final List<Human> humanList;

    public People () {
        humanList = new ArrayList<>();
    }

    public boolean humanDeath(int humanIndex, LocalDate deathDate) {
        if (humanIndex < humanList.size() && humanList.get(humanIndex).getBirthData().getYear() < deathDate.getYear()) {
            humanList.get(humanIndex).setDeathData(deathDate);
            return true;
        } else return false;
    }
    public boolean addHuman(String name, String familyName, Gender gender, LocalDate birthData, int indexMother, int indexFather) {
        Human human = new Human(name, familyName, gender, birthData, getMotherByIndex(indexMother), getFatherByIndex(indexFather));
        if (humanList.contains(human)) return false;
        else {
            humanList.add(human);
            return true;
        }
    }

    private Human getMotherByIndex(int indexMother) {
        Human mother = null;
        if (indexMother < humanList.size() && getHuman(indexMother).getGender() == female) {
            mother = getHuman(indexMother);
        }
        return mother;
    }
    private Human getFatherByIndex(int indexFather) {
        Human father = null;
        if (indexFather < humanList.size() && getHuman(indexFather).getGender() == male) {
            father = getHuman(indexFather);
        }
        return father;
    }

    public Integer getHumanListSize() {
        return humanList.size();
    }
    public Human getHuman(int index) {
        return humanList.get(index);
    }
    public String getAllHumans() {
        return "Список людей:\n" + getByGender(null);
    }
    public String getMan() {
        return "Список мужчин:\n" + getByGender(female);
    }
    public String getWoman() {
        return "Список женщин:\n" + getByGender(male);
    }

    private String getByGender(Gender gender) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : humanList) {
            if (human.getGender() != gender) {
                stringBuilder.append(humanList.indexOf(human));
                stringBuilder.append(" ");
                stringBuilder.append(human);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void sortByAge() {
        humanList.sort(new ComparatorByAge<>());
    }
    public void sortByName() {
        humanList.sort(new ComparatorByName<>());
    }
    public void sortByFamilyName() {
        humanList.sort(new ComparatorByFamilyName<>());
    }


}
