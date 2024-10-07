package oops;

class Candidate{
    int rollno;
    static String academyName; //static mens this value will be same for the all objects created through this class
}
public class staticKeyWord {
    public static void main(String[] args) {
        Candidate.academyName = "aakash"; //you can acces static variable without creating an object, directly through name of class, like here we are doing
        Candidate xyz = new Candidate();
        xyz.rollno = 24;
        System.out.println(xyz.academyName);
    }
}
