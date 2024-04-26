package model.human;

public enum Gender {
    Male("Man"), Female("Woman");
    String description;

    Gender(String description) {
        this.description = description;
    }
}