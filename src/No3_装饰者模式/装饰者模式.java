package No3_装饰者模式;

import No3_装饰者模式.Robot.Robot;

public class 装饰者模式 {


}

abstract class RobotDecorator extends Robot {
    private Robot robot;

    public RobotDecorator(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void say() {
        robot.say();
    }

    @Override
    public void move() {
        //对原来的功能进行加强
        System.out.println("do something more");
        robot.move();
    }

    //添加新的功能
    public void fly() {
        System.out.println("i can fly");
    }
}

