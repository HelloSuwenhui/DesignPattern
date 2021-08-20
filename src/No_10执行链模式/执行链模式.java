package No_10执行链模式;

public class 执行链模式 {
    //拦截器
    public static void main(String[] args) {
        Handler handler = new Handler1();
        handler.setNextHandlerl(new Handler2()).setNextHandlerl(new Handler3());
        handler.process(5);
        handler.process(15);
        handler.process(25);
        handler.process(35);
    }
}

abstract class Handler {
    protected Handler nextHandler;

    public Handler setNextHandlerl(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public abstract void process(Integer info);
}

class Handler1 extends Handler {

    @Override
    public void process(Integer info) {
        if (info <= 10) {
            System.out.println("Handler1 headle");
        }else{
            if (this.nextHandler != null) {
                nextHandler.process(info);
            }
        }
    }
}
class Handler2 extends Handler {

    @Override
    public void process(Integer info) {
        if (info <= 20) {
            System.out.println("Handler2 headle");
        }else{
            if (this.nextHandler != null) {
                nextHandler.process(info);
            }
        }
    }
}
class Handler3 extends Handler {

    @Override
    public void process(Integer info) {
        if (info <= 30) {
            System.out.println("Handler3 headle");
        }else{
            if (this.nextHandler != null) {
                nextHandler.process(info);
            }
        }
    }
}
