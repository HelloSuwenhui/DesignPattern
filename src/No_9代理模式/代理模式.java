package No_9代理模式;

public class 代理模式 {
    public static void main(String[] args) {
        Image image = new ProxyImage("文件名 埃里克");
        image.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    @Override
    public void display() {
        System.out.println("Display " + fileName);
    }

    private void loadFromDisk() {
        System.out.println("Loading " + fileName);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}