package family_tree.view.actions;

import family_tree.presenter.Presenter;

import java.util.Scanner;

public class GetInfoAboutParents implements MenuActions{
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Presenter presenter) {
        System.out.println("Введите ID: ");
        String strID = scanner.nextLine();
        try {
            int intID = Integer.parseInt(strID);
            String parentsAbout = presenter.getInfoAboutParents(intID);
            System.out.println("Информация о родителях: \n" + parentsAbout);
        } catch (NumberFormatException e) {
            System.out.println("Введены некорректные ID. Пожалуйста, введите числовые значения.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка при выяснении информации о родителях: " + e.getMessage());
        }
    }
}
