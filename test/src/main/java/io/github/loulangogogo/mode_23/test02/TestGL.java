package io.github.loulangogogo.mode_23.test02;

/*********************************************************
 ** 测试接口隔离原则
 ** <br><br>
 ** Date: Created in 2024/7/15 11:47
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestGL {
    public static void main(String[] args) {
        AbstractTeacher articleTeacher = new ArticleTeacher(new GoodArticel());
        articleTeacher.read();
    }
}

/*********************************************************
 ** 定义一个阅读文章的老师
 ** <br><br>
 ** Date: Created in 2024/7/15 11:57
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class ArticleTeacher extends AbstractTeacher{
    public ArticleTeacher(IgoodArticel igoodArticel) {
        super(igoodArticel);
    }

    @Override
    public void read() {
        super.igoodArticel.goodFont();
        super.igoodArticel.goodTitle();
        super.igoodArticel.goodContent();
    }
}


/*********************************************************
 ** 定义一个好文章的实现类
 ** <br><br>
 ** Date: Created in 2024/7/15 11:53
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class GoodArticel implements IgoodArticel{

    @Override
    public void goodFont() {
        System.out.println("好字体");
    }

    @Override
    public void goodTitle() {
        System.out.println("好标题");
    }

    @Override
    public void goodContent() {
        System.out.println("好内容");
    }
}

/*********************************************************
 ** 定义一个接口限制说明是好文章
 ** <br><br>
 ** Date: Created in 2024/7/15 11:49
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface IgoodArticel extends IcomputerGoodArticle{

    // 要有好看的字体
    public void goodFont();

}

/*********************************************************
 ** 电脑好文章的判断标准
 ** <br><br>
 ** Date: Created in 2024/7/15 13:59
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface IcomputerGoodArticle {
    // 要有好的标题
    public void goodTitle();
    // 要有好的内容
    public void goodContent();
}

/*********************************************************
 ** 定义一个发现好文章的抽象老师
 ** <br><br>
 ** Date: Created in 2024/7/15 11:55
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
abstract class AbstractTeacher {
    protected IgoodArticel igoodArticel;

    public AbstractTeacher(IgoodArticel igoodArticel) {
        this.igoodArticel = igoodArticel;
    }


    // 阅读发现好文章
    public abstract void read();
}
