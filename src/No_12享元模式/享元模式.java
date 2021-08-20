package No_12享元模式;

import java.util.HashSet;
import java.util.Set;

public class 享元模式 {
    public static void main(String[] args) {
        BikeFlyWeightFactory factory = BikeFlyWeightFactory.getInstance();
        Bike bike01 = factory.getBike();
        bike01.ride("zhangsan");
        Bike bike02 = factory.getBike();
        bike02.ride("lisi");
        bike02.payback();
        bike01.payback();
        Bike bike03 = factory.getBike();
        bike03.ride("wangwu");
        Bike bike04 = factory.getBike();
        bike04.ride("zhaoliu");
    }
}

abstract class Bike {
    protected int id;

    public Bike(int id) {
        this.id = id;
    }

    public void ride(String useName) {
        System.out.println(useName + "在骑行 单车" + id);
    }

    abstract void payback();
}

class BikeFlyWeight extends Bike {
    private boolean status = true;

    public BikeFlyWeight(int id) {
        super(id);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //借车
    public void ride(String useName) {
        if (status) {
            super.ride(useName);
        }
        status = false;
    }

    //还车
    public void payback() {
        status = true;
        System.out.println("单车" + id + "payback");
    }
}

class BikeFlyWeightFactory {
    private static BikeFlyWeightFactory instance = new BikeFlyWeightFactory();
    private Set<BikeFlyWeight> bikePool = new HashSet<>();

    private BikeFlyWeightFactory() {
        for (int i = 0; i < 12; i++) {
            bikePool.add(new BikeFlyWeight(i));
        }
    }

    public static BikeFlyWeightFactory getInstance() {
        return instance;
    }

    public Bike getBike() {
        for (BikeFlyWeight bikeFlyWeight : bikePool) {
            if (bikeFlyWeight.isStatus()) return bikeFlyWeight;
        }
        return null;
    }
}