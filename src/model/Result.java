package model;

public class Result {
    private User athlete;
    private WOD wod;
    private int repetitions;
    private String time;
    private String scoringMethod; // Добавляем атрибут scoringMethod

    // Конструктор и другие методы...

    public Result(User athlete, WOD wod, int repetitions, String time, String scoringMethod) {
        this.athlete = athlete;
        this.wod = wod;
        this.repetitions = repetitions;
        this.time = time;
        this.scoringMethod = scoringMethod;
    }

    public User getAthlete() {
        return athlete;
    }

    public WOD getWod() {
        return wod;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public String getTime() {
        return time;
    }

    public String getScoringMethod() {
        return scoringMethod; // Добавляем геттер для scoringMethod
    }
}
