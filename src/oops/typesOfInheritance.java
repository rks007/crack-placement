package oops;

public class typesOfInheritance {
    public static class Shape{
        public void area(){
            System.out.println("Displays area");
        }
    }
    public static class Triangle extends Shape {
        public void area(int l , int h){
            System.out.println(1/2 * l * h);
        }
    }
    public static class EquilateralTriangle extends Triangle{
        public void area(int l, int h){
            System.out.println(1/2 * l * h);
        }
    }

    public static class Circle extends Shape{
        public void area(int r){
            System.out.println((3.14) * r * r);
        }
    }
    public static void main(String[] args) {

    }
}
