package io.github.loulangogogo.test11;

/*********************************************************
 ** 责任链模式的测试
 **
 ** @author loulan
 ** @since 17
 *********************************************************/
public class TestZRL {
    public static void main(String[] args) {
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        Handler h3 = new ConcreteHandler3();
        h1.setNext(h2);
        h2.setNext(h3);

        h1.handlerData(new Request());
    }
}

/*********************************************************
 ** 请求待处理对象
 **
 ** @author loulan
 ** @since 17
 *********************************************************/
class Request{

    // 获取请求的处理登记，可以是对象枚举，也可以是数字
    public int getHandlerLevel(){
        return 2;
    }
}

/*********************************************************
 ** 处理者抽象类
 **
 ** @author loulan
 ** @since 17
 *********************************************************/
abstract class Handler {
    private Handler nextHandler;

    public void setNext(Handler _handler) {
        this.nextHandler = _handler;
    }

    public final void handlerData(Request request) {
        // 判断当前处理者能够处理该数据
        if (this.getHandlerLevel() == request.getHandlerLevel()) {
            this.handleRequest(request);
        } else {
            // 不能处理就交给下级处理
            if (this.nextHandler != null) {
                this.nextHandler.handlerData(request);
            } else {
                // 没有下级就提示
                System.err.println("无法处理该请求");
            }
        }
    }

    // 获取处理器能狗处理的等级
    protected abstract int getHandlerLevel();
    // 进行请求数据的处理
    protected abstract void handleRequest(Request request);
}

class ConcreteHandler1 extends Handler {

    @Override
    protected int getHandlerLevel() {
        return 1;
    }

    @Override
    protected void handleRequest(Request request) {
        System.out.println("1---处理该请求了");
    }
}

class ConcreteHandler2 extends Handler {

    @Override
    protected int getHandlerLevel() {
        return 2;
    }

    @Override
    protected void handleRequest(Request request) {
        System.out.println("2---处理该请求了");
    }
}

class ConcreteHandler3 extends Handler {

    @Override
    protected int getHandlerLevel() {
        return 3;
    }

    @Override
    protected void handleRequest(Request request) {
        System.out.println("3---处理该请求了");
    }
}
