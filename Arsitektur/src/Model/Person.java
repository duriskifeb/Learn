package Model;

public class Person {
    private String firstName;
    private String lastName;
    private String idNumber;

    public Person(String firstname, String lastname, String idNumber) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.idNumber = idNumber;
    }

    public void getFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    
}
