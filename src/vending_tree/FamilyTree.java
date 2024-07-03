package vending_tree;

import java.util.List;
import java.util.Random;

public class FamilyTree {

    /**
     * Метод для установки родителей
     * @param human объект
     */
    public void setParents(Human human) {
        String fatherName = getRandomName("Male");
        String motherName = getRandomName("Female");

        if (!fatherName.equals("Список имён пуст.")) {
            Human father = new Human(fatherName, false, false, false);
            human.setFather(father);
        }

        if (!motherName.equals("Список имён пуст.")) {
            Human mother = new Human(motherName, false, false, false);
            human.setMother(mother);
        }
    }

    /**
     * Метод для установки детей
     * @param human объект
     */
    public void setChildren(Human human) {
        Random rnd = new Random();
        int numChild = generateNumChild();

        for (int i = 0; i < numChild; i++) {
            String genderChild = rnd.nextInt(2) == 0 ? "Male" : "Female";
            String childName = getRandomName(genderChild);
            Gender gender = Gender.valueOf(genderChild);
            Human child = new Human(childName, false, false, false);
            child.setGender(gender);
            human.addChild(child);
        }
    }

    /**
     * Генерация числа в соотношении с процентом
     * @return число от 1 до 10
     */
    public int generateNumChild() {
        Random random = new Random();
        int randomPercentage = random.nextInt(100) + 1; // Генерация числа от 1 до 100

        if (randomPercentage <= 70) {
            // 1 - 2 (70%)
            return random.nextInt(2) + 1; // Генерация числа от 1 до 2
        } else if (randomPercentage <= 90) {
            // 3 - 5 (20%)
            return random.nextInt(3) + 3; // Генерация числа от 3 до 5
        } else if (randomPercentage <= 98) {
            // 6 - 7 (8%)
            return random.nextInt(2) + 6; // Генерация числа от 6 до 7
        }
        // 8 - 10 (2%)
        return random.nextInt(3) + 8; // Генерация числа от 8 до 10
    }


    /**
     * Метод для установки предков
     * @param human объект
     */
    public void setGrandParents(Human human) {
        this.setGrandParent(human.getFather(), "Male", human, "paternal");
        this.setGrandParent(human.getFather(), "Female", human, "paternal");

        this.setGrandParent(human.getMother(), "Male", human, "maternal");
        this.setGrandParent(human.getMother(), "Female", human, "maternal");
    }

    /**
     * Установка бабушек и дедушек по папе и маме
     * @param parent родитель human
     * @param gender пол родителя
     * @param human пользователь
     * @param relationType линия
     */
    private void setGrandParent(Human parent, String gender, Human human, String relationType) {
        if (parent != null) {
            String grandParentName = getRandomName(gender);
            if (!grandParentName.equals("Список имён пуст.")) {
                Human grandParent = new Human(grandParentName, false, false, false);

                if (gender.equals("Male")) {
                    parent.setFather(grandParent); // установка папы для родителя
                    if (relationType.equals("paternal")) {
                        human.setGrandFather(grandParent); // Установка дедушки по папе для human
                    } else {
                        human.setMaternalGrandFather(grandParent); // Установка дедушки по маме для human
                    }
                } else {
                    parent.setMother(grandParent); // Установка мамы для родителя
                    if (relationType.equals("paternal")) {
                        human.setGrandMother(grandParent); // Установка бабушки по папе для human
                    } else {
                        human.setMaternalGrandMother(grandParent); // Установка бабушки по маме для human
                    }
                }
            }
        }
    }

    /**
     * Генерация рандомного имени по полу
     * @param gender пол
     * @return имя
     */
    private String getRandomName(String gender) {
        WorkingWithAFile names = new WorkingWithAFile();
        List<String> listNames = names.getSexArrayNames("src/vending_tree/nameUser.txt", gender);

        if (!listNames.isEmpty()) {
            // Выбираем случайное имя из списка
            return listNames.get(new Random().nextInt(listNames.size()));
        }
        return "Список имён пуст.";
    }
}
