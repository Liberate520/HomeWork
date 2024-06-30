import java.util.List;

interface FileOperations {
    void saveToFile(String filename, List<Person> members); // Метод для сохранения в файл
    List<Person> loadFromFile(String filename); // Метод для загрузки из файла
}