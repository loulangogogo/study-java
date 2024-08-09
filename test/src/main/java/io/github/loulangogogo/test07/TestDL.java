package io.github.loulangogogo.test07;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*********************************************************
 ** 代理模式的测试
 ** <br><br>
 ** Date: Created in 2024/8/9 15:57
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestDL {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Subject proxy = DynamicProxy.newProxyInstance(Subject.class.getClassLoader(),
                subject.getClass().getInterfaces(),
                new MyProxyInvocationHandler(subject));
        proxy.business();
    }
}

/*********************************************************
 ** 动态代理类
 ** <br><br>
 ** Date: Created in 2024/8/9 17:44
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class DynamicProxy{
    public static <T> T newProxyInstance(ClassLoader loader,
                                         Class<?>[] interfaces,
                                         InvocationHandler h) {
        return (T) Proxy.newProxyInstance(loader, interfaces, h);
    }
}

class MyProxyInvocationHandler implements InvocationHandler {
    // 被代理的目标对象
    private Object target = null;

    public MyProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前");
        Object obj = method.invoke(this.target, args);
        System.out.println("方法执行后");
        return obj;
    }
}

/*********************************************************
 ** 主体实现类
 ** <br><br>
 ** Date: Created in 2024/8/9 15:59
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class RealSubject implements Subject {

    // 业务方法操作
    @Override
    public void business() {
        System.out.println("执行业务逻辑");
    }
}

/*********************************************************
 ** 抽象主体接口
 ** <br><br>
 ** Date: Created in 2024/8/9 15:58
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
interface Subject{
    // 业务方法
    public void business();
}

