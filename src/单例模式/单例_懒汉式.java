package 单例模式;

import java.util.concurrent.atomic.AtomicLong;

public class 单例_懒汉式 {
    //支持延迟加载
    private static 单例_懒汉式 instance;

    //构造私有化
    private 单例_懒汉式() {
    }

    //提供获取实例方法 synchronized锁
    public static synchronized 单例_懒汉式 getInstance() {
        if (instance == null) {
            instance = new 单例_懒汉式();
        }
        return instance;
    }

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
