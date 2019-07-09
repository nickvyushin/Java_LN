package ru.stqa.ln.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String mobileNumber;
    private final String email;

    public ContactData(String firstName, String lastName, String mobileNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }
}
