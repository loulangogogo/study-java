package io.github.loulangogogo.test12;

/*********************************************************
 ** 状态模式测试
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
public class TestZT {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteState1());
        context.request1();
        context.request2();
    }
}

/*********************************************************
 ** 环境juese
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class Context {
    public final static State STATE1 = new ConcreteState1();
    public final static State STATE2 = new ConcreteState2();
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        this.state.setContext(this);
    }

    public void request1() {
        this.state.handle1();
    }

    public void request2() {
        this.state.handle2();
    }

}

/*********************************************************
 ** 具体状态juese
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class ConcreteState1 extends State {

    @Override
    public void handle1() {
        // TODO Auto-generated method stub
        System.out.println("state1-1");

    }

    @Override
    public void handle2() {
        System.out.println("state1-2");
        // TODO Auto-generated method stub
        super.context.setState(Context.STATE2);
        super.context.request2();
    }

}

class ConcreteState2 extends State {

    @Override
    public void handle1() {
        System.out.println("state2-1");
        // TODO Auto-generated method stub
        super.context.setState(Context.STATE1);
        super.context.request1();

    }

    @Override
    public void handle2() {
        System.out.println("state2-2");
        // TODO Auto-generated method stub

    }

}

/*********************************************************
 ** 抽象状态juese
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
abstract class State {

    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void handle1();
    public abstract void handle2();
}
