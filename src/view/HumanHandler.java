package view;

import presenter.Presenter;

import java.time.LocalDate;
import java.util.List;

public class HumanHandler {
    private Presenter presenter;
    private InputHandler inputHandler;

    public HumanHandler(Presenter presenter, InputHandler inputHandler) {
        this.presenter = presenter;
        this.inputHandler = inputHandler;
    }

    public void addHuman() {
        System.out.println("Укажите имя человека:");
        String name = inputHandler.getInput();

        System.out.println("Укажите пол человека м/ж:");
        String genderStr = inputHandler.getGenderInput();

        System.out.println("Укажите дату рождения человека через пробел в формате ДД ММ ГГГГ:");
        LocalDate birthDate = inputHandler.getBirthDateInput();

        presenter.addHuman(name, genderStr, birthDate);
    }

    public void findByName() {
        System.out.println("Укажите имя человека, которого хотите найти:");
        String name = inputHandler.getInput();
        presenter.findByName(name);
    }

    public void removeHuman() {
        System.out.println("Укажите имя человека, которого хотите удалить:");
        String name = inputHandler.getInput();
        presenter.findByName(name);
        List<Integer> foundHumansId = presenter.foundHumansId(name);
        if (foundHumansId.isEmpty()) {
            return;
        }
        System.out.println("Укажите id человека, которого хотите удалить:");
        boolean flag = true;
        while (flag) {
            String idStr = inputHandler.getInput();
            if (inputHandler.isValidIdChoice(idStr, foundHumansId)) {
                int id = Integer.parseInt(idStr);
                presenter.removeHuman(id);
                System.out.println("Человек по имени " + name + ", с id " + id + " был удалён.");
                flag = false;
            } else {
                System.out.println("Введён неверный id.\nВведите корректный id из списка: " + foundHumansId);
            }
        }
    }
}
