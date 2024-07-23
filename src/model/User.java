package model;

public class User {
    private final String id; // Автоматически генерируемый ID
    private final String login;
    private final String passwordHash;
    private final String firstName;
    private final String lastName;

    public User(String login, String password, String firstName, String lastName) {
        this.id = generateId(); // Генерация ID
        this.login = login;
        this.passwordHash = hashPassword(password); // Хэширование пароля
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String generateId() {
        // Логика генерации уникального ID
        return String.valueOf(System.currentTimeMillis());
    }

    private String hashPassword(String password) {
        // Логика хэширования пароля (упрощённая для примера)
        return Integer.toString(password.hashCode());
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
