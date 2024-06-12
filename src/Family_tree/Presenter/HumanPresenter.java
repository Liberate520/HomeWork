package Family_tree.Presenter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import Family_tree.Model.HumanService;
import Family_tree.Model.Service;
import Family_tree.Model.Humans.Human;
import Family_tree.Model.Tree.Family_tree;
import Family_tree.View.HumanView;
import Family_tree.View.View;

public class HumanPresenter extends Presenter<Human> {
    private HumanService service;
    private Family_tree<Human> activeTree;
    private HumanView view;

    public HumanPresenter(HumanView view){
        service = new HumanService();
        this.view = view;
    }
    @Override
    public View<Human> getView() {
        return this.view;
    }


    @Override
    public Service<Human> getService() {
        return this.service;
    }


    @Override
    public String createActiveTree() {
        System.out.println("Укажите фамилию");
        Scanner scanner = new Scanner(System.in);
        String family = scanner.nextLine();
        scanner.close();
        try{
            service.addTree(family);
            this.activeTree = service.getCurrentTree();
            return String.format("Древо %s создано", this.activeTree.toString());
        } catch (Exception e) {
            this.activeTree = null;
            System.out.println(e);
            return "Ошибка создания";
        }
        
    }


    @Override
    public String showActiveTreeInfo() {
        if (this.activeTree == null){
            return "Древа не существует";
        }
        return activeTree.getInfo();
    }


    @Override
    public String loadTree() {
        System.out.println(String.format("Уккажите путь к файлу. (По умолчанию %s)", this.view.getPath()));
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        scanner.close();
        Path file = Paths.get(path);
        if (Files.exists(file)){           
                String s = fileLoad(path);
                return s;            
        } else {
            System.out.println("Файл не существует, используем путь по умолчанию");
            String s = fileLoad(this.view.getPath());
            return s;
        }
        
    }
    private String fileLoad(String value){
        try{ 
            service.loadTree(value);
            this.view.setPath(value);
            return String.format("Древо %s загружено", activeTree.toString());
        }catch (Exception e){
            System.out.println(e);
            return "Ошибка загрузки";
        }
    }
    @Override
    public void setActiveTree(Family_tree<Human> tree) {
        this.service.setCurrentTree(tree);
        this.activeTree = tree;
    }   

}
