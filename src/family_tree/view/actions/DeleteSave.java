package family_tree.view.actions;

import family_tree.presenter.Presenter;

import java.util.Scanner;

public class DeleteSave implements MenuActions{
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Presenter presenter) {
        System.out.println("Это опасная команда, поэтому введите, пожалуйста, пароль: ");
        String password = scanner.nextLine();
        if (password.equals("667")) {
            System.out.println("Вы точно хотите удалить всю информацию о семейном древе? \n yes/no: ");
            String decision = scanner.nextLine().toLowerCase();
            if (decision.equals("yes")) {
                presenter.deleteSave();
                System.out.println("Данные успешно удалены");
            }
            else {
                System.out.println("Отмена команды");
            }
        }
        else {
            System.out.println("Неверный пароль, возвращение в меню...");
        }
    }
}
