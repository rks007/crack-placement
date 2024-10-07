package oops;

public class inheritance {
    public static class Shape{
        String color;
    }
    public static class Triangle extends Shape{

    }

    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        t1.color = "red";
        System.out.println(t1.color);
    }
}
