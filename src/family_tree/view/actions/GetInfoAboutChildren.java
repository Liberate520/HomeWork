package family_tree.view.actions;

import family_tree.presenter.Presenter;

import java.util.Scanner;

public class GetInfoAboutChildren implements MenuActions {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Presenter presenter) {
        System.out.println("Введите ID: ");
        String strID = scanner.nextLine();
        try {
            int intID = Integer.parseInt(strID);
            String childrenAbout = presenter.getInfoAboutChildren(intID);
            System.out.println("Информация о детях: \n" + childrenAbout);
        } catch (NumberFormatException e) {
            System.out.println("Введены некорректные ID. Пожалуйста, введите числовые значения.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка при выяснении информации о детях: " + e.getMessage());
        }
    }
}
