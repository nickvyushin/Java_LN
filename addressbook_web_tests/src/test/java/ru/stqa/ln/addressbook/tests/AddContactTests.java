package ru.stqa.ln.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;
import ru.stqa.ln.addressbook.model.Contacts;
import ru.stqa.ln.addressbook.model.GroupData;
import ru.stqa.ln.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withFirstName("Tania").withLastName("Ivanova").withEmail("test@test.test").withMobilePhone("6214521483"), true);
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Test11").withFooter("Test22").withHeader("Test33"));
        }
    }

    @Test
    public void testAddContact() {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        ContactData addedContact = contacts.iterator().next();
        GroupData toGroup = groups.iterator().next();
        Groups before = addedContact.getGroups();
        Contacts groupContacts = toGroup.getContacts();
        if (groupContacts.contains(addedContact)) {
            for (GroupData group : groups.without(toGroup)) {
                Contacts contactsInGroup = group.getContacts();
                if (!contactsInGroup.contains(addedContact)) {
                    toGroup = group;
                }
            }
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Test11").withFooter("Test22").withHeader("Test33"));
            for (GroupData groupNew : app.db().groups()) {
                if (groupNew.getName().equals("Test11")) {
                    toGroup = groupNew;
                }
            }
        }
        app.goTo().home();
        app.contact().addToGroup(addedContact, toGroup);
        Groups after = addedContact.getGroups();
        assertThat(before, equalTo(after));
    }
}
