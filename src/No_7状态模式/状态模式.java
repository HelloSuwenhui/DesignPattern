package No_7状态模式;

public class 状态模式 {
    public static void main(String[] args) {
        Context context = new Context();
        context.changeStatus(new Happy());
        context.dosomething();
        context.changeStatus(new Sad());
        context.dosomething();
    }
}

abstract class Status {
    public abstract void handle();
}

class Happy extends Status {

    @Override
    public void handle() {
        System.out.println("happy to do something");
    }
}

class Sad extends Status {

    @Override
    public void handle() {
        System.out.println("sad to do something");
    }
}

class Context {
    private Status status;

    public void changeStatus(Status status) {
        this.status = status;
    }

    public void dosomething() {
        status.handle();
    }

}