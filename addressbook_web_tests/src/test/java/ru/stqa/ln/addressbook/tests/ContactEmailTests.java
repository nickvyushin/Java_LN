package ru.stqa.ln.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

    @Test
    public void testContactEmail() {

        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoAboutEmail = app.contact().infoAboutEmail(contact);

        assertThat(contact.getEmail(), equalTo(contactInfoAboutEmail.getEmail()));
    }
}
