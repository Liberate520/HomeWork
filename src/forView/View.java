package forView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {
    public BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public int selectAction(){
        int result = 0;
        System.out.println("Выберите действие: ");
        System.out.println("1 - прочтение информации из файла;");
        System.out.println("2 - создание нового объекта типа Human;");
        System.out.println("3 - добавление нового объекта в дерево;");
        System.out.println("4 - указать супруга(у);");
        System.out.println("6 - для выхода из программы;");
        try {
            result = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
