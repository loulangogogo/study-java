package io.github.loulangogogo.test09;

import java.util.HashMap;

/*********************************************************
 ** 享元模式测试类
 ** <br><br>
 ** Date: Created in 2024/8/19 16:11
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestXY {
    public static void main(String[] args) {
        FlyWeight flyWeight = ConcreteFlyWeightFactory.getFlyWeight("123");
        flyWeight.operation();
    }
}

/*********************************************************
 ** 享元对象工厂
 ** <br><br>
 ** Date: Created in 2024/8/19 16:18
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ConcreteFlyWeightFactory{

    // 享元池
    private static HashMap<String, FlyWeight> pool = new HashMap<>();

    // 获取享元对象
    public static FlyWeight getFlyWeight(String key){
        FlyWeight flyWeight = null;
        if (pool.containsKey(key)) {
            return pool.get(key);
        } else {
            flyWeight = new ConcreteFlyWeight();
            pool.put(key, flyWeight);
        }

        return flyWeight;
    }
}


/*********************************************************
 ** 享元对象实现类
 ** <br><br>
 ** Date: Created in 2024/8/19 16:13
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ConcreteFlyWeight implements FlyWeight{

    private String key;

    @Override
    public void operation() {
        System.out.println("我是享元对象");
    }
}

/*********************************************************
 ** 享元对象接口
 ** <br><br>
 ** Date: Created in 2024/8/19 16:12
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface FlyWeight{
    void operation();
}