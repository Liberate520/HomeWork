package family_tree.view.actions;

import family_tree.presenter.Presenter;
import family_tree.view.Menu;

import java.util.Scanner;

public class AddChildAction implements MenuActions{
    Scanner scanner = new Scanner(System.in);



    @Override
    public void execute(Presenter presenter) {
        System.out.println("Вы хотите определить человека как ребенка другого человека, пожалуйста, введите ID родителя: ");
        String idParent = scanner.nextLine();

        System.out.println("Спасибо, теперь введите ID ребенка: ");
        String idChild = scanner.nextLine();
        int parent = 0;
        int child = 0;

        try {
            parent = Integer.parseInt(idParent);
            child = Integer.parseInt(idChild);
            presenter.addChild(parent, child);

            System.out.println("Ребенок успешно добавлен к родителю.");

        } catch (NumberFormatException e) {
            System.out.println("Введены некорректные ID. Пожалуйста, введите числовые значения.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка при добавлении ребенка к родителю: " + e.getMessage());
        }

    }
}
