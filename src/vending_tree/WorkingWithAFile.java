package vending_tree;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WorkingWithAFile {
    private Map<String, Gender> userData;

    public WorkingWithAFile() {
        this.userData = new HashMap<>();
    }

    /**
     * Чтение файла
     * @param fileName имя файла для чтения
     * @throws IOException класс ошибки
     */
    public void loadUserData(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",\\s*");
                if (parts.length == 2) {
                    String name = parts[0];
                    Gender gender = Gender.valueOf(parts[1].substring(0, 1).toUpperCase() + parts[1].substring(1).toLowerCase());
                    userData.put(name, gender);
                }
            }
        }
        catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    /**
     * Запись имён в файл
     * @param fileName имя файла для записи
     * @param name Имя пользователя для записи
     * @param gender гендер для записи
     */
    public void appendUserData(String fileName, String name, Gender gender) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(name + ", " + gender);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Ошибка при дозаписи в файл: " + e.getMessage());
        }
    }

    /**
     * Чтение файла с именами,
     * создание списка имён по гендеру,
     * возврат списка
     * @param filename имя файла для чтения
     * @param gender пол для изъятия списка
     * @return array names
     */
    public List<String> getSexArrayNames(String filename, String gender) {
        List<String> names = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 2) {
                    String name = parts[0].trim(); // Имя
                    String sex = parts[1].trim(); // Пол
                    // выбрать только имена определенного пола
                    if(sex.equals(gender)) {
                        names.add(name);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return names;
    }

    /**
     * Получение гендера пользователя
     * @param name имя для получения значения
     * @return гендер пользователя
     */
    public Gender getGender(String name) {
        return userData.get(name);
    }

    /**
     * Получение пользователей
     * @return userData
     */
    public Map<String, Gender> getUserData() {
        return userData;
    }
}
