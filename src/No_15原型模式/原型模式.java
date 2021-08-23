package No_15原型模式;

public class 原型模式 {
    public static void main(String[] args) {
        Student student = new Student("zhangsan", "深圳", 12);
        System.out.println(student);
        Student clone = student.clone();
        System.out.println(clone);
    }
}
class Student  {
    private String name;
    private String address;
    private int id;

    public Student clone(){
        return new Student(name, address, id);
    }

    public Student() {
    }

    public Student(String name, String address, int id) {
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }
}
