package io.github.loulangogogo.mode_23.test06;

/*********************************************************
 ** 建造者模式的测试
 ** <br><br>
 ** Date: Created in 2024/7/25 22:14
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestJZZ {

    public static void main(String[] args) {
        Director director = new Director();
        Product product = director.getAProduct();
    }
}

/*********************************************************
 ** 导演类
 ** <br><br>
 ** Date: Created in 2024/7/25 22:20
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class Director{
    private Builder builder = new ConcreteBuilder();

    public Product getAProduct() {
        builder.buildProduct();
        /*
        * 设置不同的零件，产生不同的产品
        * */
        return builder.buildProduct();
    }
}

/*********************************************************
 ** 具体的建造者
 ** <br><br>
 ** Date: Created in 2024/7/25 22:18
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ConcreteBuilder extends Builder{
    private Product product = new Product();

    @Override
    public void setPart() {
        // 设置不同零件，进行逻辑处理
    }

    @Override
    public Product buildProduct() {
        return product;
    }
}


/*********************************************************
 ** 抽象建造者
 ** <br><br>
 ** Date: Created in 2024/7/25 22:17
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
abstract class Builder{
    // 设置产品的不同部分，以获得不同的产品
    public abstract void setPart();

    // 建造产品
    public abstract Product buildProduct();
}

/*********************************************************
 ** 产品类
 ** <br><br>
 ** Date: Created in 2024/7/25 22:15
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class Product{
    public void doSomething() {

    }
}


