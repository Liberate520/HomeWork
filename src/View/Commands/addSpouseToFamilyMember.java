package View.Commands;

import Model.Human.Gender;
import View.Command;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class addSpouseToFamilyMember extends Command {
    Scanner scanner;
    public addSpouseToFamilyMember() {
        super("Добавить в супруга");
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        System.out.println("Введите id члена семьи:");
        Integer idMember = Integer.parseInt(scanner.nextLine());
        System.out.println("Вы ввели Id:" + idMember);
        System.out.println("Введите id его супруга(ги):");
        Integer idSpouse = Integer.parseInt(scanner.nextLine());
        System.out.println("Вы ввели Id:" + idSpouse);
        presenter.addSpouseToFamilyMember(idMember,idSpouse);
        System.out.println("Теперь они супруги" + presenter.getFamilyTreeInfo());

    }
}
