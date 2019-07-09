package ru.stqa.ln.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification() {

        app.getContactHelper().initModificationContact();
        app.getContactHelper().fillNewContact(new ContactData("Edit", "Edit", "89873216540", "edit@edit.ru"));
        app.getContactHelper().submitUpdateContact();
        app.getNavigationHelper().gotoHomePage();
    }
}
