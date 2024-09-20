package io.github.loulangogogo.mode_23.test08;

/*********************************************************
 ** 测试装饰模式
 ** <br><br>
 ** Date: Created in 2024/8/12 10:58
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestZS {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        // 进行装饰
        component = new ConcreteDecorator(component);
        component.doSomething();
    }
}

/*********************************************************
 ** 装饰角色的实现类
 ** <br><br>
 ** Date: Created in 2024/8/12 11:04
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ConcreteDecorator extends Decorator{
    public ConcreteDecorator(Component _component) {
        super(_component);
    }

    private void myMethod() {
        System.out.println("装饰器自己的方法");
    }

    @Override
    public void doSomething() {
        this.myMethod();
        super.doSomething();
    }
}

/*********************************************************
 ** 装饰角色的抽象类
 ** <br><br>
 ** Date: Created in 2024/8/12 11:02
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
abstract class Decorator extends Component{
    private Component component;
    public Decorator(Component _component) {
        this.component = _component;
    }

    @Override
    public void doSomething() {
        this.component.doSomething();
    }
}

/*********************************************************
 ** 构件实现类
 ** <br><br>
 ** Date: Created in 2024/8/12 11:01
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ConcreteComponent extends Component{
    @Override
    public void doSomething() {
        System.out.println("执行一些逻辑");
    }
}

/*********************************************************
 ** 抽象组件构件
 ** <br><br>
 ** Date: Created in 2024/8/12 11:00
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
abstract class Component{
    public abstract void doSomething();
}
