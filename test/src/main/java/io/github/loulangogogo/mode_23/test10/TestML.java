package io.github.loulangogogo.mode_23.test10;

/*********************************************************
 ** 命令模式测试类
 ** <br><br>
 ** Date: Created in 2024/8/21 10:42
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestML {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        // 定义一个命令接受者
        Receiver receiver = new ConcreteReceiver();
        // 定义一个命令
        ConcreteCommand command = new ConcreteCommand(receiver);
        // 调用者发送命令
        invoker.setCommand(command);
        invoker.action();
    }
}

/*********************************************************
 ** 命令发起人
 ** <br><br>
 ** Date: Created in 2024/8/21 10:44
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class Invoker{
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action(){
        this.command.execute();
    }
}

/*********************************************************
 ** 命令处理类
 ** <br><br>
 ** Date: Created in 2024/8/21 10:45
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.doSomething();
    }
}

/*********************************************************
 ** 命令接口
 ** <br><br>
 ** Date: Created in 2024/8/21 10:44
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface Command {
    void execute();
}

/*********************************************************
 ** 命令接受人
 ** <br><br>
 ** Date: Created in 2024/8/21 10:44
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ConcreteReceiver implements Receiver {
    @Override
    public void doSomething() {
        System.out.println("Receiver doSomething");
    }
}

/*********************************************************
 ** 命令接受接口
 ** <br><br>
 ** Date: Created in 2024/8/21 10:43
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface Receiver {
    void doSomething();
}
