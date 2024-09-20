package io.github.loulangogogo.test00;

import lombok.extern.slf4j.Slf4j;

/*********************************************************
 ** 测试单一职责原则
 ** <br><br>
 ** Date: Created in 2024/7/11 23:12
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
@Slf4j
public class TestDY {
    public static void main(String[] args) {
        Dog dog = new Dog("小黑", "black");
        log.info("asdf");

        IdogBehavior dogBehavior = dog;
        IdogProperty dogProperty = dog;

        dogBehavior.run();
        dogBehavior.eat();
        System.out.println(dogProperty.getColor());
        System.out.println(dogProperty.getName());
    }
}

/*********************************************************
 ** 狗子行为接口
 ** <br><br>
 ** Date: Created in 2024/7/11 23:15
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface IdogBehavior{
    public void run();
    public void eat();
}

/*********************************************************
 ** 狗子的属性接口
 ** <br><br>
 ** Date: Created in 2024/7/11 23:15
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface IdogProperty{
    public void setName(String name);
    public void setColor(String color);
    public String getName();
    public String getColor();
}

/*********************************************************
 ** 狗子实现类
 ** <br><br>
 ** Date: Created in 2024/7/11 23:17
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class Dog implements IdogBehavior, IdogProperty{
    // 名字
    private String name;
    // 颜色
    private String color;

    public Dog(String name, String color){
        this.name = name;
        this.color = color;
    }

    @Override
    public void run() {
        System.out.println("Dog is running");
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getColor() {
        return color;
    }
}
