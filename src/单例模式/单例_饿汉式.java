package 单例模式;

import java.util.concurrent.atomic.AtomicLong;

public class 单例_饿汉式 {

    //类加载时创建好实例
    private static final 单例_饿汉式 instance = new 单例_饿汉式();

    //构造私有化
    private 单例_饿汉式() {
    }

    //提供获取实例方法
    public static 单例_饿汉式 getInstance() {
        return instance;
    }

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
