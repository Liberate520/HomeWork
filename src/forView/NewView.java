package forView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewView {
    public BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final List<String> list = new ArrayList<>(Arrays.asList("№;", "Фамилию и имя;", "Дату рождения в формате yyyy/dd/mm;", "Дату смерти в формате yyyy/dd/mm;", "Пол - 1 муж/ 2 жен;", "Семейный статус - 1 женат/2 замужем;"));

    public List<String> getList() {
        return list;
    }

    public void selectAction() {
        String result;
        System.out.println("Выберите действие: ");
        System.out.println("1 - прочтение информации из файла;");
        System.out.println("2 - создание нового объекта типа Human;");
        System.out.println("3 - информация об объекте Human;");
        System.out.println("4 - добавление нового объекта в дерево;");
        System.out.println("5 - вся информация из дерева;");
        System.out.println("6 - записать информацию в файл;");
        System.out.println("7 - сортировать по возрасту;");
        System.out.println("8 - сортировать по имени;");
        System.out.println("9 - выйти из программы;");
    }

    public String forNewMan(){
        String result = null;

        try {
              result = bufferedReader.readLine();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}

