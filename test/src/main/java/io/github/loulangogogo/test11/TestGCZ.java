package io.github.loulangogogo.test11;

import java.util.Vector;

/*********************************************************
 ** 测试观察者模式
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
public class TestGCZ {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer = new ConcreteObserver();
        subject.addObserver(observer);
        subject.doSomething();
    }
}

/*********************************************************
 ** 具体被观察者
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class ConcreteSubject extends Subject {

    public void doSomething() {
        // 业务代码
        super.notify("业务代码执行");
    }
}

/*********************************************************
 ** 被观察者抽象类
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
abstract class Subject {
    private Vector<Observer> observers = new Vector<>();

    // 添加观察者
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    // 删除观察者
    public void delObserver(Observer observer) {
        observers.remove(observer);
    }
    // 通知观察者
    public void notify(String msg) {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }
}

/*********************************************************
 ** 具体观察者
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class ConcreteObserver implements Observer {

    @Override
    public void update(String msg) {
        System.out.println("观察者收到消息：" + msg);
    }
}

/*********************************************************
 ** 观察者接口
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
interface Observer {
    void update(String msg);
}