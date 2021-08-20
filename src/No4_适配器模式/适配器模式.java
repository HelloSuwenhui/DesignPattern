package No4_适配器模式;

public class 适配器模式 {
    public static void main(String[] args) {
        //通过 适配器（手语老师） 将 新闻主持人 讲的话翻译成手语形式
        Translator signLanguage = new SignLanguageTeacher(new Speaker());
        System.out.println(signLanguage.translate());
    }
}

//新闻主持人
class Speaker {
    public String speak() {
        return "Speak speak something";
    }
}

//翻译接口
interface Translator {
    String translate();
}

//适配器-- 手语老师
class SignLanguageTeacher implements Translator {
    private Speaker speaker;

    public SignLanguageTeacher(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public String translate() {
        String word = speaker.speak();
        //进行翻译
        return word + " 的手语";
    }
}