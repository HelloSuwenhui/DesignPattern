package No_8策略模式;

public class 策略模式 {
    //例如：线程池的拒绝策略等
    public static void main(String[] args) {
        StrategyUser strategyUser = new StrategyUser(new Strategy01());
        strategyUser.execute();

        strategyUser = new StrategyUser(new Strategy02());
        strategyUser.execute();
    }
}

//策略接口
interface Strategy {
    void handle();
}

//策略1
class Strategy01 implements Strategy {

    @Override
    public void handle() {
        System.out.println("执行策略1");
    }
}

//策略2
class Strategy02 implements Strategy {

    @Override
    public void handle() {
        System.out.println("执行策略2");
    }
}

//策略执行者
class StrategyUser {
    private Strategy strategy;

    public StrategyUser(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.handle();
    }
}