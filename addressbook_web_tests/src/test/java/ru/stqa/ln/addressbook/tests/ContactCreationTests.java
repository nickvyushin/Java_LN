package ru.stqa.ln.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;
import ru.stqa.ln.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        Contacts before = app.contact().all2();
        File photo = new File("src/test/resources/imgs.jpg");
        ContactData contact = new ContactData()
                .withFirstName("Piter").withLastName("Petrovich").withEmail("test@test.test").withMobilePhone("5439876554")
                .withPhoto(photo);
        app.goTo().addNew();
        app.contact().create(contact, true);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all2();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void testBadContactCreation() {
        Contacts before = app.contact().all2();
        ContactData contact = new ContactData()
                .withFirstName("Piter").withLastName("Petrovich").withEmail("test@test.test").withMobilePhone("5439876554")
                .withGroup("Test11");
        app.goTo().addNew();
        app.contact().create(contact, true);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all2();
        assertThat(after, equalTo(before));
    }

}