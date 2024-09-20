package io.github.loulangogogo.mode_23.test02;

/*********************************************************
 ** 测试依赖倒置原则
 ** <br><br>
 ** Date: Created in 2024/7/14 22:47
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestYL {

    public static void main(String[] args) {
        Isolider solider = new LuSolider();
        solider.killEnemy(new AK47());
        solider.killEnemy(new AUG());
    }
}

/*********************************************************
 ** AUG狙击枪实现类
 ** <br><br>
 ** Date: Created in 2024/7/14 23:01
 ** @author loulan
 ** @version 0.0.0‘
 *********************************************************/
class AUG implements Igun{

    @Override
    public void shoot() {
        System.out.println("AUG shoot");
    }
}

/*********************************************************
 ** 定义一个枪的接口
 ** <br><br>
 ** Date: Created in 2024/7/14 22:47
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface Igun{

    // 枪的设计功能
    public void shoot();
}

/*********************************************************
 ** 定义一个士兵接口
 ** <br><br>
 ** Date: Created in 2024/7/14 22:48
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface Isolider{
    // 使用武器射杀敌人
    public void killEnemy(Igun gun);
}

/*********************************************************
 ** 定义一个AK47
 ** <br><br>
 ** Date: Created in 2024/7/14 22:51
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class AK47 implements Igun{
    @Override
    public void shoot() {
        System.out.println("AK47 shoot");
    }
}

/*********************************************************
 ** 定义一个陆军
 ** <br><br>
 ** Date: Created in 2024/7/14 22:51
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class LuSolider implements Isolider{
    @Override
    public void killEnemy(Igun gun) {
        gun.shoot();
    }
}
