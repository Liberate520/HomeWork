import java.util.List;
import java.util.Scanner;

public class ConsoleFamilyTreeView<T extends FamilyMember> implements FamilyTreeView<T> {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMember(T member) {
        System.out.println(member);
    }

    @Override
    public void displayMembers(List<T> members) {
        for (T member : members) {
            System.out.println(member);
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Найти человека по ID");
        System.out.println("2. Найти человека по имени");
        System.out.println("3. Найти человека по фамилии");
        System.out.println("4. Получить информацию о детях человека");
        System.out.println("5. Сохранить семейное древо");
        System.out.println("6. Загрузить семейное древо");
        System.out.println("7. Сортировать по возрасту");
        System.out.println("8. Сортировать по полу");
        System.out.println("9. Выйти");
    }

    public int getInput() {
        return scanner.nextInt();
    }

    public String getStringInput() {
        return scanner.next();
    }
}