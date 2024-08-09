package ru.gb.family_tree.info_collector;

public class InfoCollector {
    Object name;
    Object patronymic;
    Object surname;
    Object gender;
    Object father;
    Object mother;
    Object children;
    Object profession;
    Object nationality;
    Object dateOfBirth;
    Object dateOfDeath;
    Object birthPlace;
    Object notes;

    public void setCollectorItem(Object data, CollectorItems collectorItem){
        switch (collectorItem){
            case CollectorItems.Name -> name = data;
            case CollectorItems.Patronymic -> patronymic = data;
            case CollectorItems.Surname -> surname = data;
            case CollectorItems.Gender -> gender = data;
            case CollectorItems.Father -> father = data;
            case CollectorItems.Mother -> mother = data;
            case CollectorItems.Children -> children = data;
            case CollectorItems.Profession -> profession = data;
            case CollectorItems.Nationality -> nationality = data;
            case CollectorItems.DateOfBirth -> dateOfBirth = data;
            case CollectorItems.DateOfDeath -> dateOfDeath = data;
            case CollectorItems.BirthPlace -> birthPlace = data;
            case CollectorItems.Notes -> notes = data;
        }
    }

    public Object getCollectorItem(CollectorItems collectorItem){
        switch (collectorItem){
            case CollectorItems.Name -> {
                return name;
            }
            case CollectorItems.Patronymic -> {
                return patronymic;
            }
            case CollectorItems.Surname -> {
                return surname;
            }
            case CollectorItems.Gender -> {
                return gender;
            }
            case CollectorItems.Father -> {
                return father;
            }
            case CollectorItems.Mother -> {
                return mother;
            }
            case CollectorItems.Children -> {
                return children;
            }
            case CollectorItems.Profession -> {
                return profession;
            }
            case CollectorItems.Nationality -> {
                return nationality;
            }
            case CollectorItems.DateOfBirth -> {
                return dateOfBirth;
            }
            case CollectorItems.DateOfDeath -> {
                return dateOfDeath;
            }
            case CollectorItems.BirthPlace -> {
                return birthPlace;
            }
            case CollectorItems.Notes -> {
                return notes;
            }
        }
        return null;
    }

}
