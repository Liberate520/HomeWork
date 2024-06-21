package ru.gb.family_tree.model.Human;

import java.io.Serializable;

public class Gender implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Gender Male = new Gender("Мужской");
    public static final Gender Female = new Gender("Женский");

    private String gender;

    private Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}

