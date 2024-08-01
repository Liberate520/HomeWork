package ru.gb2.family_tree7.view;

public class ConsoleFamilyTreeView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("1. Добавить члена семьи");
        System.out.println("2. Посмотреть список семьи");
        System.out.println("3. Выбрать члена семьи");
        System.out.println("4. Выход");
    }

    @Override
    public void showFamilyMembers(List<Human> familyMembers) {
        System.out.println("Члены семьи:");
        for (Human member : familyMembers) {
            System.out.println("- " + member.getName());
        }
    }

    @Override
    public void showMemberDetails(Human member) {
        System.out.println("Имя: " + member.getName());
        System.out.println("Пол: " + member.getGender());
        System.out.println("Дата рождения: " + member.getBirthDate());
        System.out.println("Возраст: " + member.getAge());
        System.out.println("Дети: " + (member.getChildren().isEmpty() ? "Нет" : member.getChildren()));
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }
}
}
