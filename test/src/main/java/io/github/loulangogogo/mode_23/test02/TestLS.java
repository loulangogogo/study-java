package io.github.loulangogogo.mode_23.test02;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*********************************************************
 ** 测试里氏替换原则
 ** <br><br>
 ** Date: Created in 2024/7/13 15:39
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestLS {

    public static void main(String[] args) {
        Party party = new Party();
        party.setUser(new Student());
        party.startEat();
    }

    // 食物
    ArrayList<String> listFood = new ArrayList<>();

    // 食物准备
    @Before
    public void before() {
        listFood.add("鲍鱼");
        listFood.add("龙虾");
        listFood.add("火锅");
    }

    // 测试朋友类
    @Test
    public void testFriend() {
        Friend friend = new Friend();
        friend.eat(listFood); // 朋友吃了 鲍鱼,龙虾,火锅
    }

    // 测试朋友子类学生类
    @Test
    public void testStudent() {
        Student student = new Student();
        student.eat(listFood);// 输出结果 ：学生吃了 鲍鱼,龙虾,火锅
    }
}

/*********************************************************
 ** 朋友的子类学生类
 ** <br><br>
 ** Date: Created in 2024/7/13 17:03
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class Student extends Friend {
    public List<String> eat(ArrayList<String> listFood) {
        if (null == listFood || listFood.size() == 0) {
            System.out.println("学生什么都没有吃到");
            return List.of("饿", "没意思");
        } else {
            String foodNames = listFood.stream().collect(Collectors.joining(","));
            System.out.println("学生吃了 " + foodNames);
            return List.of("不错", "好吃");
        }
    }
}

/*********************************************************
 ** 一个聚会实现类
 ** <br><br>
 ** Date: Created in 2024/7/13
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class Party {

    private Iuser user;

    // 设置聚会的人
    public void setUser(Iuser user) {
        this.user = user;
    }

    // 聚会开始
    public void startEat() {
        ArrayList<String> listFood = new ArrayList<>();
        listFood.add("鲍鱼");
        listFood.add("龙虾");
        listFood.add("火锅");
        List<String> say = user.eat(listFood);
        if (say != null) {
            System.out.println("还说 " + say.stream().collect(Collectors.joining(",")));
        }
    }
}

/*********************************************************
 ** 父母的实现类
 ** <br><br>
 ** Date: Created in 2024/7/13 15:51
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class Parent implements Iuser {

    /**
     * 吃东息，人就是要吃东西的
     *
     * @param listFood 多种食物
     * @return 对食物的评价（测试使用）
     * @author :loulan
     */
    @Override
    public List<String> eat(List<String> listFood) {
        if (null == listFood || listFood.size() == 0) {
            System.out.println("父母什么都没有吃到");
            return List.of("饿", "没意思");
        } else {
            String foodNames = listFood.stream().collect(Collectors.joining(","));
            System.out.println("父母吃了 " + foodNames);
            return List.of("不错", "好吃");
        }
    }
}

/*********************************************************
 ** 老师的实现类
 ** <br><br>
 ** Date: Created in 2024/7/13 15:51
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class Teacher implements Iuser {

    /**
     * 吃东息，人就是要吃东西的
     *
     * @param listFood 多种食物
     * @return 对食物的评价（测试使用）
     * @author :loulan
     */
    @Override
    public List<String> eat(List<String> listFood) {
        if (null == listFood || listFood.size() == 0) {
            System.out.println("老师什么都没有吃到");
            return List.of("饿", "没意思");
        } else {
            String foodNames = listFood.stream().collect(Collectors.joining(","));
            System.out.println("老师吃了 " + foodNames);
            return List.of("不错", "好吃");
        }
    }
}


/*********************************************************
 ** 朋友的实现类
 ** <br><br>
 ** Date: Created in 2024/7/13 15:51
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class Friend implements Iuser {

    /**
     * 吃东息，人就是要吃东西的
     *
     * @param listFood 多种食物
     * @return 对食物的评价（测试使用）
     * @author :loulan
     */
    @Override
    public List<String> eat(List<String> listFood) {
        if (null == listFood || listFood.size() == 0) {
            System.out.println("朋友什么都没有吃到");
            return List.of("饿", "没意思");
        } else {
            String foodNames = listFood.stream().collect(Collectors.joining(","));
            System.out.println("朋友吃了 " + foodNames);
            return List.of("不错", "好吃");
        }
    }
}

/*********************************************************
 ** 人的接口
 ** <br><br>
 ** Date: Created in 2024/7/13 15:46
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface Iuser {

    /**
     * 吃东息，人就是要吃东西的
     *
     * @param listFood 多种食物
     * @return 对食物的评价（测试使用）
     * @author :loulan
     */
    public List<String> eat(List<String> listFood);
}
