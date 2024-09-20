package io.github.loulangogogo.mode_23.test11;

/*********************************************************
 ** 中介者模式的测试
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
public class TestZJZ {
    public static void main(String[] args) {
        ConcreteMediator concreteMediator = new ConcreteMediator();
        ConcreteColleague1 c1 = new ConcreteColleague1(concreteMediator);
        ConcreteColleague2 c2 = new ConcreteColleague2(concreteMediator);

        concreteMediator.setC1(c1);
        concreteMediator.setC2(c2);

        c1.outBusiness1();
        c2.outBusiness2();
    }
}

/*********************************************************
 ** 中介者抽象类
 **
 ** @author loulan
 ** @since
 *********************************************************/
abstract class Mediator {
    protected ConcreteColleague1 c1;
    protected ConcreteColleague2 c2;

    public ConcreteColleague1 getC1() {
        return c1;
    }

    public void setC1(ConcreteColleague1 c1) {
        this.c1 = c1;
    }

    public ConcreteColleague2 getC2() {
        return c2;
    }

    public void setC2(ConcreteColleague2 c2) {
        this.c2 = c2;
    }

    public abstract void doSomething1();
    public abstract void doSomething2();
}

/*********************************************************
 ** 中介者实现类
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class ConcreteMediator extends Mediator {
    @Override
    public void doSomething1() {
        super.c1.business1();
        super.c2.business2();
    }

    @Override
    public void doSomething2() {
        super.c1.business1();
        super.c2.business2();
    }
}

/*********************************************************
 ** 同事抽象类
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}

class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void business1() {
        // 业务逻辑
    }

    public void outBusiness1() {
        // 业务逻辑
        // 委托中介处理的业务
        super.mediator.doSomething1();
    }
}


class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void business2() {
        // 业务逻辑
    }

    public void outBusiness2() {
        // 业务逻辑
        // 委托中介处理的业务
        super.mediator.doSomething2();
    }
}