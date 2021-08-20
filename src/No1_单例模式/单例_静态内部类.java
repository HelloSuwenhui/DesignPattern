package No1_单例模式;

import java.util.concurrent.atomic.AtomicLong;

public class 单例_静态内部类 {
    //支持延迟加载

    //构造私有化
    private 单例_静态内部类() {
    }

    //静态内部类
    public static class SingletonHolder {
        private static final 单例_静态内部类 instance = new 单例_静态内部类();
    }

    //提供获取实例方法
    public static 单例_静态内部类 getInstance() {
        return SingletonHolder.instance;
    }

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
