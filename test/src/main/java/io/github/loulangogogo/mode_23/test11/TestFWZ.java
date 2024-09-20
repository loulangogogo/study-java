package io.github.loulangogogo.mode_23.test11;

import java.util.Random;

/*********************************************************
 ** 访问者模式测试
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
public class TestFWZ {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Element el = ObjectStructure.createElement();
            el.accept(new ConcreteVisitor());
        }
    }
}

/*********************************************************
 ** 结构对象，使用工厂方法模式来模拟
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class ObjectStructure{

    public static Element createElement() {
        Random random = new Random();
        if (random.nextInt(100) > 50) {
            return new ConcreteElementA();
        } else {
            return new ConcreteElementB();
        }
    }
}

/*********************************************************
 ** 访问者
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class ConcreteVisitor implements IVisitor{
    @Override
    public void visit(ConcreteElementA element) {
        element.doSomething();
    }

    @Override
    public void visit(ConcreteElementB element) {
        element.doSomething();
    }
}

/*********************************************************
 ** 访问者
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
interface IVisitor{
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}

/*********************************************************
 ** 具体元素A
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class ConcreteElementA implements Element{
    @Override
    public void doSomething() {
        System.out.println("ConcreteElementA");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

/*********************************************************
 ** 具体元素B
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class ConcreteElementB implements Element{
    @Override
    public void doSomething() {
        System.out.println("ConcreteElementB");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}


/*********************************************************
 ** 抽象元素
 **
 ** @author loulan
 ** @since
 *********************************************************/
interface Element{
    // 定义业务逻辑
    public void doSomething();

    // 允许谁来访问
    public void accept(IVisitor visitor);
}


