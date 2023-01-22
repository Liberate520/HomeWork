package View.Buttons;

import View.View;

public class PrintContainer extends MenuButton{
    String buttonName = "Показать несохраненные данные";
    View view;

    public PrintContainer(View view) {
        this.view = view;
    }

    public void onClick(){
        view.CallPrintContainer();
    }

    @Override
    public String toString() {
        return buttonName;
    }
}
