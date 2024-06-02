package ru.gb.family_tree;

import java.time.LocalDate; // Добавьте этот импорт

public class DogNode extends Node {
    public DogNode(String name, Gender gender, LocalDate birthDate) {
        super(name, gender, birthDate);
    }

    // Методы и поля для хранения информации о собаке
}
