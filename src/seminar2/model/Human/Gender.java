package seminar2.model.Human;

public enum Gender {
    Male("Мужской"),
    Female("Женский");

    private String title;

    Gender(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
