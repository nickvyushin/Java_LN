package ru.stqa.ln.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddNew();
            app.getContactHelper().createContact(new ContactData("Ivan", "Ivanov", "89876543210", "test@test.ru", "test1"), true);
            app.getNavigationHelper().gotoHomePage();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().assertConfirmation();
        app.getNavigationHelper().gotoHome();
    }
}
