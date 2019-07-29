package ru.stqa.ln.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        if (! app.getContactHelper().isThereAContact()) {
            app.goTo().gotoAddNew();
            app.getContactHelper().createContact(new ContactData("Ivan", "Ivanov", "89876543210", "test@test.ru", "test1"), true);
            app.goTo().gotoHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().assertConfirmation();
        app.goTo().gotoHome();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }
}
