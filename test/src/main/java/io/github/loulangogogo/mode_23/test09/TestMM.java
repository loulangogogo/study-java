package io.github.loulangogogo.mode_23.test09;

/*********************************************************
 ** 测试门面模式
 ** <br><br>
 ** Date: Created in 2024/8/16 09:10
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestMM {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doSomethingA();
        facade.doSomethingB();
        facade.doSomethingC();
    }
}

/**
 * 门面对象类
 * @param
 * @return
 * @exception
 * @author     :loulan
 * */
class Facade{
    private A a;
    private B b;
    private C c;

    public Facade(){
        a = new A();
        b = new B();
        c = new C();
    }

    public void doSomethingA(){
        a.doSomethingA();
    }

    public void doSomethingB(){
        b.doSomethingB();
    }

    public void doSomethingC(){
        c.doSomethingC();
    }
}


class A{
    public void doSomethingA(){
        System.out.println("A");
    }
}

class B{
    public void doSomethingB(){
        System.out.println("B");
    }
}

class C{
    public void doSomethingC(){
        System.out.println("C");
    }
}
