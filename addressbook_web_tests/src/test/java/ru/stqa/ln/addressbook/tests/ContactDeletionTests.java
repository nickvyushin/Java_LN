package ru.stqa.ln.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;
import ru.stqa.ln.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.goTo().addNew();
            app.contact().create(new ContactData().withFirstName("Piter").withLastName("Petrovich").withEmail("test@test.test").withMobilePhone("5439876554").withGroup("Test11"), true);
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.contact().all2();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().Home();
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.contact().all2();
        assertThat(after, equalTo(before.without(deletedContact)));

    }

}
