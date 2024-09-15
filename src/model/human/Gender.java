package model.human;

public enum Gender {
    MALE("мужской"),
    FEMALE("женский");

    private String title;
    Gender(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
}
