package io.github.loulangogogo.test08;

/*********************************************************
 ** 测试适配器模式
 ** <br><br>
 ** Date: Created in 2024/8/13 10:40
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestSPQ {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.anyThing();

        Target target1 = new Adapter(new ConcreteSource());
        target1.anyThing();
    }
}

/*********************************************************
 ** 定义一个适配器，将目标角色适配到源角色上
 ** <br><br>
 ** Date: Created in 2024/8/13 10:44
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class Adapter extends ConcreteTarget {
    private Source source = null;

    public Adapter(Source _source) {
        this.source = _source;
    }

    @Override
    public void anyThing() {
        this.source.someThing();
    }
}

/*********************************************************
 ** 目标角色的实现类
 ** <br><br>
 ** Date: Created in 2024/8/13 10:42
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ConcreteTarget implements Target{
    @Override
    public void anyThing() {
        System.out.println("anyThing");
    }
}

/*********************************************************
 ** 目标角色接口
 ** <br><br>
 ** Date: Created in 2024/8/13 10:42
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface Target{
    public void anyThing();
}

/*********************************************************
 ** 源角色实现类
 ** <br><br>
 ** Date: Created in 2024/8/13 10:41
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ConcreteSource implements Source{
    @Override
    public void someThing() {
        System.out.println("someThing");
    }
}

/*********************************************************
 ** 源角色接口
 ** <br><br>
 ** Date: Created in 2024/8/13 10:41
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface Source{
    public void someThing();
}
