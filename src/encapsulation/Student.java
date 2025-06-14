package encapsulation;

public class Student {
    private String name;
    private int rollNo;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        this.age = age;
        if(age < 0){
            this.age = 0;
        }
    }
}
