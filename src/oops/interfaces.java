package oops;

interface Animals{
    void walk();
}

interface Carnivore{
    void eat();
}

class Dog implements Animals, Carnivore{
    @Override
    public void walk() {
        System.out.println("walks on 4 legs...");
    }

    @Override
    public void eat() {
        System.out.println("non-vegetarian");
    }
}
public class interfaces {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.walk();
        dog.eat();
    }
}
