package ru.stqa.ln.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddNew();
            app.getContactHelper().createContact(new ContactData("Ivan", "Ivanov", "89876543210", "test@test.ru", "test1"), true);
            app.getNavigationHelper().gotoHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initModificationContact(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Стас", "Поляничко", "89873216540", "edit@edit.ru", null);
        app.getContactHelper().fillNewContact(contact, false);
        app.getContactHelper().submitUpdateContact();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
