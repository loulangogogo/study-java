package io.github.loulangogogo.test00;

import io.gitee.loulan_yxq.owner.core.collection.CollTool;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*********************************************************
 ** 线程安全
 ** <br><br>
 ** Date: Created in 2024/6/20 16:26
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class ThreadSafe {

    private List<Integer> intList;

    @Before
    public void before() {
        intList = CollTool.arrayList();
        for (int i = 0; i < 1000; i++) {
            intList.add(i);
        }
    }

    @Test
    public void test01() {
        // 多线程数据存储list
        List<Integer> list_parallelStream = CollTool.list();
//        List<Integer> list_parallelStream = new Vector<>();
        // 单线程数据存储list
        List<Integer> list_stream = CollTool.list();

        // 多线程操作
        intList.parallelStream().forEach(o -> list_parallelStream.add(o));
        // 单线程操作
        intList.stream().forEach(o -> list_stream.add(o));

        // 打印数据集合的大小
        System.out.println("intList的大小 = " + intList.size());
        System.out.println("list_parallelStream的大小 = " + list_parallelStream.size());
        System.out.println("list_stream的大小 = " + list_stream.size());
    }
}
