package No5_观察者模式;

import java.util.ArrayList;
import java.util.List;

public class 观察者模式 {
    //定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
    public static void main(String[] args) {

        Subject subject = new Subject();
        HexaObserver zhangsan = new HexaObserver("zhangsan", 500);
        HexaObserver lisi = new HexaObserver("lisi", 1000);
        //向张三借了100
        subject.borrow(zhangsan, 100);
        //向李四借了300
        subject.borrow(lisi, 300);
        zhangsan.print();
        lisi.print();

        //还钱
        subject.payBack(100);
        zhangsan.print();
        lisi.print();
    }
}

// 接口或抽象类 观察者 (借款人)
abstract class Observer {
    private String name;
    private Integer money;

    public abstract void update(Integer money);

    public void print() {
        System.out.println(name + "的money:" + money);
    }

    public Observer(String name, Integer money) {
        this.name = name;
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}

//观察者
class HexaObserver extends Observer {

    public HexaObserver(String name, Integer money) {
        super(name, money);
    }

    @Override
    public void update(Integer money) {
        setMoney(getMoney() + money);
    }
}

//被观察者 （还款人）
class Subject {
    // 债主列表
    private List<Observer> observers = new ArrayList<>();


    public void payBack(int money) {
        //通知债主
        notifyAllObservers(money);
    }

    public void borrow(Observer observer, int money) {
        observers.add(observer);
        observer.update(-money);
    }

    private void notifyAllObservers(int money) {
        for (Observer observer : observers) {
            observer.update(money);
        }
    }
}


