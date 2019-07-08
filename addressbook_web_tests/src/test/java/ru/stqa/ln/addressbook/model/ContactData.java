package ru.stqa.ln.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String mobilenumber;

    public ContactData(String firstname, String lastname, String mobilenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobilenumber = mobilenumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMnumber() {
        return mobilenumber;
    }
}
