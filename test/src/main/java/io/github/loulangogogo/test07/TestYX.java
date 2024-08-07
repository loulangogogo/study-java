package io.github.loulangogogo.test07;

import java.util.ArrayList;
import java.util.List;

/*********************************************************
 ** 原型模式的测试类
 ** <br><br>
 ** Date: Created in 2024/8/7 18:44
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestYX {
    public static void main(String[] args) {
        User user = new User();
        user.list.add("张三");
        user.list.add("李四");
        System.out.println("1-user->name = " + user.name);
        System.out.println("1-user->list = " + user.list);
        User userClone = user.clone();
        userClone.list.add("王五");
        userClone.name = "王五";
        System.out.println("2-user->name = " + user.name);
        System.out.println("2-user->list = " + user.list);
        System.out.println("2-userClone->name = " + userClone.name);
        System.out.println("2-userClone->list = " + userClone.list);
    }
}


class User implements Cloneable{

    public String name = "张三";
    // 内部对象
    public ArrayList<String> list = new ArrayList<>();

    public User() {
        System.out.println("构造函数执行了");
    }

    @Override
    protected User clone() {
        try {
            User userClone = (User) super.clone();
            userClone.list = (ArrayList<String>) this.list.clone();
            return userClone;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}