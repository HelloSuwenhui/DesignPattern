package No_11模板方法模式;

public class 模板方法模式 {
    public static void main(String[] args) {
        Game gameOne = new GameOne();
        gameOne.play();
        Game gameTwo = new GameTwo();
        gameTwo.play();

    }
}

//模板
abstract class Game {
    abstract void initGame();

    abstract void startGame();

    abstract void endGame();

    public final void play() {
        System.out.println("-------------");
        initGame();
        startGame();
        endGame();
        System.out.println("--------------");
    }
}

//Game one
class GameOne extends Game {

    @Override
    void initGame() {
        System.out.println("game one init");
    }

    @Override
    void startGame() {
        System.out.println("game one start");
    }

    @Override
    void endGame() {
        System.out.println("game one end");
    }
}

//Game two
class GameTwo extends Game {

    @Override
    void initGame() {
        System.out.println("game two init");
    }

    @Override
    void startGame() {
        System.out.println("game two start");
    }

    @Override
    void endGame() {
        System.out.println("game two end");
    }
}