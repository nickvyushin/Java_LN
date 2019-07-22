package ru.stqa.ln.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification() {
        List<ContactData> before = app.getContactHelper().getContactList();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddNew();
            app.getContactHelper().createContact(new ContactData("Ivan", "Ivanov", "89876543210", "test@test.ru", "test1"), true);
            app.getNavigationHelper().gotoHomePage();
        }
        app.getContactHelper().initModificationContact(before.size() - 1);
        app.getContactHelper().fillNewContact(new ContactData("Стас", "Поляничко", "89873216540", "edit@edit.ru", null), false);
        app.getContactHelper().submitUpdateContact();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
    }
}
