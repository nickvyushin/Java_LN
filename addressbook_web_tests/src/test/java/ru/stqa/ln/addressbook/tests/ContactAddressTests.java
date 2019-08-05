package ru.stqa.ln.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

    @Test
    public void testContactAddress() {

        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoAboutAddress = app.contact().infoAboutAddress(contact);

        assertThat(contact.getAddress(), equalTo(contactInfoAboutAddress.getAddress()));
    }
}
