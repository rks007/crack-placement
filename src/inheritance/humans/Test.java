package inheritance.humans;

public class Test {
    public static void main(String[] args) {
        Child child = new Child();

        child.setName("aarush");
        child.setAge(5);

        Parent parent = new Parent();
        parent.setName("mukesh");
        parent.setAge(30);

        System.out.println(child.getName());
        System.out.println(child.hasSuperPower());

    }
}
