package oops2;

public class Car {
    private String color;
    private String brand;
    private String model;
    private int year;
    private int speed;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }


    public int getYear() {
        return year;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public void accelerate(int increment){
        speed += increment;
    }
    public void brake(int decrement){
        speed -= decrement;
        if(speed < 0){
            speed = 0;
        }
    }
}
