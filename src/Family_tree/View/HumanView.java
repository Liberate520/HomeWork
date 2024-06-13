package Family_tree.View;

import java.time.LocalDate;
import java.util.*;

import Family_tree.Model.Humans.Gender;
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
            \t h. Список команд;
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
                    System.out.println("ФИО");
                    String FIO = scanner.nextLine();
                    System.out.println("пол (м/ж)");
                    Gender gender = sexFromString(scanner.nextLine());
                    System.out.println("Дата рождения (гггг-ММ-ДД)");
                    LocalDate day = LocalDate.parse(scanner.nextLine());
                    Human human = newHuman(FIO, gender, day);
                    System.out.println(addToTree(human));
                    break;
                case "7":
                    System.out.println("Укажите индекс");
                    System.out.println(presenter.showListTree());
                    int index = Integer.parseInt(scanner.nextLine());
                    try{
                        presenter.removeMember(index);
                        System.out.println("Родич удалён");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
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
                case "h":
                    System.out.println(optionString);   
                    break;
                default:
                    break;
            }
        }
    }

    private Gender sexFromString(String value){
        if (value.equalsIgnoreCase("м")){
            return Gender.Male;            
        } else if (value.equalsIgnoreCase("ж")){
            return Gender.Female;
        } else {
            return null;
        }
    }

  
    @Override
    public Presenter<Human> getPresenter() {
        return this.presenter;
    }
    @Override
    public String addToTree(Human value) {

        try {
            presenter.getActiveTree().add(value);
            return String.format("%s добавлен(а)", value.toString());
        } catch (Exception e) {
            System.out.println(e);
            return "Ошибка записи";
        }
    }
    private Human newHuman(String nane, Gender gender, LocalDate birthDate){
        return presenter.newHuman(nane, gender, birthDate);
    }
   
}
