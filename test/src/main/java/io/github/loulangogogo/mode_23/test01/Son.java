package io.github.loulangogogo.mode_23.test01;

public class Son extends  Father{

    public SonArrayLIst<User>  eat(SonArrayLIst<User>  arrayList) {
        System.out.println("我是子类");
        return new SonArrayLIst<User> ();
    }
}
