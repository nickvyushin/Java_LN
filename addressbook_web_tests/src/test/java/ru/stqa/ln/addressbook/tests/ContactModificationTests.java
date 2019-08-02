package ru.stqa.ln.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;
import ru.stqa.ln.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all2().size() == 0) {
            app.goTo().addNew();
            app.contact().create(new ContactData()
                    .withFirstName("Tania").withLastName("Ivanova").withEmail("test@test.test").withMobilePhone("6214521483"), true);
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all2();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId())
                .withFirstName("Stas").withLastName("Pol").withMobilePhone("89873216540").withEmail("edit@edit.ru");
        app.contact().modify(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all2();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }

}
