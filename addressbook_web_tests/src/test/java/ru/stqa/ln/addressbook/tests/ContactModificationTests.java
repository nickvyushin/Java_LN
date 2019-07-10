package ru.stqa.ln.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddNew();
            app.getContactHelper().createContact(new ContactData("Ivan", "Ivanov", "89876543210", "test@test.ru", "test1"), true);
            app.getNavigationHelper().gotoHomePage();
        }
        app.getContactHelper().initModificationContact();
        app.getContactHelper().fillNewContact(new ContactData("Edit", "Edit", "89873216540", "edit@edit.ru", null), false);
        app.getContactHelper().submitUpdateContact();
        app.getNavigationHelper().gotoHomePage();
    }
}
