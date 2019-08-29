package ru.stqa.ln.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;
import ru.stqa.ln.addressbook.model.Contacts;
import ru.stqa.ln.addressbook.model.GroupData;
import ru.stqa.ln.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withFirstName("Tania").withLastName("Ivanova").withEmail("test@test.test").withMobilePhone("6214521483"), true);
        }
        app.goTo().groupPage();
        if (app.db().groups().size() == 0) {
            app.group().create(new GroupData().withName("Test11").withFooter("Test22").withHeader("Test33"));
        }
    }

    @Test
    public void testRemoveContact() {
        app.goTo().home();
        Contacts contacts = app.db().contacts();
        ContactData contactInGroup = contacts.iterator().next();
        Groups groupsBefore = contactInGroup.getGroups();
        if (groupsBefore.size() == 0) {
            Groups groups = app.db().groups();
            GroupData groupToAdd = groups.iterator().next();
            app.contact().addToGroup(contactInGroup, groupToAdd);
        }
        GroupData group = groupsBefore.iterator().next();
        app.goTo().home();
        app.contact().removeFromGroup(contactInGroup, group);
        Contacts contacts1 = app.db().contacts();
        ContactData contactFromGroup = contacts1.iterator().next();

        Groups groupsAfter = contactFromGroup.getGroups();
        assertThat(groupsAfter, equalTo(groupsBefore.without(group)));

    }
}
