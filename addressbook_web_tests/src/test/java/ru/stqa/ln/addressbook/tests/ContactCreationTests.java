package ru.stqa.ln.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ln.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoAddNew();
        app.getContactHelper().fillNewContact(new ContactData("Stas", "Polianichko", "89173041001", "test@test.ru", "test1"), true);
        app.getContactHelper().submitNewContact();
        app.getNavigationHelper().gotoHomePage();
    }

}