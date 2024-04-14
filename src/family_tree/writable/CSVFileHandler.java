package family_tree.writable;

import family_tree.person.Person;

import java.io.BufferedReader;
import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class CSVFileHandler {
    private String filename;

    public CSVFileHandler(String filename) {
        this.filename = filename;
    }

    public void writeToFile(Map<Integer, Person> peopleMap) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Person person : peopleMap.values()) {
                String line = person.getId() + "," + person.getName() + "," + person.getGender() + "," + person.getAge();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, Person> readFromFile() {
        Map<Integer, Person> peopleMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String gender = parts[2];
                int age = Integer.parseInt(parts[3]);
                Person person = new Person(id, name, gender, age);
                peopleMap.put(id, person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return peopleMap;
    }
}
