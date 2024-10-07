package oops;

class Account{
    public String name;
    protected String email;
    private String password;

    public String getPassword() { //getter
        return this.password;
    }

    public void setPassword(String password) { //setter
        this.password = password;
    }
}
public class accessModifies {

    public static void main(String[] args) {
        Account account1 = new Account();
        account1.name = "xyz";
        account1.email = "xyz@gmail.com";

        account1.setPassword("abcd");
        System.out.println(account1.getPassword());

    }
}
