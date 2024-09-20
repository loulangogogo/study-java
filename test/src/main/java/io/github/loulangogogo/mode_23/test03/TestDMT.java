package io.github.loulangogogo.mode_23.test03;

import java.util.ArrayList;
import java.util.List;

/*********************************************************
 ** 测试迪米特原则
 ** <br><br>
 ** Date: Created in 2024/7/16 10:13
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestDMT {
    public static void main(String[] args) {
        Leader leader = new Leader();

        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            userList.add(new User());
        }

        // 领导要求部门经理去统计部门人数
        leader.command(new Manager(userList));
    }
}

/*********************************************************
 ** 定义一个领导
 ** <br><br>
 ** Date: Created in 2024/7/16 10:56
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class Leader{

    // 下命令要求统计部门经理统计人数
    public void command(Manager manager){
        manager.countUser();
    }
}


/*********************************************************
 ** 定义一个部门经理
 ** <br><br>
 ** Date: Created in 2024/7/16 10:56
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class Manager{

    // 部门人员
    private List<User> users;

    // 部门经理创建的时候应该告诉对方，你的手底下的人
    public Manager(List<User> users) {
        this.users = users;
    }

    // 统计部门人数
    public void countUser(){
        System.out.println("我们部门的人数是 "+users.size());
    }
}

/*********************************************************
 ** 定义一个用户空类
 ** <br><br>
 ** Date: Created in 2024/7/16 10:32
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class User{

}
