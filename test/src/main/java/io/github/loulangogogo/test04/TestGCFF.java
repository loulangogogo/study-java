package io.github.loulangogogo.test04;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/*********************************************************
 ** 测试工厂方法模式
 ** <br><br>
 ** Date: Created in 2024/7/18 15:51
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestGCFF {

    public static void main(String[] args) {
        ProductA productA = ProductCreator.createProduct(ProductA.class);
        productA.something();
        ProductB productB = ProductCreator.createProduct(ProductB.class);
        productB.something();
    }
}

/*********************************************************
 ** 定义一个产品工厂
 ** <br><br>
 ** Date: Created in 2024/7/18 15:58
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ProductCreator {

    public static <T extends IProduct> T createProduct(Class<T> clzz) {
        try {
            return clzz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

/*********************************************************
 ** 工厂方法和单例模式的结合使用
 ** <br><br>
 ** Date: Created in 2024/7/18 16:19
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class SingleFactory{
    private static ProductC productC;

    static {
        try {
            productC = ProductC.class.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    // 获取单例对象
    public static ProductC productAInstance() {
        return productC;
    }
}


/*********************************************************
 ** 将产品对象都保存再缓冲中，然后通过缓冲来进行获取对象数据的方式。
 ** <br><br>
 ** Date: Created in 2024/7/18 16:30
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class SingleFactory2 {
    private static final Map<String,IProduct> map = new HashMap<>();

    public static <T extends IProduct> T getInstance(Class<T> clzz) {
        String key = clzz.getName();
        if (map.containsKey(key)) {
            return (T) map.get(key);
        }else {
            try {
                T instance = clzz.getDeclaredConstructor().newInstance();
                map.put(key,instance);
                return instance;
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            }  catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


/*********************************************************
 ** 定义一个C产品
 ** <br><br>
 ** Date: Created in 2024/7/18 16:21
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ProductC implements IProduct {

    // 将构造方法私有化
    private ProductC(){}

    @Override
    public void something() {
        System.out.println("我就是个C产品");
    }
}


/*********************************************************
 ** 定义一个产品B
 ** <br><br>
 ** Date: Created in 2024/7/18 15:52
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ProductB implements IProduct {
    @Override
    public void something() {
        System.out.println("我就是个B产品");
    }
}

/*********************************************************
 ** 定义一个A产品
 ** <br><br>
 ** Date: Created in 2024/7/18 15:52
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ProductA implements IProduct {


    @Override
    public void something() {
        System.out.println("我就是个A产品");
    }
}

/*********************************************************
 ** 定义一个产品接口
 ** <br><br>
 ** Date: Created in 2024/7/18 15:51
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface IProduct {

    public void something();
}