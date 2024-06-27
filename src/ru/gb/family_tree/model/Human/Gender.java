package ru.gb.family_tree.model.Human;

import java.io.Serializable;

public class Gender implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Gender Male = new Gender("мужской");
    public static final Gender Female = new Gender("женский");

    private String gender;

    private Gender(String gender) {
        this.gender = gender;
    }

    public static Gender valueOf(String genderStr) {
        if (genderStr.equalsIgnoreCase("мужской")) {
            return Male;
        } else if (genderStr.equalsIgnoreCase("женский")) {
            return Female;
        } else {
            throw new IllegalArgumentException("Некорректное значение пола: " + genderStr);
        }
    }

    @Override
    public String toString() {
        return gender;
    }
}

