package family_tree.presenter;

import java.io.Serializable;
import java.time.LocalDate;

import family_tree.model.file_system.enums.StatusFileFS;
import family_tree.model.human.types_enum.Gender;
import family_tree.model.service.Service;
import family_tree.view.View;

public class Presenter implements Serializable{
    private View view;
    private Service service;

    public Presenter(View view)
    {
        this.view = view;
        service = new Service();
    }

    public void addHumanToTree(String name, LocalDate birthday, LocalDate deadDay, Gender gender)
    {
        service.addHumanToTree(name, birthday, deadDay, gender);
    }

    public void getFamilyTreeHumansListInfo()
    {
        String answer = service.getFamilyTreeProbandsListInfo();
        view.answer(answer);
    }

    public int getFamilyListSize()
    {
        return service.getFamilyListSize();
    }

    public void addParentToChild(int mothers_index, int fathers_index, int child_index)
    {
        service.addParentToChild(mothers_index, fathers_index, child_index);
    }

    public void sortByName()
    {
        service.sortByName();
        getFamilyTreeHumansListInfo();
    }

    public void sortByAge()
    {
        service.sortByAge();
        getFamilyTreeHumansListInfo();
    }

    public StatusFileFS saveTreeOOS(String file_path)
    {
        return service.saveTreeOOS(file_path);
    }

    public StatusFileFS loadHumanTreeOOS(String file_path)
    {
        return service.loadHumanTreeOOS(file_path);
    }
}
