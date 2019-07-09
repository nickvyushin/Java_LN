package ru.stqa.ln.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.ln.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(ChromeDriver wd){
        super(wd);
    }

    public void fillNewContact(ContactData contactData) {

        type(By.name("firstName"), contactData.getFirstName());
        type(By.name("lastName"), contactData.getLastName());
        type(By.name("mobile"), contactData.getMobileNumber());
        type(By.name("email"), contactData.getEmail());

    }

    public void submitNewContact() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }
}
