package io.github.loulangogogo.mode_23.test04;

/*********************************************************
 ** 测试单例模式懒汉式
 ** <br><br>
 ** Date: Created in 2024/7/18 09:20
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestSingleLH {

    private static TestSingleLH testSingleLH = null;

    // 先将构造方法私有化
    private TestSingleLH(){}

    // 获取单利对象
    public static synchronized TestSingleLH getInstance() {
        if (testSingleLH == null) {
            testSingleLH = new TestSingleLH();
        }
        return testSingleLH;
    }
}
