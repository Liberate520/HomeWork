package presenter;

import Model.FamilyFree;
import Model.Human;
import Viev.View;

public class Presenter
{
    private View view;
    FamilyFree<Human> familyConnect;

    public Presenter(View view, FamilyFree<Human> familyConnect)
    {
        this.familyConnect = familyConnect;
        this.view = view;
        view.setPresenter(this);
    }

    public void AddHumanNew()
    {
        System.out.print("������� ���-> ");
        String name = view.scan();
        System.out.print("������� ���(���./���.)-> ");
        String sex = view.scan();
        System.out.print("������� �������-> ");
        int age = Integer.parseInt(view.scan());
        System.out.println();
        familyConnect.addFamilyFree(new Human(name, sex, age));
        view.print("����� ���� ����� �������� !");
        view.print(familyConnect.getFamilyFree().get(familyConnect.getFamilyFree().size() - 1));
    }

    public void familyPrint()
    {
        view.print(familyConnect);
    }

    public void humanSearch()
    {
        System.out.print("������� ��� �������� ��� ������-> ");
        String name =  view.scan();
        System.out.println(name);
        Human chelovek = familyConnect.getByName(name);
        if (chelovek == null) view.print("������ �������� ��� � ����� !");
        else view.print(chelovek);
    }
}