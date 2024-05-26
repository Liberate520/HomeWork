package homeWork;

import java.util.List;

public class FamilyTree {

    // Метод для отображения информации о родителях и детях по указанному идентификатору
    public void displayFamilyInfo(Long personId, List<Person> allPersons) {
        // Поиск персоны по указанному идентификатору
        Person person = findPersonById(personId, allPersons);

        // Если персона с указанным идентификатором не найдена, выводим сообщение об ошибке
        if (person == null) {
            System.out.println("Персона с ID " + personId + " не найдена.");
            return;
        }

        // Вывод информации о персоне
        System.out.println("Информация о персоне:");
        displayPersonInfo(person);
        System.out.println();

        // Вывод информации о родителях и детях
        displayRelativesInfo("Родители:", person.getParentIds(), allPersons);
        displayRelativesInfo("Дети:", person.getChildIds(), allPersons);
    }

    // Метод для поиска персоны по идентификатору
    private Person findPersonById(Long personId, List<Person> allPersons) {
        return allPersons.stream()
                .filter(person -> person.getId().equals(personId))
                .findFirst()
                .orElse(null);
    }

    // Метод для отображения информации о персоне
    private void displayPersonInfo(Person person) {
        System.out.println("ID: " + person.getId());
        System.out.println("Фамилия: " + person.getLastName());
        System.out.println("Имя: " + person.getFirstName());
        System.out.println("Отчество: " + person.getMiddleName());
        System.out.println("Дата рождения: " + person.getBirthDate());
        System.out.println("Пол: " + person.getGender());
    }

    // Метод для отображения информации о родственниках
    private void displayRelativesInfo(String relationship, List<Long> relativeIds, List<Person> allPersons) {
        System.out.println(relationship);

        if (relativeIds.isEmpty()) {
            System.out.println("Нет информации о родственниках.");
            return;
        }

        relativeIds.stream()
                .map(relativeId -> findPersonById(relativeId, allPersons))
                .filter(relative -> relative != null)
                .forEach(this::displayPersonInfo);
    }
}
