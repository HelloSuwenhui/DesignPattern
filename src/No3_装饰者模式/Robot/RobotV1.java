package No3_装饰者模式.Robot;

public class RobotV1 extends Robot {
    @Override
    public void say() {
        System.out.println("say something");
    }

    @Override
    public void move() {
        System.out.println("move");
    }
}
