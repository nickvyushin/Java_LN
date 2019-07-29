package ru.stqa.ln.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.goTo().gotoAddNew();
        ContactData contact = new ContactData("Иван", "Иванов", "89173041001", "test@test.ru", "test1");
        app.getContactHelper().fillNewContact(contact, true);
        app.getContactHelper().submitNewContact();
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        //(o1, o2) -> Integer.compare(o1.getId(), o2.getId())
        //contact.setId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}