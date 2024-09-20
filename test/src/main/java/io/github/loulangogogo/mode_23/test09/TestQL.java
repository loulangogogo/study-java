package io.github.loulangogogo.mode_23.test09;

/*********************************************************
 ** 桥梁模式测试
 ** <br><br>
 ** Date: Created in 2024/8/19 18:09
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestQL {
    public static void main(String[] args) {
        Corp corp = new CorpA(new ProductA());
        corp.makeMoney();
    }
}

/*********************************************************
 ** 定义一个A公司
 ** <br><br>
 ** Date: Created in 2024/8/19 18:15
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class CorpA extends Corp{
    public CorpA(Iproduct product) {
        super(product);
    }

    public void makeMoney(){
        super.makeMoney();
    }
}

/*********************************************************
 ** 公司用产品是赚钱的
 ** <br><br>
 ** Date: Created in 2024/8/19 18:14
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
abstract class Corp{
    private Iproduct product;
    
    public Corp(Iproduct product) {
        this.product = product;
    }

    public void makeMoney(){
        this.product.color();
        this.product.use();
    }
}


/*********************************************************
 ** 产品实现类
 ** <br><br>
 ** Date: Created in 2024/8/19 18:11
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ProductA implements Iproduct{
    @Override
    public void color() {
        System.out.println("ProductA color");
    }

    @Override
    public void use() {
        System.out.println("ProductA use");
    }
}


/*********************************************************
 ** 抽象产品类
 ** <br><br>
 ** Date: Created in 2024/8/19 18:10
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface Iproduct{
    void color();

    void use();
}