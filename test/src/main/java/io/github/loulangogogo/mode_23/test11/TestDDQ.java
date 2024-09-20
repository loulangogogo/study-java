package io.github.loulangogogo.mode_23.test11;

import java.util.Vector;

/*********************************************************
 ** 迭代器模式测试
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
public class TestDDQ {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("123");
        aggregate.add("abc");
        aggregate.add("a12");
        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

/*********************************************************
 ** 抽象容器的实现类
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class ConcreteAggregate implements Aggregate {

    private Vector vector = new Vector();

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this.vector);
    }

    @Override
    public void add(Object object) {
        this.vector.add(object);
    }

    @Override
    public void remove(Object object) {
        this.vector.remove(object);
    }
}

/*********************************************************
 ** 抽象容器
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
interface Aggregate {

    Iterator iterator();

    public void add(Object object);

    public void remove(Object object);
}

/*********************************************************
 ** 迭代器的实现类
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class ConcreteIterator implements Iterator {

    private Vector vector = new Vector();

    // 定义当前游标
    public int cursor = 0;


    public ConcreteIterator(Vector vector) {
        this.vector = vector;
    }

    @Override
    public boolean hasNext() {
        if (this.cursor >= this.vector.size()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Object result = null;
        if (this.hasNext()) {
            result = this.vector.get(this.cursor++);
        } else {
            result = null;
        }
        return result;
    }

    @Override
    public void remove() {
        this.vector.remove(this.cursor);
    }
}

/*********************************************************
 ** 迭代器接口
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
interface Iterator {
    boolean hasNext();
    Object next();
    void remove();
}
