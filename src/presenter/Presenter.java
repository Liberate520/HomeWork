package presenter;

import forView.View;
import module.lesson2.familytree.Creature;
import module.lesson2.familytree.FamilyTree;
import module.lesson2.human.Human;
import module.lesson2.human.Status;
import module.lesson2.writer.WriteReadHuman;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Presenter<T extends Creature<T>> {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/dd/MM");
    Human human;
    Status status;
    View view;
    WriteReadHuman<T> writeReadHuman;
    FamilyTree<Human> familyTree;
    public Presenter(View v, WriteReadHuman<T> wrh, Status s, FamilyTree<Human> f) {
        view = v;
        writeReadHuman = wrh;
        status = s;
        familyTree = f;
    }

    public void Button() throws IOException {
        while (true) {
            int result = view.selectAction();
            if (result == 1) {
                System.out.println(writeReadHuman.readHuman());
            } else if (result == 2) {
                System.out.println("Укажите по порядку:");
                System.out.println("№;");
                System.out.println("Фамилию и имя;");
                System.out.println("Дату рождения в формате yyyy/dd/mm;");
                System.out.println("Дату смерти в формате yyyy/dd/mm;");
                System.out.println("Пол;");
                System.out.println("Семейный статус;");
                human = new Human(Integer.parseInt(view.bufferedReader.readLine()), view.bufferedReader.readLine(),
                        LocalDate.parse(view.bufferedReader.readLine(), formatter),LocalDate.parse(view.bufferedReader.readLine(), formatter),
                        status.getGender(Integer.parseInt(view.bufferedReader.readLine())), status.getStatus(Integer.parseInt(view.bufferedReader.readLine())));
                System.out.println(human);
            } else if(result == 3){
                familyTree.addPeople(human);
                System.out.println("Успешно добавлен!");
                System.out.println(familyTree.getPeopleList());
            } else if (result == 4){
                System.out.println("Укажи номера супругов: ");
                familyTree.getPeopleList().get(Integer.parseInt(view.bufferedReader.readLine())).setWhoSpouse(familyTree.getPeopleList().get(Integer.parseInt(view.bufferedReader.readLine())));
                System.out.println("Укажите дату свадьбы в формате yyyy/dd/mm: ");
                human.setDateOfMarriage(LocalDate.parse(view.bufferedReader.readLine()));
            }
            else {
                break;
            }
        }
    }
}
