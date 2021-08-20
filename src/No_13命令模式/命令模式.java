package No_13命令模式;

import java.util.ArrayList;
import java.util.List;

public class 命令模式 {
    public static void main(String[] args) {

        SaveCommandList saveCommandList = new SaveCommandList();
        saveCommandList.addCommand(  new PrintCommand("命令模式1"));
        saveCommandList.addCommand(  new PrintCommand("命令模式2"));
        saveCommandList.addCommand(  new PrintCommand("命令模式3"));
        saveCommandList.execute();
    }
}
interface Command{
    void execute();
}
class PrintCommand implements Command{
    private String string;

    public PrintCommand(String string) {
        this.string = string;
    }

    @Override
    public void execute() {
        System.out.println(string);
    }
}
class SaveCommandList {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }
    public void execute(){
        commands.forEach(Command::execute);
    }

}
