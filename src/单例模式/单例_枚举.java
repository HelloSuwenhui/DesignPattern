package 单例模式;

import java.util.concurrent.atomic.AtomicLong;

public enum 单例_枚举 {

    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
