package No2_工厂模式;

import No2_工厂模式.phone.HuaWeiPhone;
import No2_工厂模式.phone.IPhone;
import No2_工厂模式.phone.Phone;

public class 简单工厂 {
    public static void main(String[] args) {
        simpleFactory simpleFactory = new simpleFactory();
        Phone phone = simpleFactory.create("apple");
        phone.print();
        Phone phone2 = simpleFactory.create("huawei");
        phone2.print();
    }
}

class simpleFactory {
    public Phone create(String type) {
        if (type.equals("apple")) {
            return new IPhone();
        } else if (type.equals("huawei")) {
            return new HuaWeiPhone();
        } else {
            throw new RuntimeException("No Such Type !");
        }
    }
}

