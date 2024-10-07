package oops;

public class copyContructors {
    public static class Pen{
        String brand;
        int price;

        public Pen(String brand, int price){
            this.brand = brand;
            this.price = price;
        }

        public Pen(Pen pen){ //copy constructor
            this.brand = pen.brand;
            this.price = pen.price;
        }
    }

    public static void main(String[] args) {
        Pen pen1 = new Pen("montex",10);

        Pen pen2 = new Pen(pen1);

        System.out.println("brand of pen2 is " + pen2.brand);
    }
}
