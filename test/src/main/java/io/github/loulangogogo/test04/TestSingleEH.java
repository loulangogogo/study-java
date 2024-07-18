package io.github.loulangogogo.test04;

/*********************************************************
 ** 测试单例模式饿汉式
 ** <br><br>
 ** Date: Created in 2024/7/18 09:14
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestSingleEH {

    // 创建静态常量
    private static final TestSingleEH testSingleEH = new TestSingleEH();

    // 将构造方法私有化
    private TestSingleEH(){}

    // 获取单例对象
    public static TestSingleEH getInstance(){
        return testSingleEH;
    }
}
