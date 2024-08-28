package io.github.loulangogogo.test11;

/*********************************************************
 ** 策略模式测试
 ** 
 ** @author loulan
 ** @since 
 *********************************************************/
public class TestCL {
    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategyA();
        Context context = new Context(strategy);
        context.doSomething();
    }
}

/*********************************************************
 ** 封装角色
 ** 
 ** @author loulan
 ** @since 8
 *********************************************************/
class Context {
    private Strategy strategy;
    
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public void doSomething() {
        this.strategy.doSomething();
    }
}

/*********************************************************
 ** 策略模式接口
 ** 
 ** @author loulan
 ** @since 8
 *********************************************************/
interface Strategy {
    // 策略模式运算法则
    public void doSomething();    
}

/*********************************************************
 ** 策略算法实现
 ** 
 ** @author loulan
 ** @since 8
 *********************************************************/
class ConcreteStrategyA implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("策略A");
    }
}

/*********************************************************
 ** 策略算法实现
 ** 
 ** @author loulan
 ** @since 8
 *********************************************************/
class ConcreteStrategyB implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("策略B");
    }
}
