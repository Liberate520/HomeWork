package Family_tree.View;

import java.util.*;

import Family_tree.Model.Humans.Human;
import Family_tree.Presenter.HumanPresenter;
import Family_tree.Presenter.Presenter;

public class HumanView extends View<Human> {
    private HumanPresenter presenter;    
    static String optionString = """
            Выбор действия:
            \t 1. Создать древо;
            \t 2. Загрузить древо;
            \t 3. Сохранить древо;
            \t 4. Выбрать древо;
            \t 5. удалить древо;
            \t 6. Добавить родича;
            \t 7. Удалить родича;
            \t 8. Зарегистрировать брак;
            \t 9. Зарегистрировать ребёнка;
            \t s. Найти родича;
            \t i. Информация о родиче;
            \t l. Список древ;
            \t v. Список родичей;
            \t q. Выход.
            """;
    private Scanner scanner ;
    public HumanView(){
        presenter = new HumanPresenter(this); 
        scanner = new Scanner(System.in)  ;    
    }
    @Override
    public void start() {
        System.out.println(optionString);
        boolean flag = true;
        while (flag) {
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    System.out.println("Укажите фамилию");
                    String family = scanner.nextLine();
                    String result = presenter.createActiveTree(family);
                    System.out.println(result);
                    break;
                case "2":
                    System.out.println("Укажите путь");
                    String filePath = scanner.nextLine();
                    System.out.println(presenter.loadTree(filePath));
                    break;
                case "3":
                    if (this.hasActiveTree() == false){
                        System.out.println("Невыбрано активное древо");
                        break;
                    }
                    System.out.println("Укажите путь");
                    String savePath = scanner.nextLine();
                    System.out.println(presenter.saveTree(savePath));
                    break;
                case "4":
                    System.out.println("Выбор древа");
                    if (presenter.getTreeList().isEmpty()){
                        System.out.println("Список пуст");
                        break;
                    }
                    System.out.println("Укажите номер");
                    System.out.println(presenter.showListTree());
                    int selected = Integer.parseInt(scanner.nextLine());
                    System.out.println(presenter.selectTree(selected));
                    break;
                case "5":
                    System.out.println("Укажите номер");
                    System.out.println(presenter.showListTree());
                    int deleted = Integer.parseInt(scanner.nextLine());
                    System.out.println(presenter.removeTree(deleted));
                    break;
                case "l":                    
                    System.out.println(presenter.showListTree());                    
                    break;
                case "6":
                    
                    break;
                case "7":
                    
                    break;
                case "8":
                    
                    break;
                case "9":
                    
                    break;
                case "s":
                    
                    break;
                case "i":
                    
                    break;
                case "v":
                    
                    break;
                case "q":
                    flag = false;   
                    break;
                default:
                    break;
            }
        }
    }

    

  
    @Override
    public Presenter<Human> getPresenter() {
        return this.presenter;
    }
   
   
}
