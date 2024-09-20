package io.github.loulangogogo.mode_23.test07;

/*********************************************************
 ** 测试模版方法模式
 ** <br><br>
 ** Date: Created in 2024/8/8 19:50
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestMB {
    public static void main(String[] args) {
        AbstractClass a = new ConcreteClassA();
        AbstractClass b = new ConcreteClassB();
        // 使用模版方法
        a.templateMethod();
        b.templateMethod();
    }
}

/*********************************************************
 ** 抽象模版累
 ** <br><br>
 ** Date: Created in 2024/8/8 19:53
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
abstract class AbstractClass {
    public void templateMethod() {
        // 模版方法
        this.primitiveOperation1();
        this.primitiveOperation2();
    }

    protected abstract void primitiveOperation1();

    protected abstract void primitiveOperation2();
}

/*********************************************************
 ** 抽象模版类的实现类
 ** <br><br>
 ** Date: Created in 2024/8/8 19:53
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ConcreteClassA extends AbstractClass {
    @Override
    protected void primitiveOperation1() {
        System.out.println("具体类A的方法1实现");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("具体类A的方法2实现");
    }
}

/*********************************************************
 ** 抽象模版类的实现类
 ** <br><br>
 ** Date: Created in 2024/8/8 19:53
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ConcreteClassB extends AbstractClass {
    @Override
    protected void primitiveOperation1() {
        System.out.println("具体类B的方法1实现");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("具体类B的方法2实现");
    }
}
