package model.file;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

import model.Tree;
import model.person.Person;

/**
 * FileCSV
 */
public class FileCSV implements Files {
    private String file_name;

    public FileCSV(String file_name) {
        this.file_name = file_name;
    }

    public FileCSV() {
        this("bd.csv");
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_name() {
        return this.file_name;
    }

    private Boolean fileExist(String file_name) {
        File file = new File(file_name);
        return file.exists();
    }

    private String[] convertLineToArray(String line) {
        line = line.replaceAll("\"", "");
        return line.split(",");
    }

    private LinkedHashMap<String, String> arraysToMap(String[] fields, String[] values) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < fields.length; i++) {
            if (values.length > i) {
                map.put(fields[i], values[i]);
            } else {
                map.put(fields[i], "");
            }
        }
        return map;
    }

    @Override
    public Boolean saveFile(Tree<Person> family) {
        String bd_file = new File(this.file_name).getAbsolutePath();

        String text = convertPersonslistToCSV(family);
        try {
            FileWriter writer = new FileWriter(bd_file, false);
            writer.write(text);
            writer.flush();
            writer.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private String convertPersonslistToCSV(Tree<Person> family) {
        LinkedHashSet<String> csv_fields_set = new LinkedHashSet<>();
        StringBuilder csv_fields = new StringBuilder();
        StringBuilder csv_text = new StringBuilder();

        for (Person pers : family) {
            String[] temp = pers.getFullInfoInText().split(",");
            for (String inf : temp) {
                String[] inf_arr = inf.split(":", 2);
                csv_fields_set.add(inf_arr[0]);
                csv_text.append(inf_arr[1] + ",");
            }
            csv_text.replace(csv_text.length() - 1, csv_text.length(), "\n");
        }

        for (String str : csv_fields_set) {
            csv_fields.append(str + ",");
        }
        csv_fields.replace(csv_fields.length() - 1, csv_fields.length(), "\n");

        return csv_fields.append(csv_text).toString();
    }

    @Override
    public Tree<Person> readFile() {
        Tree<Person> family = new Tree<Person>();

        String bd_file = new File(file_name).getAbsolutePath();
        if (!fileExist(bd_file)) {
            return new Tree<Person>();
        }

        try {
            FileReader fr = new FileReader(bd_file);
            Scanner fscan = new Scanner(fr);

            String line = fscan.nextLine().trim().replaceAll("\n", "");
            String[] fields = convertLineToArray(line);

            while (fscan.hasNextLine()) {
                line = fscan.nextLine().trim().replaceAll("\n", "");

                LinkedHashMap<String, String> map = new LinkedHashMap<>();
                String[] values = convertLineToArray(line);
                map = arraysToMap(fields, values);

                int i = Integer.parseInt(map.get("person_id"));

                Person pers = new Person(map);
                family.add(i, pers);
            }
            fr.close();
            fscan.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return makeRelativesFromCSV(family);
    }

    // Метод создания родственных связей из айди родителей
    private Tree<Person> makeRelativesFromCSV(Tree<Person> family) {
        int mother_id, father_id;
        for (Person pers : family) {
            
            if (pers.getPerson_info().get("mother_id") != "") {
                mother_id = Integer.parseInt(
                        pers.getPerson_info().get("mother_id"));

                Person mother = family.get(mother_id);
                pers.setMother(mother);
                family.get(mother_id).setPerson_childs(pers);
            }

            if (pers.getPerson_info().get("father_id") != "") {
                father_id = Integer.parseInt(
                        pers.getPerson_info().get("father_id"));

                Person father = family.get(father_id);
                pers.setFather(father);
                family.get(father_id).setPerson_childs(pers);
            }
        }
        return family;
    }

}