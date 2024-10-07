package oops;

class Student{
    int rollno;
    String name;

    public void printInfo(){
        System.out.println(this.rollno);
        System.out.println(this.name);
    }
}
public class classesAndObjects {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.rollno = 1;
        s1.name = "delta";
        s1.printInfo();
    }
}
