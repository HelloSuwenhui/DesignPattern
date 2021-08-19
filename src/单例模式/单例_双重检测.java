package 单例模式;

import java.util.concurrent.atomic.AtomicLong;

public class 单例_双重检测 {
    //支持延迟加载
    private static 单例_双重检测 instance;

    //构造私有化
    private 单例_双重检测() {
    }

    //提供获取实例方法 类级别的锁
    public static 单例_双重检测 getInstance() {
        if (instance == null) {
            synchronized (单例_双重检测.class) { // 此处为类级别的锁
                if (instance == null) {
                    instance = new 单例_双重检测();
                }
            }
        }
        return instance;
    }

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
