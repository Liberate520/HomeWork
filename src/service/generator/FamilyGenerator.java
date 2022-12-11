package service.generator;

import service.classes.Gender;
import service.classes.Person;
import service.dataBase.DBHandler;

import java.util.ArrayList;

import static service.classes.Gender.FEMALE;
import static service.classes.Gender.MALE;
import static service.classes.Marriage.YES;
import static service.tree.RelationType.HUSBAND;
import static service.tree.RelationType.WIFE;

/*
Класс для генерации семейных пар в базе
 */
public class FamilyGenerator {

    private final DBHandler db;
    private final int generation;

    public FamilyGenerator(DBHandler db, int generation) {
        this.generation = generation;
        this.db = db;
    }

    /* создаём семьи */
    public void createFamilies() {
        ArrayList<Person> target;
        ArrayList<Person> males = db.getListOf(MALE, generation);
        ArrayList<Person> females = db.getListOf(FEMALE, generation);
        if (males.size() > females.size()) {
            target = females;
        } else {
            target = males;
        }
        for (Person parent : target) {
            prepareCouple(parent);
        }
    }

    /* подготовка */
    private void prepareCouple(Person person) {
        switch (person.getGender()) {
            case MALE -> marriage(person, check(FEMALE), db);
            case FEMALE -> marriage(person, check(MALE), db);
        }
    }

    /* подбор людей */
    private Person check(Gender state) {
        Person person = GetRandom.getRandomPerson(db);
        if (person.getGender() == state) {
            if (person.getGeneration() == this.generation) {
                return person;
            }
        }
        person = check(state);
        return person;
    }

    /**
     * создание семьи
     *
     * @param person    - первый человек
     * @param personSec - второй человек
     * @param db        - база данных
     */
    private void marriage(Person person, Person personSec, DBHandler db) {
        switch (person.getGender()) {
            case MALE -> {
                personSec.setFamilyName(person.getFamilyName());
                person.addMember(WIFE, personSec);
                personSec.addMember(HUSBAND, person);
            }
            case FEMALE -> {
                person.setFamilyName(personSec.getFamilyName());
                person.addMember(HUSBAND, personSec);
                personSec.addMember(WIFE, person);
            }
        }
        Person[] pair = {person, personSec};
        person.setMarriageStatus(YES);
        personSec.setMarriageStatus(YES);
        db.addFamilyToCache(pair);
    }
}
