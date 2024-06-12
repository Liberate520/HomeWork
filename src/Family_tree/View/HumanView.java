package Family_tree.View;

import java.util.*;

import Family_tree.Model.Humans.Human;
import Family_tree.Presenter.HumanPresenter;
import Family_tree.Presenter.Presenter;

public class HumanView extends View<Human> {
    private HumanPresenter presenter;
    private boolean flag;
    private Scanner sc;
    private String path;
    public HumanView(){
        presenter = new HumanPresenter(this);
        sc = new Scanner(System.in);
        path = "mine.tree";
    }
    @Override
    public void start() {
        step1();
    }
    @Override
    public Presenter<Human> getPresenter() {
        return this.presenter;
    }
    

    private void step1(){
        String s = """
            Для начала, Вы должны выбрать, создать или загрузить древо. \n Ваш выбор:
            \t 1 Создать древо;
            \t 2 Загрузить древо;
            \t 3 Выбрать из списка имеющихся;
            \t q Выход.
            """ ;
            System.out.println(s);
            flag = true;            
            while (flag) {
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println(presenter.createActiveTree());                        
                        flag = !checkActive();
                        break;
                    case "2":
                        System.out.println(presenter.loadTree());
                        flag = !checkActive();
                        break;
                    case "3":
                        System.out.println(choiseTree());
                        flag = !checkActive();
                        System.out.println(flag);
                        break;
                    case "q":
                        this.exit();
                    default:
                        break;
                }                
            } 
            step2();                 
    }
    private String choiseTree(){
        System.out.println("Укажите номер древа:");
        if (presenter.getTreeList().isEmpty()){
            return "Не из чего выбирать";
        }
        System.out.println(presenter.showListTree());
        boolean choosen = true;
        while (choosen) {
            int number = Integer.parseInt(sc.nextLine());           
            if (number < 0 || number > presenter.getTreeList().size()){
                System.out.println("Вне ранга, повторите попытку");
            } else {
                try{
                    presenter.setActiveTree(presenter.selectTree(number));
                    choosen = false;
                    return String.format("Выбрано древо %s", presenter.getActiveTree().toString());                    
                } catch (Exception e){
                    System.out.println(e);
                    return "Ошибка выбора";
                }                
            }
        }
        return "Ошибка выбора";
    }

    private void step2(){
        System.out.println("in progress");
    }
    @Override
    public String getPath() {
        return this.path;
    }
    @Override
    public void setPath(String value) {
        this.path = value;
    }
    private boolean checkActive(){
        if (presenter.getActiveTree() != null) {
            return true;
        }
        return false;
    }

}
