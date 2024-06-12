package Family_tree.View;

import Family_tree.Model.Humans.Human;
import Family_tree.Presenter.HumanPresenter;
import Family_tree.Presenter.Presenter;

public class HumanView extends View<Human> {
    private HumanPresenter presenter;
    public HumanView(){
        presenter = new HumanPresenter();
    }
    @Override
    public void start() {
        
    }
    @Override
    public Presenter<Human> getPresenter() {
        return this.presenter;
    }

    private void step1(){
        System.out.println("Для начала, Вы должны выбрать, создать или загрузить древо. \n Ваш выбор.");
    }

}
