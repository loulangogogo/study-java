package io.github.loulangogogo.test00;

import io.github.loulangogogo.water.enums.MaskingDataTypeEnum;
import io.github.loulangogogo.water.tool.StrTool;

/*********************************************************
 ** 测试开闭原则
 ** <br><br>
 ** Date: Created in 2024/7/9 22:22
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestKB {
    public static void main(String[] args) {
        Iuser user = new PhoneMaskUser("loulan", "1234567890");

        // 获取用户的手机号码
        System.out.println(user.getPhone()); // 123****7890
    }
}

/*********************************************************
 ** 手机号吗脱敏的用户
 ** <br><br>
 ** Date: Created in 2024/7/9 23:03
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class PhoneMaskUser extends User{
    public PhoneMaskUser(String name, String phone) {
        super(name, phone);
    }

    @Override
    public String getPhone() {
        // 手机号码脱敏的方法
        return StrTool.dataMasking(super.getPhone(), MaskingDataTypeEnum.PHONE);
    }
}


/*********************************************************
 ** 用户接口实现类
 ** <br><br>
 ** Date: Created in 2024/7/9 22:28
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class User implements Iuser{
    // 用户名
    private String name;
    // 用户手机号
    private String phone;

    // 构造函数构造对象
    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // 获取用户名
    @Override
    public String getName() {
        return name;
    }

    // 获取用户手机号
    @Override
    public String getPhone() {
        return phone;
    }
}

/*********************************************************
 ** 用户接口
 ** <br><br>
 ** Date: Created in 2024/7/9 22:28
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface Iuser{
    // 获取姓名
    public String getName();
    // 获取手机号
    public String getPhone();
}
