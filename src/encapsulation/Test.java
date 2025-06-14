package encapsulation;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();

        student.setAge(16);
        System.out.println(student.getAge());
    }
}
