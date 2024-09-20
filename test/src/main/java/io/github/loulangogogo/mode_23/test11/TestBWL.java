package io.github.loulangogogo.mode_23.test11;

/*********************************************************
 ** 备忘录模式测试
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
public class TestBWL {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        System.out.println("发起人状态：" + originator.getState());
        caretaker.setMemento(originator.createMemento());

        originator.setState("状态改变");
        System.out.println("发起人状态：" + originator.getState());
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("发起人状态：" + originator.getState());
    }
}

/*********************************************************
 ** 备忘录管理员角色
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class Caretaker{
    private Memento memento;

    public Memento getMemento(){
        return memento;
    }

    public void setMemento(Memento memento){
        this.memento = memento;
    }
}

/*********************************************************
 ** 发起人模式
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class Originator{
    private String state;

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    // 创建一个备忘录
    public Memento createMemento(){
        return new Memento(state);
    }

    // 恢复一个备忘录
    public void restoreMemento(Memento memento){
        state = memento.getState();
    }
}

/*********************************************************
 ** 备忘录模式
 **
 ** @author loulan
 ** @since 8
 *********************************************************/
class Memento{
    private  String state;
    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }
}