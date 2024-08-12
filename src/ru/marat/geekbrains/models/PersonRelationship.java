package ru.marat.geekbrains.models;

public class PersonRelationship implements ParentChildRelationship<Person> {

    @Override
    public Person getMother(Person person) {
        return person.getMother();
    }

    @Override
    public Person getFather(Person person) {
        return person.getFather();
    }
}
