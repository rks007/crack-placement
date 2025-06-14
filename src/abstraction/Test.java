package abstraction;

public class Test { //you cannot create object of abstract class
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal cat = new Cat();

        cat.sayHello();

        dog.sayHello();
    }
}
