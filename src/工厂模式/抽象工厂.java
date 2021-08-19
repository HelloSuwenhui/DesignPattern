package 工厂模式;

import 工厂模式.Mask.KN90;
import 工厂模式.Mask.Mask;
import 工厂模式.Mask.N95;
import 工厂模式.phone.HuaWeiPhone;
import 工厂模式.phone.IPhone;
import 工厂模式.phone.Phone;

import java.util.HashMap;
import java.util.Map;

public class 抽象工厂 {
    public static void main(String[] args) {
        Factory factory = FactoryPattern.getFactory("KN90");
        factory.createMask().print();
    }
}

//创建工厂的工厂
class FactoryPattern {
    private static final Map<String, Factory> PHONE_FACTORY_MAP = new HashMap<>();

    static {
        FactoryA factoryA = new FactoryA();
        PHONE_FACTORY_MAP.put("apple", factoryA);
        PHONE_FACTORY_MAP.put("N95", factoryA);
        FactoryB factoryB = new FactoryB();
        PHONE_FACTORY_MAP.put("huawei", factoryB);
        PHONE_FACTORY_MAP.put("KN90", factoryB);
    }

    public static Factory getFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        return PHONE_FACTORY_MAP.get(type);
    }
}

//可以生成多种产品的抽象工厂
abstract class Factory {
    public abstract Phone createPhone();

    public abstract Mask createMask();
}

class FactoryA extends Factory {

    @Override
    public Phone createPhone() {
        return new IPhone();
    }

    @Override
    public Mask createMask() {
        return new N95();
    }
}

class FactoryB extends Factory {

    @Override
    public Phone createPhone() {
        return new HuaWeiPhone();
    }

    @Override
    public Mask createMask() {
        return new KN90();
    }
}
