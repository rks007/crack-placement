package oops;

public class constructors {
    public static class Pen{
        String color;
        int price;

        public Pen(String color, int price){
            this.color = color;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Pen montex = new Pen("blue", 10);
        System.out.println(montex.color + " " + montex.price);
    }
}
