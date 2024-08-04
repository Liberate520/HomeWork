package ru.gb2.family_tree7.model.group;

import ru.gb2.family_tree7.model.human.Gender;
import ru.gb2.family_tree7.model.human.Human;

import java.time.LocalDate;
import java.util.List;

public interface GroupItem {
    // Метод для получения уникального идентификатора
    int getId();

    // Метод для получения имени
    String getName();

    // Метод для получения списка детей
    List<Human> getChildren();

    // Метод для добавления ребенка
    void addChild(Human child);

    // Методы для получения информации о родителях
    Human getFather();

    Human getMother();

    Gender getGender();

    LocalDate getBirthDate();

    LocalDate getDeathDate();
}