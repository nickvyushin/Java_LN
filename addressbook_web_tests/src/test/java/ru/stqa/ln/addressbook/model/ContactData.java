package ru.stqa.ln.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String mobileNumber;
    private final String email;
    private String group;

    public ContactData(String firstName, String lastName, String mobileNumber, String email, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.group = group;
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

    public String getGroup() {
        return group;
    }
}
