package No_6外观模式;

public class 外观模式 {
    public static void main(String[] args) {
        System.out.println(new Facade().prove());
    }
}

//外观模式 必须满足所有条件
class Facade{
   private SubFolw1 subFolw1 = new SubFolw1();
   private SubFolw2 subFolw2 = new SubFolw2();
   private SubFolw3 subFolw3 = new SubFolw3();
  public boolean prove(){
        return subFolw1.isTrue() && subFolw2.isTrue() && subFolw3.isTrue();
    }
}
//条件1
class SubFolw1{
    boolean isTrue(){
        //判断
        return true;
    }
}
//条件2
class SubFolw2{
    boolean isTrue(){
        //判断
        return true;
    }
}
//条件3
class SubFolw3{
    boolean isTrue(){
        //判断
        return true;
    }
}