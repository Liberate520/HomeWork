package presenter;

import forView.NewView;
import module.lesson2.familytree.Creature;
import module.lesson2.human.FamilyStatus;
import module.lesson2.human.Gender;
import module.lesson2.human.Status;
import module.lesson2.service.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewPresenter <T extends Creature<T>> {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/dd/MM");
    NewView view;
    Service service;
    Status status;

    public NewPresenter(NewView v, Service s, Status st) {
        view = v;
        service = s;
        status = st;
    }

    public void choice() {
        view.selectAction();
        while (true) {
            String result = null;
            try {
                result = view.bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (Objects.equals(result, "1")) {
                read();
            } else if (Objects.equals(result, "2")) {
                List<String> list = new ArrayList<>();
                String newResult = null;
                for (int i = 0; i < view.getList().size(); i++) {
                    System.out.println(view.getList().get(i));
                    newResult = view.forNewMan();
                    list.add(i, newResult);
                }
                assert newResult != null;
                newObject(Integer.parseInt(list.get(0)), list.get(1), LocalDate.parse(list.get(2), formatter), LocalDate.parse(list.get(3), formatter), status.getGender(Integer.parseInt(list.get(4))), status.getStatus(Integer.parseInt(list.get(5))));
            } else if (Objects.equals(result, "3")) {
                allAboutOurHuman();
            } else if (Objects.equals(result, "4")) {
                addToTree();
            } else if (Objects.equals(result, "5")) {
                aboutOurTree();
            } else if (Objects.equals(result,"6")) {
                writeAll();
            } else if (Objects.equals(result,"7")) {
                sortByAge();
            } else if (Objects.equals(result, "8")) {
                sortByName();
            } else if (Objects.equals(result, "9")) {
                break;
            }
        }

}

    private void sortByName() {
        service.sortByName();
    }

    private void sortByAge() {
        service.sortByAge();
    }

    private void writeAll() {
        service.writeHuman();
    }

    private void aboutOurTree() {
        service.printPeopleList();
    }

    private void addToTree() {
        service.addHuman();
    }

    private void allAboutOurHuman() {
        service.allAboutMan();
    }

    private void newObject(int serialNumber, String someName, LocalDate birth, LocalDate death, Gender gender, FamilyStatus familyStatus) {
        service.createObject(serialNumber, someName, birth, death, gender, familyStatus);
    }

    private void read() {
        service.readHuman();
    }
}
