package model;

public class WOD {
    private final String id; // Автоматически генерируемый ID
    private final String title;
    private final String description;
    private final String scoringMethod;

    public WOD(String title, String description, String scoringMethod) {
        this.id = generateId(); // Генерация ID
        this.title = title;
        this.description = description;
        this.scoringMethod = scoringMethod;
    }

    private String generateId() {
        // Логика генерации уникального ID
        return String.valueOf(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getScoringMethod() {
        return scoringMethod;
    }
}
