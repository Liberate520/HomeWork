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
    public String createActiveTree(String value) {        
        try{
            service.addTree(value);
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
    public void setActiveTree(Family_tree<Human> tree) {
        this.service.setCurrentTree(tree);
        this.activeTree = tree;
    }
    @Override
    public String loadTree(String path) {
        Family_tree<Human> tree;
        Path file = Paths.get(path);
        if (Files.exists(file)){
            try {
                tree = service.loadTree(path);
                return String.format("Древо %s загружено", tree.toString());
            } catch (Exception e){
                System.out.println(e);
                return "Ошибка чтения";
            }
        } else {
            return "Файл не найден";
        }
    }
    @Override
    public String saveTree(String path) {
       if(service.saveTree(path)){
        return "Сохранено";
       }else{
        return "Ошибка сохранения";
       }
    }   

}
