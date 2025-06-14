package inheritance.humans;

public class Grandparent {
    private String name;
    private int age;

    private boolean hasSuperPower;

    public boolean hasSuperPower() {
        return hasSuperPower;
    }

    public Grandparent(){
        hasSuperPower = true;
        System.out.println("GrandParent contructor called");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
