package io.github.loulangogogo.test01;

import java.util.ArrayList;
import java.util.List;

public class Son extends  Father{

    public SonArrayLIst<User>  eat(SonArrayLIst<User>  arrayList) {
        System.out.println("我是子类");
        return new SonArrayLIst<User> ();
    }
}
