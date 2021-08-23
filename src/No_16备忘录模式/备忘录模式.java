package No_16备忘录模式;

import javax.print.Doc;
import java.util.Stack;

public class 备忘录模式 {
    public static void main(String[] args) {
        History history = new History();
        Document doc = new Document("abc");
        history.add(doc.save());
        doc.change("def");
        history.add(doc.save());
        doc.change("ghi");
        history.add(doc.save());
        doc.change("lmn");
        doc.resume(history.getLastVersion());
        doc.resume(history.getLastVersion());
        doc.resume(history.getLastVersion());
        doc.print();//abc
    }
}

class Document {
    private String content;

    public Document() {
    }

    public Document(String content) {
        this.content = content;
    }

    public void change(String content) {
        this.content = content;
    }

    public Document save() {
        return new Document(content);
    }

    public void resume(Document document) {
        this.content = document.content;
    }

    public void print() {
        System.out.println(content);
    }
}

class History {
    private Stack<Document> stack = new Stack<>();

    public void add(Document document) {
        stack.add(document);
    }
    public Document getLastVersion(){
        return stack.pop();
    }
}
