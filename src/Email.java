import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private int mailBoxCapacity;
    private String alternateEmail;
    private String companySuffix = ".companyname.com";

    //constructor to receive firstName and lastName
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // call a method for the department - return the department
        this.department = setDepartment();

        // call a method that returns random password
        this.password = randomPassword(defaultPasswordLength);

        // combine elements to generate email
        this.email = firstName.toLowerCase() + "_" + lastName.toLowerCase() + "@" + department.toLowerCase() + companySuffix;

        System.out.println("Your password is:" + password);

    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("New Employee: " + firstName +  ". Department code: \n1 for Sales \n2 for Development \n3 for Accounting \n0 for None\nEnter Department code: ");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();

        switch(deptChoice) {
            case 1:
                return "sales";
            case 2:
                return "dev";
            case 3:
                return "acct";
            default:
                return "";
        }
    }

    // generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&*1234567890";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return new String(password);
    }

    // ste mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String altemail){
        this.alternateEmail = altemail;
    }

    // change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY " + mailBoxCapacity + "mb";
    }
}
