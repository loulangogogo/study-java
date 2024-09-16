package io.github.loulangogogo.test09;

import java.util.ArrayList;

/*********************************************************
 ** 组合模式测试
 ** <br><br>
 ** Date: Created in 2024/8/14 11:32
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class TestZH {
    public static void main(String[] args) {
        Composite root = new Composite();
        root.doSomething();
        Composite branch = new Composite();
        Leaf leaf = new Leaf();
        root.add(branch);
        branch.add(leaf);
    }
}

/*********************************************************
 ** 树枝节点
 ** <br><br>
 ** Date: Created in 2024/8/14 11:35
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class Composite extends Component {

    private ArrayList<Component> list = new ArrayList<>();

    public void add (Component component){
        this.list.add(component);
    }

    public void remove (Component component){
        this.list.remove(component);
    }

    public ArrayList<Component> getChildren() {
        return this.list;
    }

    public void doSomething() {
        System.out.println("doSomething");
    }
}

/*********************************************************
 ** 叶子节点
 ** <br><br>
 ** Date: Created in 2024/8/14 11:35
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
class Leaf extends Component {
    public void add (Component component){
        throw new RuntimeException("叶子节点用不上");
    }

    public void remove (Component component){
        throw new RuntimeException("叶子节点用不上");
    }

    public ArrayList<Component> getChildren() {
        throw new RuntimeException("叶子节点用不上");
    }
    public void doSomething() {
        System.out.println("doSomething");
    }
}

/*********************************************************
 ** 抽象构件
 ** <br><br>
 ** Date: Created in 2024/8/14 11:34
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
abstract class Component {

    public abstract void add (Component component);

    public abstract void remove (Component component);

    public abstract ArrayList<Component> getChildren();
    public void doSomething() {
        System.out.println("doSomething");
    }
}
