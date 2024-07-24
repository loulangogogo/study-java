package io.github.loulangogogo.test05;

public class TestCXGZ {
    public static void main(String[] args) {
        // 第一个工厂生产圆形产品
        ProductFactory roundProductFactory = new RoundProductFactory();
        // 第二个工厂生产方形产品
        ProductFactory squareProductFactory = new QuareProductFactory();

        // 产品生产工厂建立完毕开始生产产品
        IProduct productA = roundProductFactory.createProductA();
        IProduct productB = roundProductFactory.createProductB();
        productA.something();
        productA.shape();
        System.out.println();
        productB.something();
        productB.shape();
        System.out.println();

        IProduct squareProductFactoryProductA = squareProductFactory.createProductA();
        IProduct squareProductFactoryProductB = squareProductFactory.createProductB();
        squareProductFactoryProductA.something();
        squareProductFactoryProductA.shape();
        System.out.println();
        squareProductFactoryProductB.something();
        squareProductFactoryProductB.shape();
    }
}


/*********************************************************
 ** 定义一个方形产品的生产工厂
 ** <br><br>
 ** Date: Created in 2024/7/19 11:59
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class QuareProductFactory implements ProductFactory {
    @Override
    public ProductA createProductA() {
        return new QuareProductA();
    }

    @Override
    public ProductB createProductB() {
        return new QuareProductB();
    }
}

/*********************************************************
 ** 定义一个圆形产品生产工厂
 ** <br><br>
 ** Date: Created in 2024/7/19 11:57
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class RoundProductFactory implements ProductFactory {
    @Override
    public ProductA createProductA() {
        return new RoundProductA();
    }

    @Override
    public ProductB createProductB() {
        return new RoundProductB();
    }
}

/*********************************************************
 ** 定义一个产品生产共产的接口
 ** <br><br>
 ** Date: Created in 2024/7/19 11:57
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface ProductFactory {

    public ProductA createProductA();

    public ProductB createProductB();
}

/*********************************************************
 ** 定义一个方形的B产品
 ** <br><br>
 ** Date: Created in 2024/7/19 11:54
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class QuareProductB extends ProductB {

    @Override
    public void shape() {
        System.out.println("我是方形的");
    }
}

/*********************************************************
 ** 定义圆形的B产品
 ** <br><br>
 ** Date: Created in 2024/7/19 11:54
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class RoundProductB extends ProductB {

    @Override
    public void shape() {
        System.out.println("我是圆形的");
    }
}

/*********************************************************
 ** 定义一个方形的A产品
 ** <br><br>
 ** Date: Created in 2024/7/19 11:54
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class QuareProductA extends ProductA {

    @Override
    public void shape() {
        System.out.println("我是方形的");
    }
}

/*********************************************************
 ** 定义圆形的A产品
 ** <br><br>
 ** Date: Created in 2024/7/19 11:54
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class RoundProductA extends ProductA {

    @Override
    public void shape() {
        System.out.println("我是圆形的");
    }
}

/*********************************************************
 ** 定义一个产品B抽象类
 ** <br><br>
 ** Date: Created in 2024/7/18 15:52
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
abstract class ProductB implements IProduct {
    @Override
    public void something() {
        System.out.println("我就是个B产品");
    }
}

/*********************************************************
 ** 定义一个A产品抽象类
 ** <br><br>
 ** Date: Created in 2024/7/18 15:52
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
abstract class ProductA implements IProduct {
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

    // 产品描述
    public void something();

    // 产品形状
    public void shape();
}
