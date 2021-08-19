package 工厂模式;

import 工厂模式.phone.HuaWeiPhone;
import 工厂模式.phone.IPhone;
import 工厂模式.phone.Phone;

import java.util.HashMap;
import java.util.Map;

public class 工厂模式 {
    public static void main(String[] args) {
        PhoneFactory apple = PhoneFactoryPattern.getPhoneFactory("apple");
        apple.create().print();
    }
}

//创建工厂的工厂
class PhoneFactoryPattern {
    private static final Map<String, PhoneFactory> PHONE_FACTORY_MAP = new HashMap<>();

    static {
        PHONE_FACTORY_MAP.put("apple", new IPhoneFactory());
        PHONE_FACTORY_MAP.put("huawei", new HuaWeiPhoneFactory());
    }

    public static PhoneFactory getPhoneFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        return PHONE_FACTORY_MAP.get(type);
    }
}

abstract class PhoneFactory {
    public abstract Phone create();
}

class IPhoneFactory extends PhoneFactory {

    @Override
    public Phone create() {
        return new IPhone();
    }
}

class HuaWeiPhoneFactory extends PhoneFactory {

    @Override
    public Phone create() {
        return new HuaWeiPhone();
    }
}
