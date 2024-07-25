package model.persons.person_manager;

import model.persons.Person;

public class PersonFormatter {
    private Person person;

    public PersonFormatter(Person person) {
        this.person = person;
    }

    public String formatFullPerson() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(person.getId())
                .append(", имя: ").append(person.getName())
                .append(", возраст: ").append(person.getAge())
                .append(", пол: ").append(person.getGender())
                .append(", ").append(getSpouseInfo())
                .append(", ").append(getMotherInfo())
                .append(", ").append(getFatherInfo())
                .append(", ").append(getChildrenInfo());
        return sb.toString();
    }

    private String getSpouseInfo() {
        return "супруг(а): " + (person.getSpouse() != null ? person.getSpouse().getName() : "нет");
    }

    private String getMotherInfo() {
        return "мать: " + (person.getMother() != null ? person.getMother().getName() : "неизвестна");
    }

    private String getFatherInfo() {
        return "отец: " + (person.getFather() != null ? person.getFather().getName() : "неизвестен");
    }

    private String getChildrenInfo() {
        StringBuilder childrenInfo = new StringBuilder();
        if (!person.getChildren().isEmpty()) {
            childrenInfo.append(person.getChildren().get(0).getName());
            for (int i = 1; i < person.getChildren().size(); i++) {
                childrenInfo.append(", ").append(person.getChildren().get(i).getName());
            }
        }
        else {
            childrenInfo.append("нет детей");
        }
        return childrenInfo.toString();
    }
}
