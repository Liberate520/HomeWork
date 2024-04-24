package homeWork.view.command;

import homeWork.view.Console;

public class Finish extends Command{
    public Finish(Console console) {
        super("Закончить работу", console);
    }

    public void execute(){
        console.finish();
    }
}
