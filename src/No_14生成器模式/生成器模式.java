package No_14生成器模式;

public class 生成器模式 {
    public static void main(String[] args) {
        Student build = new Student.Builder().address("深圳龙岗").age(11).name("zhansan").build();
        System.out.println(build);

    }
}
class Student{
    private String name;
    private int age;
    private String address;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    public static Builder newStudent() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private int age;
        private String address;

        public Builder() {
        }

        public Student build() {
            return new Student(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }
    }
}

